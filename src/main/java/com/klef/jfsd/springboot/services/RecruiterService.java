package com.klef.jfsd.springboot.services;

import java.util.List;

import com.klef.jfsd.springboot.models.Applications;
import com.klef.jfsd.springboot.models.Job;
import com.klef.jfsd.springboot.models.Photo;
import com.klef.jfsd.springboot.models.Recruiter;
import com.klef.jfsd.springboot.models.Student;

public interface RecruiterService 
{
  public String addJob(Job job);
  public Recruiter recruiterlogin(String email,String password);
  public List<Job> viewAllJobs(int rid);
  public String updateJob(Job job);
  public String deleteJob(int jid);
  public String recruiterRegistration(Recruiter r);
  public List<Applications> viewallapplicants(int rid);
  public String updateapplicationstatus(int id , String status);
	public String updateprofile(Recruiter r);
	public Recruiter getRecruiter(int id);
	public List<Applications> getCandidates(int id);
	public Student viewcandidatebyid(int aid);
	public Applications getApplicationbyId(int id);
   public String addimage(Photo p);
   public Photo viewimage(int id);
}
