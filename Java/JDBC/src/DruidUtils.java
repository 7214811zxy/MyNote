import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    private static DataSource ds;

    // 初始化连接
    static {
        try{
            // 加载配置文件
            Properties pro = new Properties();
            InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            // 获取DataSource
            ds  = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public  static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 释放资源
    public static void close(ResultSet rs, Statement stmt, Connection conn){

        if(rs != null){
            try{
                rs.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 释放数据库执行对象
        if(stmt != null){
            try{
                stmt.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 释放数据库连接对象
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    // 获取连接池
    public static DataSource getDataSource(){
        return ds;
    }

}
