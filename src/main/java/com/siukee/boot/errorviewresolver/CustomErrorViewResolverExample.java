package com.siukee.boot.errorviewresolver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.siukee.boot.errorcontroller.CustomErrorController;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    basePackages = { "com.siukee.boot.errorviewresolver", "com.siukee.boot.controllers" },
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class),
        // 这里要排除自动扫描时扫到CustomErrorController
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = CustomErrorController.class)
    }
)
public class CustomErrorViewResolverExample {

  public static void main(String[] args) {
    SpringApplication.run(CustomErrorViewResolverExample.class, args);
  }

}
