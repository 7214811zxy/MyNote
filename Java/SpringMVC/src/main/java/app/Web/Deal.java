package app.Web;

import app.Config.springConfig;
import app.Control.Control;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 包含知识点
 * 1. HttpServlet Class的使用
 * 2. get和post请求最基础的request和response
 * 3. HttpServletRequest对象和HttpServletResponse对象中一些常用方法的使用
 *
 * */

@WebServlet("/deal")
// @ContextConfiguration(classes = { springConfig.class })
public class Deal extends HttpServlet {

    // @Resource(name="control")
    // Control control;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        this.doPost( request, response );
    }


    @Override
    // 处理一次交易
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

        // control.deal("peter", "mike", 200);

        // 向html页面写入信息
        try {
            out.println("<p>Deal Successful</p>");  // HTML 5
        } finally {
            // 关闭output writer
            out.close();
        }
    }

}
