package cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


// 基于cglib的AOP原生实现
public class ProxyTest {
    public static void main(final String[] args) {

        // 创建目标对象
        final cglib.TargetImpl target = new cglib.TargetImpl();

        // 增强对象
        final Advice advice = new Advice();

        // 1. 创建增强器
        Enhancer enhancer = new Enhancer();

        // 2. 设置父类(目标对象)
        enhancer.setSuperclass(TargetImpl.class);

        // 3. 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before(); // 执行前置
                Object invoke = method.invoke(target, args);
                advice.afterReturning(); // 执行后置
                return invoke;
            }
        });

        // 4. 创建代理对象
        TargetImpl proxy = (TargetImpl) enhancer.create();

        proxy.save();
    }
}
