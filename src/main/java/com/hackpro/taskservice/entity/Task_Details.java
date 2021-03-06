package com.hackpro.taskservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	private String moduleName;
	
	private String reportingPerson;
	
	@Transient
	private String portNo;

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

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getReportingPerson() {
		return reportingPerson;
	}

	public void setReportingPerson(String reportingPerson) {
		this.reportingPerson = reportingPerson;
	}

	public String getPortNo() {
		return portNo;
	}

	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}
	
	
	
}
