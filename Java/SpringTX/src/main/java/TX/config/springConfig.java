package TX.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

// 标指该类是Spring的核心配置类，这个类将代替之前的applicationContext.xml文件
@Configuration

// 使用注解 ComponentScan 代替组件扫描
// 注意：这个目录默认是在java下扫描，换句话说如果这里写java，扫描的是
// main/java/java 并不是扫描main/java
@ComponentScan("TX")

// 向Spring核心配置类内导入配置文件（可以一次导入多个）
@Import({dataSourceConfig.class})

//设置支持注解配置事务
@EnableTransactionManagement
public class springConfig {

    // 注入依赖
    @Resource(name="dataSource")
    DataSource dataSource;

    // 创建JDBC模板
    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    // 创建事务管理器
    @Bean("transactionManager")
    public DataSourceTransactionManager createTransactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }


}
