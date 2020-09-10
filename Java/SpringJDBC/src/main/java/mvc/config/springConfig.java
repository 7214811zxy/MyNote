package mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

// 标指该类是Spring的核心配置类，这个类将代替之前的applicationContext.xml文件
@Configuration

// 使用注解 ComponentScan 代替组件扫描
//<context:component-scan base-package="mvc"/>
@ComponentScan("mvc")

// 向Spring核心配置类内导入配置文件（可以一次导入多个）
@Import({dataSourceConfig.class})

public class springConfig {

    // 创建jdbcTemplate的Bean
    @Resource(name="dataSource")
    DataSource dataSource;

    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

}
