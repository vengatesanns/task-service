package com.hackpro.taskservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackpro.taskservice.entity.Task_Details;
import com.hackpro.taskservice.service.TaskService;

@RestController
@RequestMapping("/home/task/")
public class TaskController {
	
	private final static Logger logger = Logger.getLogger(TaskController.class);
	
	@Autowired
	private TaskService taskService;
	
	
	@PostMapping("/saveUserTask")
	public void saveUserTask(@RequestBody Task_Details tasks)
	{
		taskService.saveUserTask(tasks);
	}

	
	@GetMapping("/getUserTasks")
	public List<Task_Details> getUserTaskList()
	{
		return taskService.getUserTasks();
	}
}
