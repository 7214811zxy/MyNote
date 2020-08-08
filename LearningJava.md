# Java Tutorial 

## Core OOP Concepts Introduction 

## 1. Class

**The class is a group of similar entities. It is only an logical component and not the physical entity.** For example, if you had a class called “Expensive Cars” it could have objects like Mercedes, BMW, Toyota, etc. Its properties(data) can be price or speed of these cars. While the methods may be performed with these cars are driving, reverse, braking etc.

`class`是`object` / `instance` 的集合。`class`是一种逻辑层面的组件，并不是一个物理`entity`

> 什么是实体？`entity`: something that has a real existence; thing
>
>  https://www.dictionary.com/browse/entity

## 2. Object

An object can be defined as an instance of a class, and there can be multiple instances of a class in a program. An Object contains both the data and the function, which operates on the data. For example - chair, bike, marker, pen, table, car, etc.

`object`被定义为一个`class`的`instance`.在一个程序中一个`class`可以存在多个`instances` \ `object`; 

## 3. Inheritance

Inheritance is an OOPS concept in which one object acquires the properties and behaviors of the parent object. It’s creating a parent-child relationship between two classes. It offers robust and natural mechanism for organizing and structure of any software.

`Inheritance`是OOP中的一个概念，表示一个`object`获取了所有`parent object`的属性和方法

## 4. Polymorphism

Polymorphism refers to the ability of a variable, object or function to take on multiple forms. For example, in English, the verb *run* has a different meaning if you use it with *a laptop*, *a foot race*, and *business*. Here, we understand the meaning of *run* based on the other words used along with it.The same also applied to Polymorphism.

`Polymorphism`描述的是一种变化的能力，`object`或者`function`可以具有多种形式。

> 举例来说，在英语中动词`run`在不同的语境下有不同的涵义，例如`foot race run(跑步比赛)`, `business run(商业运行)`两个短语中`run`的涵义是不同的。

## 5. Abstraction

An abstraction is an act of representing essential features without including background details. It is a technique of creating a new data type that is suited for a specific application. For example, while driving a car, you do not have to be concerned with its internal working. Here you just need to concern about parts like steering wheel, Gears, accelerator, etc.

`Abstract`可以理解为一种顶层的建模方法，它对事物的基本特征进行描述，但不包含具体的细节。这种技术通常用来创建一种符合特定应用的新数据类型。

> 举例来说，当我们开车时，我们不关心车的内部是如何工作的。我们只关心这个车的驱动系统、变速系统和加速系统等(这个栗子 好像没啥用 :slightly_smiling_face: )。

### Abstraction、Encapsulation、Interface之间的区别

​										**The Difference Between Abstraction and Encapsulation**

| **Abstraction**                                              | **Encapsulation**                                            |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Abstraction solves the issues at the design level. 设计层面  | Encapsulation solves it implementation level. 应用层面       |
| Abstraction is about hiding unwanted details while showing most essential information. `Abstract`侧重于隐藏那些非关键信息，突显关键信息 | Encapsulation means binding the code and data into a single unit. `Encapsulation`意味着将代码和数据绑定到一个单一的unit内 |
| Abstraction allows focussing on what the information object must contain`Abstract`关注`object`必须包含的信息 | Encapsulation means hiding the internal details or mechanics of how an object does something for security reasons. `Encapsulation`意味着将内部细节或者实现机理进行隐藏 |

​									**The Difference Between Abstraction and Interface**

| **Abstract Class**                                           | **Interface**                                                |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| An abstract class can have both abstract and non-abstract methods. `abstract class`可以同时用于`abstract`方法和`non-abstract`方法 | The interface can have only abstract methods. `interface`只有`abstract`方法 |
| It does not support multiple inheritances. 不支持多重继承    | It supports multiple inheritances. 支持多重继承              |
| It can provide the implementation of the interface. 提供了实现的接口 | It can not provide the implementation of the abstract class. 不提供`abstract class`的实现 |
| An abstract class can have protected and abstract public methods. `abstract class`可以保护`abstract public methods` | An interface can have only have public abstract methods. `Interface`只有`public abstract methods` |
| An abstract class can have final, static, or static final variable with any access specifier. `abstract class`可以带有`final, static, static final`等任何特定访问规则的变量 | The interface can only have a public static final variable. `interface只有` `public, static, final `变量 |

## 6. Encapsulation

Encapsulation is an OOP technique of wrapping the data and code. In this OOPS concept, the variables of a class are always hidden from other classes. It can only be accessed using the methods of their current class. 

`Encapsulation` 封装是OOP中对代码和数据进行包裹的技术。在OOP中，一个`class`的内的变量应该被隐藏起来，其他`class`无法访问。

## 7. Association

Association is a relationship between two objects. It defines the diversity between objects. In this OOP concept, all object have their separate lifecycle, and there is no owner. For example, many students can associate with one teacher while one student can also associate with multiple teachers.

`Association——关联`描述的是两个`object `之间的关系。它定义了两个`object`之间的差异。所有`object`的生命周期是独立的，没有主从关系。

