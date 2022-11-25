package com.codingdojo.ProjectManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.ProjectManager.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
	List<Task> findAll();
}
