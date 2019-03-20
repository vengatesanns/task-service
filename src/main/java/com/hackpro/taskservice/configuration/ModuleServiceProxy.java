package com.hackpro.taskservice.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hackpro.taskservice.entity.Task_Details;

//If many service communication need, to create multiple proxy interface to manage request calls
//Act as Repository for service to service communication
//@FeignClient(name="module-service",url="localhost:7400")
//@FeignClient(name="module-service")
@FeignClient(name="gateway-api")
@RibbonClient("module-service")
public interface ModuleServiceProxy {

	
	//module-service Url 
	@GetMapping("/module-service/home/module/findByModuleId/{id}")
	public Task_Details findByModuleId(@PathVariable("id") long id);
}
