/**
 * Spring Boot 应用启动类。
 * 该类是整个应用程序的入口，包含 main 方法。
 */

package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 这是一个组合注解，等价于 @Configuration + @EnableAutoConfiguration + @ComponentScan
// 它启用 Spring Boot 的自动配置，并扫描当前包及其子包中的组件（Controller、Service 等）。
@SpringBootApplication
public class HellowordApplication {
    // 应用程序的主入口方法。
    // 运行此方法会启动 Spring Boot 内嵌的 Web 服务器（如 Tomcat），
    // 并初始化整个 Spring 应用上下文。

    public static void main(String[] args) {
        SpringApplication.run(HellowordApplication.class, args);
    }

}
