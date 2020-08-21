import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 接收Demo2中的请求转发
 *
 * */

@WebServlet("/demo2_1")
public class Demo2_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("转发请求成功");

        // 从request域中获取数据
        Object user = request.getAttribute("username");
        Object pw = request.getAttribute("password");
        System.out.println("user: " + user);
        System.out.println("password: " + pw);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
