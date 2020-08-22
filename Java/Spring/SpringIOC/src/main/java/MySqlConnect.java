import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class MySqlConnect {

    // 连接Druid数据源, 手动加载配置文件
//    public void test() throws SQLException {
//        // 读取配置文件
//        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
//        String driver = rb.getString("jdbc.driver");
//        String url = rb.getString("jdbc.url");
//        String username = rb.getString("jdbc.username");
//        String password = rb.getString("jdbc.password");
//
//        // 创建数据源连接池
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        DruidPooledConnection connection = dataSource.getConnection();
//        System.out.println(connection);
//        connection.close();
//    }

    // 利用spring创建连接池
    @Test
    public void connect() throws SQLException {

        // 创建上下文
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取bean object
        DruidDataSource dataSource = app.getBean("dataSource", DruidDataSource.class);

        // 连接数据库连接池
        DruidPooledConnection conn = dataSource.getConnection();

        // 验证
        System.out.println("获取连接对象" + conn);
    }

}
