package com.cub.demo;

import com.cub.demo.constant.SystemValues;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = SystemValues.BASE_DAO, considerNestedRepositories = true)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
