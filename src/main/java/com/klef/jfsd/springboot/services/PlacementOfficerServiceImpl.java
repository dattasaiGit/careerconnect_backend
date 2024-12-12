package com.klef.jfsd.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.models.Job;
import com.klef.jfsd.springboot.models.Photo;
import com.klef.jfsd.springboot.models.PlacementOfficer;
import com.klef.jfsd.springboot.models.Recruiter;
import com.klef.jfsd.springboot.models.Student;
import com.klef.jfsd.springboot.models.TrainingSessions;
import com.klef.jfsd.springboot.repository.JobRepository;
import com.klef.jfsd.springboot.repository.PhotoRepository;
import com.klef.jfsd.springboot.repository.PlacementOfficerRepository;
import com.klef.jfsd.springboot.repository.StudentRepository;
import com.klef.jfsd.springboot.repository.TrainingSessionsRepository;

@Service
public class PlacementOfficerServiceImpl implements PlacementOfficerService
{
	@Autowired
	private PlacementOfficerRepository placementofficerRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private PhotoRepository photoRepository;

	@Autowired
	private TrainingSessionsRepository  sessionsRepository;
	
	@Override
	public String addStudent(Student s) 
	{
		studentRepository.save(s);
		return "Student Added Successfully";
	}

	@Override
	public List<Student> viewAllStudents() 
	{
		return null;
	}

	@Override
	public String deleteStudent(int sid) 
	{
		return null;
	}


	@Override
	public String PlacementofficerRegistration(PlacementOfficer p)
	{
	   placementofficerRepository.save(p);
	   return "Registered Successfully!!";
	}

	@Override
	public PlacementOfficer checkofficerlogin(String email, String password) 
	{
		return placementofficerRepository.checkofficerlogin(email, password);
	}

	@Override
	public String updateprofile(PlacementOfficer p) {
	    PlacementOfficer existingOfficer = placementofficerRepository.findById(p.getId()).get();

	    existingOfficer.setName(p.getName());
	    existingOfficer.setGender(p.getGender());
	    existingOfficer.setDateofbirth(p.getDateofbirth());
	    existingOfficer.setDepartment(p.getDepartment());
	    existingOfficer.setEmail(p.getEmail());
	    existingOfficer.setContact(p.getContact());
	   

	    placementofficerRepository.save(existingOfficer);

	    return "Profile Updated Successfully";
	}

	@Override
	public PlacementOfficer getOfficer(int id) {
		return placementofficerRepository.findById(id).get();
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
	public String addsessions(TrainingSessions s) {
		sessionsRepository.save(s);
		return "Training Session Added Successfully";
	}

	@Override
	public List<TrainingSessions> viewsessions() {
		return sessionsRepository.findAll();
	}

	@Override
	public String deletesessions(String id) {
		sessionsRepository.deleteById(id);
		return "Session Deleted Successfully";
	}

}

	
	
	

