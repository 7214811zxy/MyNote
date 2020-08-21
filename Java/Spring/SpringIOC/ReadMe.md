# Spring IOC Basic

## Spring配置文件
### 1. Bean标签的配置

一个常见的<bean>标签，可能具有如下格式
<bean id="FirstSpring" class="HelloWorld.SpringHelloImpl" scope="protptype"></bean>

id: 唯一标识符，在配置文件中只能存在一个 

class: 表示类的全限定名

scope: 表示在容器中允许创建的数量; "prototype"表示可以创建多个, "singleton"表示可以创建一个，默认是"singleton"

**当scope的取值为singleton时**

​	Bean的实例化个数：1个

​	Bean的实例化时机：当Spring核心文件被加载时，配置的Bean实例就被实例化了，即默认会执行他的无参构造函数

​	Bean的生命周期：

​		对象创建：当应用加载，容器被创建的时候，对象就被创建了

​		对象运行：只要容器存在，对象就一直活着

​		对象销毁：当应用卸载，销毁容器时，对象就被销毁了

**当scope的取值为prototype时**

​	Bean的实例化个数：多个

​	Bean的实例化时机：当调用getBean()时执行其无参构造函数

​	Bean的生命周期：

​		对象创建：当使用对象时，创建新的对象实例

​		对象运行：只要对象在使用中，就一直活着

​		对象销毁：当对象长时间不用，被Java的垃圾回收器回收了

### 2. Bean实例化的三种方法

	1. 无参构造方法实例化
 	2. 工厂静态方法实例化
 	3. 工厂实例方法实例化

### 3. Spring的重点配置

![image-20200820164547933](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200820164547933.png)