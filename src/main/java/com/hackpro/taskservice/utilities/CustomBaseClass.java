package com.hackpro.taskservice.utilities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class CustomBaseClass {
	
	@JsonIgnore
	@Column(updatable=false)
	protected Date createdAt;
	
	@JsonIgnore
	protected Date modifiedAt;
	
	@JsonIgnore
	protected String modifiedBy;
	
	@JsonIgnore
	@Column(updatable=false)
	protected String createdBy;
	
	protected boolean active;

	 @CreatedDate
	 @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	 @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss.S")
	 public Date getCreatedAt() {
			return createdAt;
	 }

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@LastModifiedDate
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss.S")
	public Date getModifiedAt() {
		return modifiedAt;
	}
	
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@LastModifiedBy
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@CreatedBy
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isActive() {
		return true;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
}
