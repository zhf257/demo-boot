package com.siukee;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.ibeetl.starter.BeetlSqlSingleConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@AutoConfigureBefore(BeetlSqlSingleConfig.class)
public class DataSourceConfig {

	@Bean(name="datasource")
	public DataSource datasource(Environment env) {
		HikariDataSource ds = new HikariDataSource();
	    ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
	    ds.setUsername(env.getProperty("spring.datasource.username"));
	    ds.setPassword(env.getProperty("spring.datasource.password"));
	    ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
	    return ds;
	}
}
