package com.codingdojo.ProjectManager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ProjectManager.models.Project;
import com.codingdojo.ProjectManager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	   Optional<User> findByEmail(String email);
		List<User> findAll();
		
		User findByIdIs(Long id);
		List<User> findAllByProjects(Project project);
		List<User> findByProjectsNotContains(Project project);
}  
	
