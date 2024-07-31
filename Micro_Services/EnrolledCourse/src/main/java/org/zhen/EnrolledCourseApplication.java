package org.zhen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EnrolledCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnrolledCourseApplication.class, args);
    }

}
