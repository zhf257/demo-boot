package com.siukee.demo.sche;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 利用@Scheduled注解实现定时器
 * 
 * @author atp
 *
 */
@Component
public class ScheduleTimer {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleTimer.class);

	/**
	 * 每10s
	 */
	@Scheduled(initialDelay = 5000, fixedDelay = 10000)
	public void onFixDelay() {
		logger.info("schedule job on every 10 seconds");
	}

	/**
	 * 每分钟的0秒执行
	 */
	@Scheduled(cron = "0 * * * * *")
	public void onCron() {
		logger.info("schedule job on every minute(0 second)");
	}

	/**
	 * 启用定时器配置
	 * 
	 * @author atp
	 *
	 */
	@Configuration
	@EnableScheduling
	public static class ScheduleConfig {
	}
}