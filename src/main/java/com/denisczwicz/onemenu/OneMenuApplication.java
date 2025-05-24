package com.denisczwicz.onemenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OneMenuApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneMenuApplication.class, args);
    }

}
