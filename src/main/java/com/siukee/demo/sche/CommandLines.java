package com.siukee.demo.sche;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class CommandLines {
	private static final Logger logger = LoggerFactory.getLogger(CommandLines.class);

	@Component
	@Order(1)
	public static class CommandLineAppStartupRunner implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			logger.info(
					"[CommandLineRunner]Application started with command-line arguments: {} .To kill this application, press Ctrl + C.",
					Arrays.toString(args));
		}
	}

	@Component
	@Order(2)
	public static class AppStartupRunner implements ApplicationRunner {

		@Override
		public void run(ApplicationArguments args) throws Exception {
			logger.info("[ApplicationRunner]Your application started with option names : {}", args.getOptionNames());
		}
	}
}
