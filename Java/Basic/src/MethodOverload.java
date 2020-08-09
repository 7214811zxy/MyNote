// 方法重载
// 可以同名方法进行重复定义
public class MethodOverload {
    public static void main(String[] args) {
        System.out.println(sum(1, 2));
        System.out.println(sum(1, 2, 3));
    }

    // 方法1
    public static int sum(int a, int b){
        return a + b;
    }

    // 方法2
    public static int sum(int a, int b, int c){
        return a + b + c;
    }
}
