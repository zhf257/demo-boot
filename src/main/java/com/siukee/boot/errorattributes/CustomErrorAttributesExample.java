package com.siukee.boot.errorattributes;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.siukee.boot.errorattributes", "com.siukee.boot.controllers" })
public class CustomErrorAttributesExample {

  public static void main(String[] args) {
    SpringApplication.run(CustomErrorAttributesExample.class, args);
  }

}
