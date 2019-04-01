package org.vinsw.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.vinsw.rest.MessageResource;

@SpringBootApplication
@ComponentScan(basePackageClasses = MessageResource.class)
public class SpringBootStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }
}
