# Servlet Basic

## What is Servlet
Servlet is public interface; A servlet is a small Java program that runs within a Web server. Servlets receive and respond to requests from Web clients, usually across HTTP, the HyperText Transfer Protocol.

## How to HelloWorld
create => new modules => web application (勾选web.xml)

## 如何路径映射
1. 方法1 直接在xml中定义 例: web.demo.servlet.MyServlet2 和 web.WEB-INF.web.xml
2. 方法2 servlet3.0之后 支持注释配置, 例: web.demo.servlet.MyServlet3
两个方法可以共存

## 三个基本的生命周期函数
1. init()
Called by the servlet container to indicate to a servlet that the servlet is being placed into service.
被servlet的容器所调用，告诉servlet该service被启用了。只在某个URL第一次被访问的时候调用

2. service()
Called by the servlet container to allow the servlet to respond to a request.
被servlet的容器所调用，允许servlet去相应一个请求。例如，每次URL被访问的时候都会调用

3. destroy()
Called by the servlet container to indicate to a servlet that the servlet is being taken out of service.
由servlet容器调用，告诉servlet，这个servlet准备退休了

## 关于WEB-INF目录
这个文件夹中的文件，无法在客户端访问

## 关于虚拟地址
修改方式：
run => Edit Configurations => 修改 Server中的URL 和 Deployment 中的 Application Context

## 关于tomcat的断点调试
断点后使用DeBug模式进行调试

## 关于GenericServlet和HttpServlet
这两个方法是对Servlet接口的抽象类实现，对Servlet进行了进一步的封装。层级关系如下
Servlet
   |
 GenericServlet
        |
     HttpServlet
     
## 关于Http请求
对于get请求，主要通过getQueryString()来获取查询字符串
对于post请求，可以通过getReader()来获取字符输入流，通过getInputStream()获取字节流输入流

servlet提供了获取请求参数的通用方法，兼容get和post：
String getParameter(String name) 根据参数名称获取参数值
String[] getParameterValues(String name) 根据参数名称获取所有的参数值组成的数组
Enumeration<String> getParameterNames() 获取所有请求参数的名称
Map<String, String[]> getParameterMap() 获取所有参数的map集合

利用getParameter(String name) 可以实现doGet()和doPost()方法的合并

## 案例
需求介绍：
    1. 编写login.html登陆页面；具有username & password两个输入框
    2. 使用Druid数据库连接池技术，操作mysql中的表
    3. 使用jdbcTemplate技术封装JDBC
    4. 登陆成功跳转到SuccessServlet展示：登陆成功！
    5. 登陆失败跳转到FailServlet展示：登录失败

