package com.siukee.boot.errorattributes;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomErrorAttributesConfiguration {

  @Bean
  public ErrorAttributes errorAttributes() {
    return new CustomErrorAttributes();
  }

}
