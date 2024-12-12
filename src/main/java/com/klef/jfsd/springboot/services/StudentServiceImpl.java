package com.klef.jfsd.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.models.Applications;
import com.klef.jfsd.springboot.models.Job;
import com.klef.jfsd.springboot.models.Photo;
import com.klef.jfsd.springboot.models.Resume;
import com.klef.jfsd.springboot.models.Student;
import com.klef.jfsd.springboot.models.TrainingSessions;
import com.klef.jfsd.springboot.repository.ApplicationsRepository;
import com.klef.jfsd.springboot.repository.JobRepository;
import com.klef.jfsd.springboot.repository.PhotoRepository;
import com.klef.jfsd.springboot.repository.ResumeRepository;
import com.klef.jfsd.springboot.repository.StudentRepository;
import com.klef.jfsd.springboot.repository.TrainingSessionsRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentrepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private ApplicationsRepository applicationsRepository;
	
	@Autowired
	private ResumeRepository resumeRepository;
	
	@Autowired
	private PhotoRepository photoRepository;

	@Autowired
	private TrainingSessionsRepository sessionsRepository;
	
	@Override
	public List<Job> viewAllJobs() 
	{
		return jobRepository.findAll();
	}

	@Override
	public Student checkstudentlogin(String email, String password) 
	{
		return studentrepository.checkstudentlogin(email, password);
	}

	@Override
	public String applyjob(Applications a) {
		
		if(applicationsRepository.checkapplication(a.getSid(), a.getJid())!=null)
			return "Already Applied";
		
		applicationsRepository.save(a);
		return "Applied to the Job";
	}

	@Override
	public Job getJobbyId(int id) {
		return jobRepository.findById(id).get();
	}

	@Override
	public List<Applications> getApplications(int id) {
		return applicationsRepository.getApplications(id);
	}

	@Override
	public String addResume(Resume r) {
		
		 resumeRepository.save(r);
		 return "Resume Added Successfully";
	}

	@Override
	public String updateprofile(Student s) {
	    Student existingStudent = studentrepository.findById(s.getId()).get();

	    existingStudent.setName(s.getName());
	    existingStudent.setGender(s.getGender());
	    existingStudent.setDateofbirth(s.getDateofbirth());
	    existingStudent.setDepartment(s.getDepartment());
	    existingStudent.setEmail(s.getEmail());
	    existingStudent.setContact(s.getContact());
	  

	    studentrepository.save(existingStudent);

	    return "Profile Updated Successfully";
	}

	@Override
	public Student getStudentByid(int id) {
		return studentrepository.findById(id).get();
	}

	@Override
	public String updatePassword(String password, int id) {
		
		studentrepository.updatepassword(password, id);
		return "Password Updated Successfully";
	}

	@Override
	public Resume viewResumeById(int id) {
		return resumeRepository.findById(id).get();
	}

	@Override
	public Student getStudentbyid(int id) {
		return studentrepository.findById(id).get();
	}
	
	@Override
	  public String addimage(Photo p) {
	    photoRepository.save(p);
	    return "Profile Image added Successfully";
	  }

	  @Override
	  public Photo viewimage(int id) {
	    return photoRepository.findById(id).get();
	  }

	@Override
public TrainingSessions viewsession(String id) {
	return sessionsRepository.findById(id).get();
}

@Override
public List<TrainingSessions> viewallsessions() {
	return sessionsRepository.findAll();
}

}
