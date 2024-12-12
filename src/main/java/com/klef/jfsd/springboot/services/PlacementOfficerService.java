package com.klef.jfsd.springboot.services;

import java.util.List;

import com.klef.jfsd.springboot.models.Job;
import com.klef.jfsd.springboot.models.Photo;
import com.klef.jfsd.springboot.models.PlacementOfficer;
import com.klef.jfsd.springboot.models.Recruiter;
import com.klef.jfsd.springboot.models.Student;
import com.klef.jfsd.springboot.models.TrainingSessions;

public interface PlacementOfficerService 
{
	public String addStudent(Student s);
	public List<Student> viewAllStudents();
	public String deleteStudent(int sid); 
	public String PlacementofficerRegistration(PlacementOfficer p);
	public PlacementOfficer checkofficerlogin(String email,String password);
	public String updateprofile(PlacementOfficer p);
	public PlacementOfficer getOfficer(int id);
	public String addimage(Photo p);
	public Photo viewimage(int id);
	public String addsessions(TrainingSessions s);
	public List<TrainingSessions> viewsessions();
	public String deletesessions(String id);
}
