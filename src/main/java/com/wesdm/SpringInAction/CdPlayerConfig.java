package com.wesdm.SpringInAction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
@ComponentScan
public class CdPlayerConfig {

	@Bean
	@Conditional(MagicExistsCondition.class)	//bean created only when condition is met
	public MagicBean magicBean() {
		return new MagicBean();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}

class MagicExistsCondition implements Condition {
	
	//using context and metadata there a lot matches can consider
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment env = context.getEnvironment();
		return env.containsProperty("magic");
	}
}

class MagicBean {
}
