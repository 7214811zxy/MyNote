import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 包含知识点
 * 1. HttpServlet Class的使用
 * 2. get和post请求最基础的request和response
 * 3. HttpServletRequest对象和HttpServletResponse对象中一些常用方法的使用
 *
 * */

@WebServlet("/demo1")
public class Demo1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // 接收到了get请求
        System.out.println("Get Get Request...");

        // 设置response的MIME type=UTF-8
        response.setContentType("text/html;charset=UTF-8");
        // getWriter: 返回一个PrintWriter object, 他可以向客户端发送字符串
        PrintWriter out = response.getWriter();

        // 获取请求头中特定header的所有value，存为一个Enumeration class
        Enumeration<String> headers = request.getHeaders("Cookie");
        while(headers.hasMoreElements()){
            System.out.println("header Cookie: " + headers.nextElement());
        }

        // 获取这次请求的方法
        String httpMethod = request.getMethod();
        System.out.println( "httpMethod: " + httpMethod );

        // 获取URI
        String uri = request.getRequestURI();
        System.out.println( "uri: " + uri );

        // 获取URL
        StringBuffer url = request.getRequestURL();
        System.out.println( "url: " + url.toString() );

        // 获取查询字符串
        String query = request.getQueryString();
        System.out.println("queryString: " + query);

        // 向html页面写入信息
        try {
            out.println("<p>Get Successful</p>");  // HTML 5
        } finally {
            // 关闭output writer
            out.close();
        }
    }

    // Do the same thing for GET and POST requests
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // 接收到了post请求
        System.out.println("Get Post Request....");

        // 设置response的MIME type=UTF-8
        response.setContentType("text/html;charset=UTF-8");
        // getWriter: 返回一个PrintWriter object, 他可以向客户端发送字符串
        PrintWriter out = response.getWriter();

        // 使用getReader获取字节流
        BufferedReader br = request.getReader();
        String line;
        while (( line = br.readLine() ) != null ){
            System.out.println(line);
        }

        // 向html页面写入信息
        try {
            out.println("<p>Post Successful</p>");  // HTML 5
        } finally {
            // 关闭output writer
            out.close();
        }
    }
}
