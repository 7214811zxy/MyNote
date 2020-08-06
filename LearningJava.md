# Java Tutorial 

## Basic

### 1. HelloWorld Forever

~~~java
public class HelloJupyter {
	public static void main(String[] args){
		System.out.println("Hello");
	}
}
~~~

note: 文件名必须与class名一致

### 2. Comment

~~~java
// 单行注释

/*
   多行注释
   多行注释
*/
~~~

### 3. Reference Equality  and  Logical Equality

“==”对于objects和primitives的作用效果是不同的

“==” 用来比较reference equality —— 即**引用/指针相等**

“.equals()” 用来比较logical equality —— 即**逻辑是否相等**

> Logical Equality —— Two statements are logically equivalent if they have the same truth values for every possible interpretation

~~~java
String a = new String("Wow");
String b = new String("Wow");
String sameA = a;

boolean r1 = a == b;      // This is false, since a and b are not the same object
boolean r2 = a.equals(b); // This is true, since a and b are logically equals
boolean r3 = a == sameA;  // This is true, since a and sameA are really the same object
~~~

### 4. Array

array的declared需要同时declared type和size

~~~java
public class Main {
    public static void main(String[] args) {
        // 整型数组
        int[] arr1 = { 1, 2, 3, 4 };
        
        // 浮点数组
        float[] arr2 = { 5.1f, 6.1f, 7.1f, 8.1f };
        
        // 双精度浮点数组的声明和访问
        double[] arr3;
        arr3 = new double[3];
        arr3[0] = 11.1;
        arr3[1] = 12.2;
        arr3[2] = 13.3;
        
        // 遍历数组
        for( int i=0; i<arr1.length; i++ ){
            System.out.println(arr1[i]);
        }
        
        for( int i=0; i<arr2.length; i++ ){
            System.out.println(arr2[i]);
        }
        
        for( int i=0; i<arr3.length; i++ ){
            System.out.println(arr3[i]);
        }
        
        // 遍历数组 输出value；如果需要同时输出index，只能使用正经的for循环
        for( int el : arr3 ){
            System.out.println(el);
        }
    }
}
~~~

### 5. Object

java中可以定义多个构造函数，可以在一个构造函数中调用另一个构造函数

~~~Java
class Point {
    int x;
    int y;

    // 构造函数1
    Point() {
        // 在构造函数1中调用构造函数2
        this(1, 2);
    }

    // 构造函数2
    Point(int x, int y) {
        // 初始化states
        this.x = x;
        this.y = y;
    }
    
    // public方法：anyone have access
    public void sum(){
        int sum = this.x + this.y;
        System.out.println("sum:" + sum);
        this.mid();
    }
    
    // private方法：只有内部可以访问
    private void mid(){
        double mid = ( this.x + this.y ) / 2.0;
        System.out.println( "mid:" + mid );
    }
}

public class Main {
    public static void main(String[] args) {
        // 实例化Point类
        Point p = new Point();
        System.out.println(p.x);
        System.out.println(p.y);
        p.sum();
    }
}
~~~

### 6. Static and Unstatic Method

> - `static` means this method belongs to the class Main and not to a specific instance of Main. Which means we can call the method from a different class like that `Main.foo()`.
>
>   static 意味着该方法属于class Main并不属于任何class Main的实例。也就是说我们可以在另外一个class中像这样直接调用该方法Main.foo(); 但是如果一个方法被定义为非static方法，则一定要先生成实例，才能调用方法。
>
> - `void` means this method doesn't return a value. Methods can return a single value in Java and it has to be defined in the method declaration. However, you can use `return` by itself to exit the method.
>
> - This method doesn't get any arguments, but of course Java methods can get arguments as we'll see further on.

~~~Java
public class Main {
    public static void main(String[] args) {
        Main obj = new Main(); 
        obj.sum(1, 2); // 3 non static function的调用
        Main.mid(1,2); // 1.5 static function的调用
        mid(3,4); // 1.5 static function的调用
    }
    
    // non static function的定义
    public void sum(int a, int b){
        System.out.println(a + b);
    }
    
    // static function的定义
   	public static void mid(int a, int b){
        System.out.println( (a + b) / 2f );
    }
}
~~~

### 7. Running with Arguments

带参数执行java.class

命令行运行：java HelloJupyter nb

输出：nb

```java
public class HelloJupyter {
	public static void main(String[] args){
		System.out.println(args[0]);
	}
}
```

### 8. Inheritance

> In Java, the term inheritance refers to the adoption of all non-private properties and methods of one class (superclass) by another class (subclass).
>
> 继承就是将一个class的所有的non-private properties and methods复制给一个新的class

