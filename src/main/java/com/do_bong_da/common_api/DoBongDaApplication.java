package com.do_bong_da.common_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@ComponentScan({"com.do_bong_da"})
@EnableScheduling
@EnableAsync
@EnableJpaAuditing
@EntityScan(basePackages = {"com.do_bong_da.common_api"})
@EnableJpaRepositories(basePackages = {"com.do_bong_da.repository"})
public class DoBongDaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoBongDaApplication.class, args);
    }
}
