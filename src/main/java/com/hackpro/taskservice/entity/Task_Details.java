package com.hackpro.taskservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hackpro.taskservice.utilities.CustomBaseClass;

@Entity
@Table(name="user_task")
public class Task_Details extends CustomBaseClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long taskId;
	
	private String taskTitle;
	
	private String taskDescription;

	private String taskLevel;

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskLevel() {
		return taskLevel;
	}

	public void setTaskLevel(String taskLevel) {
		this.taskLevel = taskLevel;
	}
	
	
	
}
