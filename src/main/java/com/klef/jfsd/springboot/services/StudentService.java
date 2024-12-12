package com.klef.jfsd.springboot.services;

import java.util.List;

import com.klef.jfsd.springboot.models.Applications;
import com.klef.jfsd.springboot.models.Job;
import com.klef.jfsd.springboot.models.Photo;
import com.klef.jfsd.springboot.models.Resume;
import com.klef.jfsd.springboot.models.Student;
import com.klef.jfsd.springboot.models.TrainingSessions;

public interface StudentService 
{
	public List<Job> viewAllJobs();
	public Student checkstudentlogin(String email, String password);
	public String applyjob(Applications a);
	public Job getJobbyId(int id);
	public List<Applications> getApplications(int id);
	public String addResume(Resume r);
	public String updateprofile(Student s);
	public Student getStudentByid(int id);
	public String updatePassword(String password , int id);
	public Resume viewResumeById(int id);
	public Student getStudentbyid(int id);
	public String addimage(Photo p);
	public TrainingSessions viewsession(String id);
	public List<TrainingSessions> viewallsessions();
    public Photo viewimage(int id);
}
