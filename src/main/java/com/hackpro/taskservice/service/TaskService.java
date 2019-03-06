package com.hackpro.taskservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackpro.taskservice.entity.Task_Details;
import com.hackpro.taskservice.repository.TaskRepository;


@Service
@Transactional
public class TaskService {
	
	private final static Logger logger = Logger.getLogger(TaskService.class);
	
	@Autowired
	private TaskRepository taskRepo;
	
	
	
	public void saveUserTask(Task_Details tasks)
	{
		try
		{
			taskRepo.save(tasks);	
		}
		catch(Exception ex)
		{
			logger.error("###### Error in Saving User Task Details");
		}
	}
	
	public List<Task_Details> getUserTasks()
	{
		List<Task_Details> userTaskList = null;
		try
		{
			userTaskList =  taskRepo.findAll();	
		}
		catch(Exception ex)
		{
			logger.error("###### Error in getting User Task Details");
		}
		
		return userTaskList;
	}

}
