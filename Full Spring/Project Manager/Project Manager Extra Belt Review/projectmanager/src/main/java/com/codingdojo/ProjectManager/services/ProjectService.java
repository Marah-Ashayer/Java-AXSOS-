package com.codingdojo.ProjectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ProjectManager.models.Project;
import com.codingdojo.ProjectManager.models.Task;
import com.codingdojo.ProjectManager.models.User;
import com.codingdojo.ProjectManager.repositories.ProjectRepository;
import com.codingdojo.ProjectManager.repositories.TaskRepository;
import com.codingdojo.ProjectManager.repositories.UserRepository;



@Service
public class ProjectService {
	
	
	private final ProjectRepository projectRepo;
	
	public ProjectService(ProjectRepository projectRepo) {
		this.projectRepo = projectRepo;
	}
	
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
	
	public List<Project> getAssignedUsers(User user){
		return projectRepo.findAllByUsers(user);
	}
	
	public List<Project> getUnassignedUsers(User user){
		return projectRepo.findByUsersNotContains(user);
	}
	
	public Project addProject(Project project) {
		return projectRepo.save(project);
	}
	
	public void deleteProject(Project project) {
		projectRepo.delete(project);
	}
	
	public Project findById(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}else {
			return null;
		}
	}

		
}
