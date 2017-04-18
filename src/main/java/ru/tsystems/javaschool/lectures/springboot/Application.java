package ru.tsystems.javaschool.lectures.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class Application extends SpringBootServletInitializer {

    public static void main(final String[] arguments) {
        SpringApplication.run(Application.class, arguments);
    }

    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
         return application.sources(Application.class);
    }
}
