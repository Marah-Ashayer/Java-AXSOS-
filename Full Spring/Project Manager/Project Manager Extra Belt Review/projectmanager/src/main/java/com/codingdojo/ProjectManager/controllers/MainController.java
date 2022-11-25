//package com.codingdojo.ProjectManager.controllers;
//
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.codingdojo.ProjectManager.models.LoginUser;
//import com.codingdojo.ProjectManager.models.Project;
//import com.codingdojo.ProjectManager.models.User;
//import com.codingdojo.ProjectManager.services.ProjectService;
//import com.codingdojo.ProjectManager.services.UserService;
//
//@Controller
//public class MainController {
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private ProjectService projectService;
//	
//	@Autowired
//	private ProjectService taskService;
//	
//	@GetMapping("/")
//	public String index(Model model) {
//	        model.addAttribute("newUser", new User());
//	        model.addAttribute("newLogin", new LoginUser());
//	        return "LoginPage.jsp";
//	    }
//	    
//	    @PostMapping("/register")
//	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
//	            BindingResult result, Model model, HttpSession session) {
//	    	userService.register(newUser, result);
//	        if(result.hasErrors()) {
//	            model.addAttribute("newLogin", new LoginUser());
//	            return "LoginPage.jsp";
//	        }
//	        session.setAttribute("user_id", newUser.getId());
//	        return "redirect:/projects";
//	    }
//	    
//	    @PostMapping("/login")
//	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
//	            BindingResult result, Model model, HttpSession session) {
//	        User user = userService.login(newLogin, result);
//	        if(result.hasErrors()) {
//	            model.addAttribute("newUser", new User());
//	            return "LoginPage.jsp";
//	        }
//	        session.setAttribute("user_id", user.getId());
//	        return "redirect:/projects";
//	    }
//	    
//	    @GetMapping("/projects")
//	    public String home(Model model, HttpSession session) {
//	        if (session.getAttribute("user_id") != null) {
//	        Long user_id = (Long) session.getAttribute("user_id");
//	        User thisUser = userService.findUserById(user_id);
//	        model.addAttribute("thisUser", thisUser);
//	        
//	        
//	        List<Project> projects = projectService.notJoined();
//			model.addAttribute("projects", projects);
//			
//	        List<Project> joined = projectService.Joined(thisUser);
//			model.addAttribute("joined", joined);
//			
////	    	List<Project> projects = projectService.allos(thisUser);
////	    	model.addAttribute("projects", projects);
//	        return "dashboard.jsp";
//	    }
//	        else {
//	            return "redirect:/";
//	        }
//	    }
//	    //------------------------------ Log Out --------------------------------//
//	    
//	    @GetMapping("/logout")
//	    public String logout(HttpSession session) { 
//	            session.invalidate();
//	            return "redirect:/";
//	    }
//	    //-------------------------------Create Project-------------------------------//
//	    @GetMapping("/projects/add")
//	    public String create(@ModelAttribute("project") Project project,Model model,HttpSession session) {
//	    	model.addAttribute("newLogin", new Project());
//	    	model.addAttribute("user",userService.findUserById((Long) session.getAttribute("user_id")));
//	    	return "NewProject.jsp";
//	    }
//	    
//	    
//	    @PostMapping("/projects/add")
//	    public String addProject(@Valid @ModelAttribute("project") Project project,BindingResult result,Model model,HttpSession session) {
//	        if (result.hasErrors()) {
//	            return "NewProject.jsp";
//	        } 
//	        else {
//
//	        	projectService.createProject(project);
//	    		User user = userService.findUserById((Long)session.getAttribute("user_id"));
//	         	user.getProjects().add(project);
//	         	projectService.createProject(project);
//	    		return "redirect:/projects";}
//	    }
//
//	    //--------------------------Join Team ----------------------------------//
//		@RequestMapping("/projects/join/{id}")
//		public String joinTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
//			Long user_id = (Long) session.getAttribute("user_id");
//			User thisUser = userService.findUserById(user_id);
//			Project pro = projectService.findProject(id);
//			pro.getUserjoin().add(thisUser);
//			projectService.createProject(pro);
////			model.addAttribute("user", user);			
//			return "redirect:/projects";
//		}
//		//--------------------------Leave Team --------------------------------------//
//		@RequestMapping("/projects/leave/{id}")
//		public String leaveTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
//			Long user_id = (Long) session.getAttribute("user_id");
//			User thisUser = userService.findUserById(user_id);
//			Project pro = projectService.findProject(id);
//			pro.getUserjoin().remove(thisUser);
//			projectService.createProject(pro);
////			model.addAttribute("user", user);			
//			return "redirect:/projects";
//		}
//		//--------------------------Edit Project --------------------------//
//	    @GetMapping("/projects/edit/{id}")
//	    public String edit(@PathVariable("id") Long id, Model model,HttpSession session) {
//	    	Project project = projectService.findProject(id);
//	        model.addAttribute("project", project);
//	        return "EdirProject.jsp";
//	    }
//	    
//	    @PutMapping("/projects/edit/{id}")
//	    public String update(@Valid @ModelAttribute("project") Project project, BindingResult result,HttpSession session) {
//	    	if (result.hasErrors()) {
//	            return "EdirProject.jsp";
//	        } else {
//	        	projectService.updateProject(project);
//	        	Long user_id = (Long) session.getAttribute("user_id");
//	        	User user = userService.findUserById(user_id);
//	        	user.getProjects().add(project);
//	        	projectService.updateProject(project);
//	            return "redirect:/projects";
//	        }
//	    }
//	    //-------------------- View Details Of a Project ---------------------//
//	    @GetMapping("/projects/{id}")
//	    public String showProject(Model model , @PathVariable("id") Long id){
//	        Project project = projectService.findProject(id);
//	        model.addAttribute("project", project);
//	    	return "ViewProject.jsp";
//	    }
//}
