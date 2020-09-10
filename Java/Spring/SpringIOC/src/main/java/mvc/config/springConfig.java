package mvc.config;
import org.springframework.context.annotation.*;

// 标指该类是Spring的核心配置类，这个类将代替之前的applicationContext.xml文件
@Configuration

// 使用注解 ComponentScan 代替组件扫描
//<context:component-scan base-package="mvc"/>
@ComponentScan("mvc")

// 向Spring核心配置类内导入配置文件（可以一次导入多个）
@Import({dataSourceConfig.class})
public class springConfig { }
