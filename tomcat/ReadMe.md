## 如何从零开始部署一个tomcat服务

1. 把东西下下来

   https://tomcat.apache.org/download-80.cgi

2. 解压后放到一个你想要的地方。本质上是一个开源的java项目，所以不用安装。只要配置你的虚拟地址就可以使用了

3. 如何配置`虚拟地址`

   tomcat\conf\Catalina\localhost下创建任意名称的xml文件，比如我`demo.xml`。在xml中按照如下格式编写`虚拟地址`所映射的`实际地址`

   <Context docBase="C:\Users\Jupyter\Desktop\Project\MyNote\tomcat"/>

   显然`C:\Users\Jupyter\Desktop\Project\MyNote\tomcat`就是站点所在的实际地址，而`demo`就是虚拟地址了。启动tomcat后可以按照使用如下的ip来进行访问

   `ip:port/demo`

## 基于Java的tomcat目录结构

下面这个目录，就是一个web项目。其中包含了css、图片等一些静态文件。而动态资源存放在`WEB-INF`，这里面一般包含了web项目的核心配置文件，Java.class和一些依赖的jar包。

![image-20200815135348016](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200815135348016.png)

一般`WEB-INF`文件夹具有如下结构

-- Root

​	-- Static: 静态文件

​	--Web-Inf 动态文件

​		-- web.xml: web项目的核心配置文件

​		-- classes: 存放java.class文件

​		-- lib目录: 放置java的依赖包，即jar文件

## Tomcat的IDEA集成

