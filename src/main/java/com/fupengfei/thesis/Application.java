package com.fupengfei.thesis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.Application
 * @Author: fpfos
 * @Date: 2019-04-08 22:25
 */
@EnableAsync
@EnableTransactionManagement
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
