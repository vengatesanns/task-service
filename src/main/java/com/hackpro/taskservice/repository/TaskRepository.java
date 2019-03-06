package com.hackpro.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackpro.taskservice.entity.Task_Details;

@Repository
public interface TaskRepository  extends JpaRepository<Task_Details,Long> {

}
