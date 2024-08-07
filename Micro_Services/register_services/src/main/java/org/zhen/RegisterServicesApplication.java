package org.zhen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterServicesApplication.class, args);
    }

}
