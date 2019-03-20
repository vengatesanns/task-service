package com.hackpro.taskservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hackpro.taskservice.configuration.ModuleServiceProxy;
import com.hackpro.taskservice.entity.Task_Details;
import com.hackpro.taskservice.service.TaskService;

@RestController
@RequestMapping("/home/task/")
public class TaskController {
	
	private final static Logger logger = Logger.getLogger(TaskController.class);
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ModuleServiceProxy moduleServiceProxy;
	
	
	
	//Without Feign Client 
	@PostMapping("/saveUserTask/{module_id}")
	public void saveUserTask(@RequestBody Task_Details tasks,@PathVariable("module_id") long moduleId)
	{
	   ResponseEntity<Task_Details> responseEntity	= new RestTemplate().getForEntity("http://localhost:7400/home/module/findByModuleId/"+moduleId, 
						Task_Details.class);
	   Task_Details moduleInfo = responseEntity.getBody();
	   
	   tasks.setModuleName(moduleInfo.getModuleName());
	   tasks.setReportingPerson(moduleInfo.getReportingPerson());
	   taskService.saveUserTask(tasks);
	}
	
	//With Feign Client for Call (module-service) to get module Information
	@PostMapping("/saveUserTask-feign/{module_id}")
	public Task_Details saveUserFeignTask(@RequestBody Task_Details tasks,@PathVariable("module_id") long moduleId)
	{
	   
	   Task_Details moduleInfo = moduleServiceProxy.findByModuleId(moduleId);
	   tasks.setModuleName(moduleInfo.getModuleName());
	   tasks.setReportingPerson(moduleInfo.getReportingPerson());
	   tasks.setPortNo(moduleInfo.getPortNo());
	   taskService.saveUserTask(tasks);
	   return tasks;
	}

	
	@GetMapping("/getUserTasks")
	public List<Task_Details> getUserTaskList()
	{
		return taskService.getUserTasks();
	}
}
