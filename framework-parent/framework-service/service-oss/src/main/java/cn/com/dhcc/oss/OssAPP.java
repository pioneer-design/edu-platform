package cn.com.dhcc.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * <b>阿里云 OSS 启动类</b>
 *
 * @author : WMF
 * @since : 2020/6/29 15:27
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"cn.com.dhcc"})
public class OssAPP {
    public static void main(String[] args) {
        SpringApplication.run(OssAPP.class, args);
    }
}
