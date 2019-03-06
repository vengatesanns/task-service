package com.hackpro.taskservice.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditConfigImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		Optional<String> user = Optional.ofNullable("Vengat"); 
		return  user;
	}
	

}
