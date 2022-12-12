package com.example.POSBackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EntityScan("com.example.POSBackend.*")
@ComponentScan(basePackages = "com.*")
public class PosBackendMain {

    public static void main(String[] args) {
        SpringApplication.run(PosBackendMain.class, args);
    }

}
