/**
 *
 * JDBC的一个HelloWorld
 * 向iknow数据库中插入一条信息
 *
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCHelloWorld {
    public static void main(String[] args) {

        // 1. 导入驱动jar包
        // 2. 注册驱动 加载mysql connector/com/mysql/jdbc/Driver.class
        try{

            Class.forName("com.mysql.jdbc.Driver");

            // 3. 获取数据库连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iknow", "root", "1993315zxy");

            // 4. 定义SQL语句
            String sql = "insert into jldb values(null, 'joker', '20080501')";

            // 5. 获取执行SQL的对象
            Statement stmt = conn.createStatement();

            // 6. 执行sql
            int count = stmt.executeUpdate(sql);

            // 7. 处理结果
            System.out.println(count);

            // 8. 释放资源
            stmt.close();
            conn.close();

        } catch ( ClassNotFoundException e ){
            e.printStackTrace();
        } catch ( SQLException e ){
            e.printStackTrace();
        }
    }
}
