package org.list4team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class List4TeamApplication {

    public static void main(String[] args) {
        SpringApplication.run(List4TeamApplication.class, args);
    }

}
