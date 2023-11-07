package spring.review.demo.sys;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@MapperScan("spring.review.demo.*.mapper")
@SpringBootApplication
public class spdemo1Application {
    public static void main(String[] args) {
        SpringApplication.run(spdemo1Application.class,args);
        log.info("项目启动成功...");
    }
}
