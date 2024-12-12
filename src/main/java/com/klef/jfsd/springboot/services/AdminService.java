package com.klef.jfsd.springboot.services;

import java.util.List;

import com.klef.jfsd.springboot.models.Admin;
import com.klef.jfsd.springboot.models.DeletedUsers;
import com.klef.jfsd.springboot.models.PlacementOfficer;
import com.klef.jfsd.springboot.models.Recruiter;
import com.klef.jfsd.springboot.models.Student;

public interface AdminService 
{
	public List<Student> viewAllStudents();
	public String deleteStudent(int sid , String sname); 
	public List<Recruiter> viewAllRecruiters();
	public String deleteRecruiter(int rid , String rname); 
	public List<PlacementOfficer> viewAllPlacementOfficers();
	public String deletePlacementOfficer(int pid , String pname); 
	public Admin checkAdminLogin(String auname,String apwd);
	public String updateRecruiterStatus(String s , int id);
	public String updateOfficerStatus(String s , int id);
	public List<Recruiter> getRegisteredRecruiters();
	public List<PlacementOfficer> getRegisteredOfficers();
	public List<DeletedUsers> getDeletedUsers();
	public String undodelete(int id);
	public String permanent(int id);
	public long studentcount();
	public long recruitercount();
	public long applicationscount();
	public long jobcount();
	public long filteredapplicationcount(String status);
	
	
}
