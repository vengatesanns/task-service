package com.hackpro.taskservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorAwareBean")
public class AuditConfig {
	
	 @Bean
	 public AuditorAware<String> auditorAwareBean() {
	        return new AuditConfigImpl();
	    }
}
