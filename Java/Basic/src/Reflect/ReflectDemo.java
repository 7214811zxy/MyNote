package Reflect;

import java.lang.reflect.Method;

public class ReflectDemo {
    public static void runMethod(String clsPath, String methodName) throws Exception {

        // 将类加载进内存
        Class cls = Class.forName(clsPath);

        // 对象的实例化
        Object obj = cls.getDeclaredConstructor().newInstance();

        // 获取方法对象
        Method method = cls.getMethod(methodName);

        // 调用方法
        method.invoke(obj);
    }
}
