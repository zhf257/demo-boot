package com.siukee.boot.errorcontroller;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomErrorControllerConfiguration {

	private final ServerProperties serverProperties;

	private final List<ErrorViewResolver> errorViewResolvers;

	public CustomErrorControllerConfiguration(ServerProperties serverProperties,
			ObjectProvider<List<ErrorViewResolver>> errorViewResolversProvider) {
		this.serverProperties = serverProperties;
		this.errorViewResolvers = errorViewResolversProvider.getIfAvailable();
	}

	/**
	 * 抄的是{@link ErrorMvcAutoConfiguration#basicErrorController(ErrorAttributes)}
	 *
	 * @param errorAttributes
	 * @return
	 */
	@Bean
	public CustomErrorController customErrorController(ErrorAttributes errorAttributes) {
		return new CustomErrorController(errorAttributes, this.serverProperties.getError(), this.errorViewResolvers);
	}

}
