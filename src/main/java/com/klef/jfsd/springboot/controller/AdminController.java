package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.models.Admin;
import com.klef.jfsd.springboot.models.DeletedUsers;
import com.klef.jfsd.springboot.models.PlacementOfficer;
import com.klef.jfsd.springboot.models.Recruiter;
import com.klef.jfsd.springboot.models.Student;
import com.klef.jfsd.springboot.services.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	

	
	@PostMapping("checkadminlogin")
	public Admin checkadminlogin(@RequestParam("username") String username , @RequestParam("password") String password)
	{
		
		  Admin admin = adminService.checkAdminLogin(username, password);
		  
		 return admin;
	}
	
	@GetMapping("getregisteredRecruiters")
	public List<Recruiter> getregisteredRecruiters()
	{
		return adminService.getRegisteredRecruiters();
	}
	
	@GetMapping("getregisteredOfficers")
	public List<PlacementOfficer> getregisteredOfficers()
	{
		return adminService.getRegisteredOfficers();
	}
	
	@PutMapping("verifyRecruiter")
	public String verifyRecruiter(@RequestParam("id") int id , @RequestParam("status") String status)
	{
		return adminService.updateRecruiterStatus(status,id );
	}
	
	@PutMapping("verifyOfficer")
	public String verifyOfficer(@RequestParam("id") int id , @RequestParam("status") String status)
	{
		return adminService.updateOfficerStatus(status,id );
	}
	
	@GetMapping("viewstudents")
	public List<Student> getStudents()
	{	
		return adminService.viewAllStudents();
	}
	
	@DeleteMapping("deletestudent")
	public String deleteStudent(@RequestParam("id") int id , @RequestParam("name") String name)
	{
		return adminService.deleteStudent(id, name);
	}
	
	
	@GetMapping("viewrecruiters")
	public List<Recruiter> getRecruiters()
	{
		return adminService.viewAllRecruiters();
	}
	
	@DeleteMapping("deleterecruiter")
	public String deleteRecruiter(@RequestParam("id") int id , @RequestParam("name") String name)
	{
		return adminService.deleteRecruiter(id, name);
	}
	
	@GetMapping("viewofficers")
	public List<PlacementOfficer> getOfficeres()
	{
		return adminService.viewAllPlacementOfficers();
	}
	
	@DeleteMapping("deleteofficer")
	public String deleteOfficer(@RequestParam("id") int id , @RequestParam("name") String name)
	{
		return adminService.deletePlacementOfficer(id, name);
	}
	
	@GetMapping("getArchive")
	public List<DeletedUsers> getArchive()
	{
		return adminService.getDeletedUsers();
	}
	
	@PutMapping("undo")
	public String undodelete(@RequestParam int id)
	{
		return adminService.undodelete(id);
	}
	@DeleteMapping("permanentdelete")
	public String permanentdelete(@RequestParam int id)
	{
		return adminService.permanent(id);
	}
	
	
	
	
	
	
	
}
