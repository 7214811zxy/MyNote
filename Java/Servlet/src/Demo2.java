import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 包含知识点
 * 1. HttpServlet Class的使用
 * 2. 通用参数获取方法的使用(doPost和doGet方法的合并处理，统一使用doPost方法来处理请求)
 * 3. 请求转发的使用
 * 4. 请求转发时的数据共享
 *
 * */

@WebServlet("/demo2")
public class Demo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Demo2 —— Get请求和Post请求的合并");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println( "username is: " + username );
        System.out.println( "password is: " + password );

        System.out.println("Demo2 —— 请求的转发和数据共享");
        // 将数据存入request域中
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        // 转发请求
        request.getRequestDispatcher("/demo2_1").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost( request, response );
    }
}
