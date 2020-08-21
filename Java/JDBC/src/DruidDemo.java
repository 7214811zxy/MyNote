import java.sql.Connection;
import java.sql.PreparedStatement;

public class DruidDemo {
    public static void main(String[] args) throws Exception {

        Connection conn = null;
        PreparedStatement pstmt = null;

        // 获取连接
        conn = DruidUtils.getConnection();

        // 定义sql语句
        String sql = "insert into jldb values(null, ?, ? )";

        // 获取pstmt对象
        pstmt = conn.prepareStatement(sql);

        // 给占位符赋值
        pstmt.setString(1, "Sky");
        pstmt.setString(2, "19960506");

        // 执行sql
        int count = pstmt.executeUpdate();
        System.out.println(count);

        // 关闭连接池
        DruidUtils.close(null, pstmt, conn);

    }
}
