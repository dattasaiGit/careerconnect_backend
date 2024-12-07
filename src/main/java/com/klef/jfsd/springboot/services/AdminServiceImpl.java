package com.klef.jfsd.springboot.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.models.Admin;
import com.klef.jfsd.springboot.models.DeletedUsers;
import com.klef.jfsd.springboot.models.PlacementOfficer;
import com.klef.jfsd.springboot.models.Recruiter;
import com.klef.jfsd.springboot.models.Student;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.DeletedUsersRepository;
import com.klef.jfsd.springboot.repository.PlacementOfficerRepository;
import com.klef.jfsd.springboot.repository.RecruiterRepository;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class AdminServiceImpl implements AdminService
{

	@Autowired
	private AdminRepository adminrepository;
	@Autowired
	private RecruiterRepository recruiterRepository;
	@Autowired
	private PlacementOfficerRepository officerRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private DeletedUsersRepository deleRepository;
	
	@Override
	public List<Student> viewAllStudents()
	{
		return studentRepository.findAccepted();
	}

	@Override
	public String deleteStudent(int sid , String sname) 
	{
		studentRepository.updatestudentstatus("Deleted", sid);
		DeletedUsers du  = new DeletedUsers();
		du.setUid(sid);
		du.setRole("Student");
		du.setName(sname);
		LocalDate localDate = LocalDate.now();
		Date sqlDate = Date.valueOf(localDate);
		du.setDeletedon(sqlDate);
		deleRepository.save(du);
		return "Student Deleted Successfully.";
	}

	@Override
	public List<Recruiter> viewAllRecruiters() 
	{
		return recruiterRepository.findAccepted();
	}

	@Override
	public String deleteRecruiter(int rid , String rname) 
	{
		recruiterRepository.updaterecruiterstatus("Deleted", rid);
		DeletedUsers du  = new DeletedUsers();
		du.setUid(rid);
		du.setRole("Recruiter");
		du.setName(rname);
		LocalDate localDate = LocalDate.now();
		Date sqlDate = Date.valueOf(localDate);
		du.setDeletedon(sqlDate);
		deleRepository.save(du);
		return "Recruiter Deleted Successfully.";
	}

	@Override
	public List<PlacementOfficer> viewAllPlacementOfficers() 
	{
		return officerRepository.findAccepted();
	}

	@Override
	public String deletePlacementOfficer(int pid , String pname) 
	{
		officerRepository.updateofficerstatus("Deleted", pid);
		DeletedUsers du  = new DeletedUsers();
		du.setUid(pid);
		du.setRole("Placement-Officer");
		du.setName(pname);
		LocalDate localDate = LocalDate.now();
		Date sqlDate = Date.valueOf(localDate);
		du.setDeletedon(sqlDate);
		
		deleRepository.save(du);
		
		return "Placement-Officer Deleted Successfully.";
	}

	@Override
	public Admin checkAdminLogin(String auname, String apwd) 
	{
		return adminrepository.checkAdminLogin(auname, apwd);
	}

	@Override
	public String updateRecruiterStatus(String s,int id) {
		recruiterRepository.updaterecruiterstatus(s, id);
		return "Status of Recruiter is"+s;
	}

	@Override
	public String updateOfficerStatus(String s, int id) {
		officerRepository.updateofficerstatus(s, id);
		return "Status of Placement-Officer is"+s;
	}

	@Override
	public List<Recruiter> getRegisteredRecruiters() {
		return recruiterRepository.findByStatus("registered");
	}

	@Override
	public List<PlacementOfficer> getRegisteredOfficers() {
		return officerRepository.findByStatus("registered");
	}

	@Override
	public List<DeletedUsers> getDeletedUsers() {
		return deleRepository.findAll();
	}

	@Override
	public String undodelete(int id) {
		DeletedUsers d = deleRepository.findById(id).get();
		System.out.println(d.getRole());
		if(d.getRole().equals("Student"))
		{
			System.out.println(d.getUid());
			studentRepository.updatestudentstatus("Accepted", d.getUid());
			deleRepository.delete(d);
		}
		else if(d.getRole().equals("Recruiter"))
		{
			recruiterRepository.updaterecruiterstatus("Accepted", d.getUid());
			deleRepository.delete(d);
		}
		else
		{
			officerRepository.updateofficerstatus("Accepted", d.getUid());
			deleRepository.delete(d);
		}
		
		return "User Recovered Successfully";
	}

	@Override
	public String permanent(int id) {
		DeletedUsers d = deleRepository.findById(id).get();
		if(d.getRole().equals("Student"))
		{
			studentRepository.deleteById(d.getUid());
			deleRepository.delete(d);
		}
		else if(d.getRole().equals("Recruiter"))
		{
			recruiterRepository.deleteById(d.getUid());
			deleRepository.delete(d);
		}
		else
		{
			officerRepository.deleteById(d.getUid());
			deleRepository.delete(d);
		}
		
		return "User Permanently Deleted";
	}
	
	
	
	}