> 举例来说，一个老师可以关联associate多个学生，同时一个学生也可以和多个老师进行关联associate
>
> `Association`: the state of being combination (https://www.merriam-webster.com/dictionary/combination)

## 8. Aggregation

In this technique, all objects have their separate lifecycle. However, there is ownership such that child object can’t belong to another parent object. For example consider class/objects department and teacher. Here, a single teacher can’t belong to multiple departments, but even if we delete the department, the teacher object will never be destroyed.

`Aggregation——聚合`可以理解为具有主从关系的`Association`。`object`之间的生命周期还是独立的，但是一个`child object`不可能属于另一个`parent object`

> 举例来说，一个老师不可能同时属于多个学科(至少在美国不会 :dog: )，但是即使一个学科被删除/重组/更名了，老师并不会被“摧毁 :upside_down_face:/ 辞退 ”。

## 9. Composition

A composition is a specialized form of Aggregation. It is also called "death" relationship. Child objects do not have their lifecycle so when parent object deletes all child object will also delete automatically. For that, let’s take an example of House and rooms. Any house can have several rooms. One room can’t become part of two different houses. So, if you delete the house room will also be deleted.

`composition`是`aggregation`的特殊形式，它也被称为“死关系”。`child object`没有他们自己的生命周期。当`parent object`被删除时，所有的`child object`都会随之删除。

> 举例来说，一个房子里通常有很多个房间。一个房间不可能同时属于两个不同的房子。当一个房子被删除时，那么所有的房间也应该被删除。



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

#### 1.1 Java程序必须要有Main方法吗？

stand-alone的applection必须要有main方法

> https://stackoverflow.com/questions/2896322/is-the-main-method-must-needed-in-a-java-program 
>
> https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-5.html#jvms-5.2 
>
> "When you save program with the name same as the class name which contain main() method, then at the time of execution the JVM will create a object of that class and with that object JVM will call the main() metod as object.main().
>
> 当你将`program`保存为名为`FileName`的文件时。当JVM执行程序，JVM首先对`program`中名为`FileName`，且包含`main`方法的`class`进行实例化，生成一个`object`，然后调用这个`object`的`main`方法
>

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

~~~java
class Door {
	
	String hosterName;
	static String dog = "WangCai";
	static String cat = "GoodLook";
	
	Door(String hosterName){
		this.hosterName = hosterName;
	}
	
	public void open (){
		String hosterName = this.hosterName;
		System.out.println(hosterName + " " + "open the HomeDoor");
	}
	
	public static void getVister(){
		Door.getCat();
		System.out.println("vister is " + dog);
	}
	
	private static void getCat(){
		System.out.println("vister is " + cat);
	}
	
}

class BankVaultDoor extends Door {
	BankVaultDoor(String hosterName) {
		super(hosterName);
	}
	public void open () {
		String hosterName = this.hosterName;
		System.out.println(hosterName + " " + "open the BankDoor");
	}
}

public class HelloJupyter {
	public static void main(String[] args){
		Door obj0 = new Door( args[0] );
		obj0.open();
		Door.getVister();
		
		BankVaultDoor obj1 = new BankVaultDoor( args[0] );
		obj1.open();
	}
}
~~~

### 9. Abstarct

> A class that is declared using “**abstract**” keyword is known as abstract class. It can have abstract methods(methods without body) as well as concrete methods (regular methods with body). A normal class(non-abstract class) cannot have abstract methods. 
>
> 1. An abstract method is only declared but not implemented.
>
>    抽象方法只能定义等不能使用
>
> 2. An abstract class cannot be instanciated but can be inherited by another class.
>
>    抽象类只能被定义但不能被实例化
>
> 3. The inheriting class must implement all the abstract methods or else the subclass should also be declared as abstract.

> ​		抽象类的子类必须定义所有父级中的抽象方法，除非子类也声明为抽象类

```java
abstract class GameHero{
    public abstract void fright();
}

class Magic extends GameHero{
    public void fright(){
        System.out.println("Shot a Fire Ball");
    }
}

class Warrior extends GameHero{
    public void fright(){
        System.out.println("Cut Cut Cut");
    }
}

public class Person {

    public static void main(String[] args){
        Magic peter = new Magic();
        peter.fright();

        Warrior mike = new Warrior();
        mike.fright();
    }
}
```

### 10. Interfaces

> Interfaces are class templates. Although not strictly required, they are part of the organizational structure of object-oriented programming. Interfaces define methods for classes by specifying the method name, the return type (or void) and the method arguments (by type and name). These method definitions are called signatures. Because this is a template, the method signatures contain no code. The code is entered into the **implementation** of an interface. Interfaces are used in the discipline of polymorphism.

`Interface`是`class`的`template`。虽然`Interface`不是必须的，但是他们是面向对象语言结构的一部分。`Interface`定义了`class`必须包含特定的`method name`、`return type`、`arguments type`、`arguments name`。这些起到`template`作用的`method`我们叫他们签名(`signatures`)。因为`signatures`只起到`template`的作用，所以不需要包含实际的代码，实际的代码在`interface`的`implementation`中编写。`Interfaces`主要使用在多态中(`polymorphism`)

> Note these two important points about interfaces:

- > If a class implements an `interface`, all of the interface's methods must appear in the class.

  如果一个`class`实现了一个`interface`,所有`interface`的方法必须出现在这个class中

- > The `implements` keyword is used when creating a class that is modeled after an interface.

  如果一个`class`是某个`interface`的`implementation`，那`implements`关键字必须出现在class之后

### 11. Generics

