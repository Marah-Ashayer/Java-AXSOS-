package com.codingdojo.ProjectManager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=3 , message="Title Must Not Be Blank")
    private String title;
    
    @NotNull
    @Size(min =3, message="Description Must Not Be Blank")
    private String description;
    
    @Future
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dueDate;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    

    public Project() {
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
    private User lead;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_projects",
			joinColumns = @JoinColumn(name = "project_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
    private List<User> users;
    
    @Column(updatable=false)
    @OneToMany(mappedBy="project", fetch=FetchType.LAZY)
    private List<Task> tasks;
    
    
    
    public Project(String title, Date dueDate, String description, User lead) {
    	this.title = title;
    	this.dueDate = dueDate;
    	this.description = description;
    	this.lead = lead;
    }

  
  //--------------------------------Getters and Setters-------------------------//

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public User getLead() {
		return lead;
	}


	public void setLead(User lead) {
		this.lead = lead;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
}
    
    
    //----------------------------------------------
//  @ManyToMany(fetch = FetchType.LAZY)
//  @JoinTable(
//      name = "projects_users", 
//      joinColumns = @JoinColumn(name = "projectjoin_id"), 
//      inverseJoinColumns = @JoinColumn(name = "userjoin_id")
//  )     
//  private List<User> userjoin;
//  
//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name="user")
//  private User user;
//  
//	@Column(updatable=false)
//  @OneToMany(mappedBy="projects", fetch = FetchType.LAZY)
//  private List<Task> projectTasks;
//  
//public Project(String title, String description, Date date) {
//	  this.title = title;
//	  this.description = description;
//	  this.date = date;
//	
//}