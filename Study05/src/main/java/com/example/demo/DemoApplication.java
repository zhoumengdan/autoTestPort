package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

/**
 * @author Leslie H C Wang
 * @date 2023/8/23 9:54
 */

@EnableAutoConfiguration
@RestController
public class DemoApplication {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}