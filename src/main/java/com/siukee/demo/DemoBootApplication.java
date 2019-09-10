package com.siukee.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoBootApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoBootApplication.class);
		// 指定PID生成，默认输出到application.pid
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
	}
}
