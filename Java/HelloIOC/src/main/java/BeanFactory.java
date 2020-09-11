import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {

    // 用于存放bean实例的集合
    private Map<String, Object> beanMap = new HashMap<String, Object>();

    /**
     * bean工厂的初始化. <br>
     *
     * @param xml
     *            配置文件路径
     */
    public void init(String xml) {
        try {
            // 1.创建读取配置文件的reader对象
            SAXReader reader = new SAXReader();
            // 2.获取当前线程中的类装载器对象
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            // 3.从class目录下获取指定的xml文件
            InputStream ins = classLoader.getResourceAsStream(xml);
            // 4.使用dom4j 解析xml文件
            Document doc = reader.read(ins);
            Element root = doc.getRootElement();
            // 5.初始化bean
            setBean(root);
            // 6.注入bean的依赖关系
            setPv(root);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 初始化bean
     *
     * @param root
     *            xml文件
     * @throws Exception
     */
    public void setBean(Element root) throws Exception {
        // 1.遍历xml文件当中的Bean实例
        for (Iterator i = root.elementIterator("bean"); i.hasNext();) {
            Element foo = (Element) i.next();
            // 2.针对每个Bean实例，获取bean的属性id和class
            String id = foo.attribute("id").getText();
            String cls = foo.attribute("class").getText();
            // 3.利用Java反射机制，通过class的名称获取Class对象
            Class bean = Class.forName(cls);
            // 4.创建对象
            Object obj = bean.newInstance();
            // 5.将对象放入beanMap中，其中key为bean的id值，value为bean的实例
            beanMap.put(id, obj);
        }
    }

    /**
     * 注入bean的依赖关系
     *
     * @param root
     *            xml文件
     * @throws Exception
     */
    public void setPv(Element root) throws Exception {
        for (Iterator it = root.elementIterator("bean"); it.hasNext();) {
            Element foo = (Element) it.next();

            // 1.针对每个Bean实例，获取bean的属性id和class
            String cls = foo.attribute("class").getText();
            String id = foo.attribute("id").getText();

            // 2.利用Java反射机制，通过class的名称获取Class对象
            Class bean1 = Class.forName(cls);

            // 3.获取对应class的信息
            java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean1);

            // 4.获取其属性描述
            java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();

            // 5遍历该bean的property属性
            for (Iterator ite = foo.elementIterator("property"); ite.hasNext();) {
                Element foo2 = (Element) ite.next();

                // 6.获取该property的name属性
                String name = foo2.attribute("name").getText();
                String ref = foo2.attribute("ref").getText();

                // 7.在类中寻找与xml配置文件中该bean的property属性名相同的属性
                for (int k = 0; k < pd.length; k++) {
                    // 8.如果相等，证明已经找到对应得属性
                    if (pd[k].getName().equalsIgnoreCase(name)) {
                        Method mSet = null;
                        // 9.利用反射，获取该属性的set方法
                        mSet = pd[k].getWriteMethod();
                        // 10.用原beanMap中该bean的实例，执行该属性的set方法，并从原beanMap中获取该属性的依赖值
                        mSet.invoke(beanMap.get(id), beanMap.get(ref));
                    }
                }
                break;
            }
        }
    }

    /**
     * 通过bean的id获取bean的实例
     *
     * @param beanName
     *            bean的id
     * @return 返回对应对象
     */
    public Object getBean(String beanName) {
        Object obj = beanMap.get(beanName);
        return obj;
    }
}