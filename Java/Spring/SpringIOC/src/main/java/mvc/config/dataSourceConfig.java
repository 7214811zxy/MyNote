package mvc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@PropertySource("classpath:jdbc.properties")
public class dataSourceConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    // 使用注解 @Bean和@Value 替代数据源的配置
    //    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
    //        <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
    //        <property name="url" value="jdbc:mysql://localhost:3306/iknow"></property>
    //        <property name="username" value="root"></property>
    //        <property name="password" value="1993315zxy"></property>
    //    </bean>
    @Bean("dataSource")
    public DataSource connectMysql(){

        // 设置数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

}
