package com.siukee.uac.config;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeetlConfiguration {

	@Value("${beetl.templatesPath}")
	String templatesPath;// 模板根目录 ，比如 "templates"

	@Bean(name = "beetlConfig")
	public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
		BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
		// 获取Spring Boot 的ClassLoader
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = BeetlConfiguration.class.getClassLoader();
		}
		ClasspathResourceLoader cploder = new ClasspathResourceLoader(loader, templatesPath);
		beetlGroupUtilConfiguration.setResourceLoader(cploder);
		beetlGroupUtilConfiguration.init();
		// 如果使用了优化编译器，涉及到字节码操作，需要添加ClassLoader
		GroupTemplate gt = beetlGroupUtilConfiguration.getGroupTemplate();
		gt.setClassLoader(loader);
		Map<String, Object> shared = new HashMap<String, Object>();
		shared.put("_version", "1.0.0");
		gt.setSharedVars(shared);
		return beetlGroupUtilConfiguration;

	}

	@Bean(name = "beetlViewResolver")
	public BeetlSpringViewResolver getBeetlSpringViewResolver(
			@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
		BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
		beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
		beetlSpringViewResolver.setSuffix(".html");
		beetlSpringViewResolver.setOrder(0);
		beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
		return beetlSpringViewResolver;
	}
}
