package Reflect;

public class Main {
    public static void main(String[] args) throws Exception {
        String clsName = "Reflect.Student";
        String methodName = "studentSayHello";
        ReflectDemo.runMethod(clsName, methodName);
    }
}
