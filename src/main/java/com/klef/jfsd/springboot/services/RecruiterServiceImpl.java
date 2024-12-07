package com.klef.jfsd.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.models.Applications;
import com.klef.jfsd.springboot.models.Job;
import com.klef.jfsd.springboot.models.Photo;
import com.klef.jfsd.springboot.models.Recruiter;
import com.klef.jfsd.springboot.models.Student;
import com.klef.jfsd.springboot.repository.ApplicationsRepository;
import com.klef.jfsd.springboot.repository.JobRepository;
import com.klef.jfsd.springboot.repository.PhotoRepository;
import com.klef.jfsd.springboot.repository.RecruiterRepository;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class RecruiterServiceImpl implements RecruiterService
{
  @Autowired
  private RecruiterRepository recruiterRepository;
  
  @Autowired
	private JobRepository jobRepository;
  
  @Autowired
  private StudentRepository studentRepository;
  
  @Autowired
  	private ApplicationsRepository applicationsRepository;
  
  @Autowired
  private PhotoRepository photoRepository;
  
  @Override
	public String addJob(Job j) 
	{
	  jobRepository.save(j);
		return "Job Added Successfully";
	}

  @Override
  public List<Job> viewAllJobs(int rid)
  {
    return jobRepository.findByRid(rid);
  }

  @Override
  public String updateJob(Job job) 
  {
    return null;
  }

  @Override
  public String deleteJob(int jid) 
  {
	  jobRepository.deletejob(jid);
    return "Job Deleted Successfully";
  }

  @Override
  public String recruiterRegistration(Recruiter r) 
  {
    recruiterRepository.save(r);
    return "Registered Successfully!!";
  }

  @Override
  public Recruiter recruiterlogin(String email, String password) 
  {
    Recruiter r = recruiterRepository.recruiterlogin(email, password);
    if(r.getStatus().equals("Accepted"))
    {
    	return r;
    }
    else
    {
    	return null;
    }
  }

@Override
public List<Applications> viewallapplicants(int rid) {
	return applicationsRepository.findByRid(rid);
	
}

@Override
public String updateapplicationstatus(int id, String s) {
	applicationsRepository.updateapplicationstatus(s, id);
	return "Candidate Status Updated Successful";
}

@Override
public String updateprofile(Recruiter r) {
    Recruiter existingRecruiter = recruiterRepository.findById(r.getId()).get();

    existingRecruiter.setName(r.getName());
    existingRecruiter.setGender(r.getGender());
    existingRecruiter.setDateofbirth(r.getDateofbirth());
    existingRecruiter.setCompany(r.getCompany());
    existingRecruiter.setEmail(r.getEmail());
    existingRecruiter.setContact(r.getContact());
    

    recruiterRepository.save(existingRecruiter);

    return "Profile Updated Successfully";
}


@Override
public Recruiter getRecruiter(int id) {
	return recruiterRepository.findById(id).get();
}

@Override
public List<Applications> getCandidates(int id) {
	
	return applicationsRepository.getCandidates(id);
}

@Override
public Student viewcandidatebyid(int rid ) {
	int sid = applicationsRepository.findById(rid).get().getSid();
	return studentRepository.findById(sid).get();
}

@Override
public Applications getApplicationbyId(int id) {
	return applicationsRepository.findById(id).get();
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


}