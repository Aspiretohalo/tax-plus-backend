package com.taxplus.taxplusbackend;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Slf4j
@ServletComponentScan //开启了对servlet组件的支持
@SpringBootApplication
@MapperScan("com.taxplus.taxplusbackend.mapper")
public class TaxPlusBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxPlusBackendApplication.class, args);
        log.info("项目启动成功");
    }

}
