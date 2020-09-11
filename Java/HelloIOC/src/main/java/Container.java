import myAnnotation.MyAutoWired;
import myAnnotation.MyComponent;
import sun.invoke.empty.Empty;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Container {

    static public BeanFactory factory;

    public Container(String xmlName) {
        factory = new BeanFactory();
        factory.init(xmlName);
    }

    public Object getBean(String beanName){
        return factory.getBean(beanName);
    }

    public Object getBeanByAnno(Class obj) {
        // 获取Filed List
        Field[] list = obj.getDeclaredFields();

        // 处理MyAutoWired注解
        for( Field field : list ) {
            if( field.isAnnotationPresent(MyAutoWired.class) ){
                Annotation annotation = field.getAnnotation(MyAutoWired.class);
                MyAutoWired myAutoWired = (MyAutoWired) annotation;
                return getBean(myAutoWired.value());
            }
        }

//        // 处理MyAutoWired注解
//        if(obj.isAnnotationPresent(MyComponent.class)){
//
//            Annotation annotation = obj.getAnnotation(MyComponent.class);
//            MyComponent myComponent = (MyComponent) annotation;
//
//            System.out.println("myComponent " + myComponent.value());
//
//        }
        throw new RuntimeException("Can't find Bean");
    }
}
