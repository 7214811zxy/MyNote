package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// Spring配置类
@Configuration // 声明注解
@ComponentScan("springAnnoAspect") // 配置自动扫描
@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = false) // 配置AOP自动代理(没有这个无法织入增强方法)
public class SpringConfig {
}
