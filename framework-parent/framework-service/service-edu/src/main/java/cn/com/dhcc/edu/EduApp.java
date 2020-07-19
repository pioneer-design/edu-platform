package cn.com.dhcc.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description:
 * @Author: WMF
 * @DATE: 2020/6/22 10:08
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"cn.com.dhcc"})
public class EduApp {
    public static void main(String[] args) {
        SpringApplication.run(EduApp.class,args);
    }
}
