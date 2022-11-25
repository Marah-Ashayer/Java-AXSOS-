package com.codingdojo.ProjectManager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ProjectManager.models.Project;
import com.codingdojo.ProjectManager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
		List<Project> findAll();
		Project findByIdIs(Long id);
		List<Project> findAllByUsers(User user);
		List<Project> findByUsersNotContains(User user); 
	}

