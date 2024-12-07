package com.klef.jfsd.springboot.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.models.Admin;
import com.klef.jfsd.springboot.models.Applications;
import com.klef.jfsd.springboot.models.Job;
import com.klef.jfsd.springboot.models.Photo;
import com.klef.jfsd.springboot.models.Resume;
import com.klef.jfsd.springboot.models.Student;
import com.klef.jfsd.springboot.services.StudentService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.mail.javamail.MimeMessageHelper;
import jakarta.mail.internet.MimeMessage;


@RestController
@RequestMapping("student")
public class StudentController 
{
	@Autowired
	private StudentService studentservice;
	
	 
	 @Autowired
	private JavaMailSender mailSender;
	  

	
	@PostMapping("checkstudentlogin")
	public Student checkstudentlogin(@RequestParam("email") String email , @RequestParam("password") String password)
	{
		System.out.println("Email = "+email);
		
		return studentservice.checkstudentlogin(email, password);
		
	}
	
	@PutMapping("updatepassword")
	public String updatepassword(@RequestParam("password") String password , @RequestParam("id") int id)
	{
		return studentservice.updatePassword(password, id);
	}
	
	@GetMapping("viewalljobs")
	public List<Job> viewalljobs() {
	    
	    return studentservice.viewAllJobs();
	}
	
	@PostMapping("applyjob")
	public String applyjob(@RequestBody Applications a) throws Exception
	{
		Student s = studentservice.getStudentbyid(a.getSid());
   	 String jtitle = a.getjtitle();
   	 String name = s.getName();
		String toemail = s.getEmail();
		String subject = "Applied to the job :"+jtitle;
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(toemail);
		helper.setSubject(subject);
		helper.setFrom("placezen2110@gmail.com");
		String htmlContent = name+" You have applied to the"+jtitle+"Job";
		helper.setText(htmlContent, true);
		mailSender.send(mimeMessage);
   	
		return studentservice.applyjob(a);
	}
	
	@GetMapping("getjob")
	public Job getjob(int id)
	{
		return studentservice.getJobbyId(id);
	}
	
	@GetMapping("myapplications")
	public List<Applications> myjobs(@RequestParam("id") int sid)
	{
		return studentservice.getApplications(sid);
	}
	
	@PostMapping("addResume")
	public String addResume(@RequestParam("sid") int sid, @RequestParam("resume") MultipartFile file) throws Exception {
	    byte[] bytes = file.getBytes();
	    Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

	    Resume resume = new Resume();
	    resume.setResume(blob);
	    resume.setSid(sid); 

	    return studentservice.addResume(resume);
	}

	

	
	@PutMapping("updateProfile")
	public String updateProfile(@RequestBody Student s)
	{
		return studentservice.updateprofile(s);
	}
	
	@GetMapping("getStudent")
	public Student getStudent(@RequestParam int id)
	{
		return studentservice.getStudentByid(id);
	}
	
	@PostMapping("addimage")
	  public String addimage(@RequestParam("image") MultipartFile file, @RequestParam("id") int id) throws Exception
	  {
	     byte[] bytes = file.getBytes();
	      Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
	      Photo p = new Photo();
	      p.setId(id);
	      p.setImage(blob);
	      return studentservice.addimage(p);
	  }
	  
	  @GetMapping("displayimage")
	  public ResponseEntity<byte[]> displayimage(@RequestParam int id) throws Exception
	  {
	    Photo p =  studentservice.viewimage(id);
	    byte [] imageBytes = null;
	    imageBytes = p.getImage().getBytes(1,(int) p.getImage().length());

	    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	    
	  // Response Body, HTTP Status Code, Headers
	  }
	  
	  @GetMapping("displayresume")
	  public ResponseEntity<byte[]> displayResume(@RequestParam int id) throws Exception {
	     
	      Resume resume = studentservice.viewResumeById(id);
	      
	     
	      byte[] pdfBytes = resume.getResume().getBytes(1, (int) resume.getResume().length());

	      
	      return ResponseEntity.ok()
	                           .contentType(MediaType.APPLICATION_PDF)  
	                           .body(pdfBytes);  
	  }
	
	
}
