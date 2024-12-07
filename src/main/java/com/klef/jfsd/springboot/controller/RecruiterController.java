package com.klef.jfsd.springboot.controller;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.klef.jfsd.springboot.models.Applications;
import com.klef.jfsd.springboot.models.Job;
import com.klef.jfsd.springboot.models.Photo;
import com.klef.jfsd.springboot.models.Recruiter;
import com.klef.jfsd.springboot.models.Student;
import com.klef.jfsd.springboot.services.RecruiterService;

import jakarta.mail.internet.MimeMessage;

@RestController
@RequestMapping("recruiter")
public class RecruiterController 
{
	  @Autowired
	  private RecruiterService recruiterService;
	  
	  @Autowired
		private JavaMailSender mailSender;
	  
	  @PostMapping("insertrecruiter")
	  public String insertrecruiter(@RequestBody Recruiter r)
	  {
	      String msg = recruiterService.recruiterRegistration(r);
	        return msg;
	  }
	  
	  @PostMapping("checkrecruiterlogin")
	  public Recruiter checkrecruiterlogin(@RequestParam("email") String email , @RequestParam("password") String password)
	  {
	   
	      Recruiter recruiter = recruiterService.recruiterlogin(email, password);
	      
	      return recruiter;
	  }
	  
	     @PostMapping("addjob")
		 public String addjob(@RequestBody Job job)
		 {
	    	 System.out.println(job.getRid());
			 return recruiterService.addJob(job);
		 }
	     
	     @GetMapping("viewjobs")
	     public List<Job> viewjobs(@RequestParam("id") int id)
	     {
	    	 return recruiterService.viewAllJobs(id);
	     }
	     
	     @DeleteMapping("deletejob")
	     public String deletejob(@RequestParam("id") int id)
	     {
	    	 return recruiterService.deleteJob(id);
	     }
	     
	     @GetMapping("viewapplicants")
	     public List<Applications> viewapplicants(@RequestParam("id") int rid)
	     {
	    	 return recruiterService.viewallapplicants(rid);
	     }
	     
	     @PutMapping("reviewcandidates")
	     public String reviewcandidates(@RequestParam("id") int id,@RequestParam("status") String status) throws Exception 
	     {
	         Student s = recruiterService.viewcandidatebyid(id);
	         String jtitle = recruiterService.getApplicationbyId(id).getjtitle();
	         String name = s.getName();
	         String toemail = s.getEmail();
	         String subject = "Job Status of " + jtitle;
	         MimeMessage mimeMessage = mailSender.createMimeMessage();
	         MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

	         helper.setTo(toemail);
	         helper.setSubject(subject);
	         helper.setFrom("placezen2110@gmail.com");

	         String htmlContent;
	         if (status.equalsIgnoreCase("Accepted")) {
	             htmlContent = "<!DOCTYPE html>\n" +
	                     "<html lang=\"en\">\n" +
	                     "<head>\n" +
	                     "    <meta charset=\"UTF-8\">\n" +
	                     "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
	                     "    <title>Job Application Status</title>\n" +
	                     "    <style>\n" +
	                     "        body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; max-width: 600px; margin: 0 auto; padding: 20px; background-color: #f4f4f4; }\n" +
	                     "        .container { background-color: white; border-radius: 10px; padding: 30px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }\n" +
	                     "        .header { background-color: #4a90e2; color: white; text-align: center; padding: 20px; border-top-left-radius: 10px; border-top-right-radius: 10px; }\n" +
	                     "        .content { margin-top: 20px; }\n" +
	                     "        .details { background-color: #f9f9f9; border-left: 4px solid #4a90e2; padding: 15px; margin: 20px 0; }\n" +
	                     "        .cta-button { display: block; width: 200px; margin: 20px auto; padding: 12px 20px; background-color: #4a90e2; color: white; text-align: center; text-decoration: none; border-radius: 5px; font-weight: bold; }\n" +
	                     "        .footer { text-align: center; margin-top: 20px; font-size: 0.8em; color: #777; }\n" +
	                     "    </style>\n" +
	                     "</head>\n" +
	                     "<body>\n" +
	                     "    <div class=\"container\">\n" +
	                     "        <div class=\"header\">\n" +
	                     "            <h1>Job Application Accepted</h1>\n" +
	                     "        </div>\n" +
	                     "        <div class=\"content\">\n" +
	                     "            <p>Dear " + name + ",</p>\n" +
	                     "            <p>We are pleased to inform you that your application for the position of <strong>" + jtitle + "</strong> has been <strong>Accepted</strong>.</p>\n" +
	                     "            <div class=\"details\">\n" +
	                     "                <h3>Interview Details:</h3>\n" +
	                     "                <p><strong>Date:</strong> " + "18th December 2024" + "</p>\n" +
	                     "                <p><strong>Time:</strong> " + "9:00 AM to 10:00AM" + "</p>\n" +
	                     "                <p><strong>Venue:</strong> " + "Hyderabad" + "</p>\n" +
	                     "            </div>\n" +
	                     "            <p>Please confirm your attendance by replying to this email. If you have any questions or need to reschedule, contact our HR team.</p>\n" +
	                     "        </div>\n" +
	                     "        <div class=\"footer\">\n" +
	                     "            <p>© 2024 Company Name | Recruitment Division</p>\n" +
	                     "        </div>\n" +
	                     "    </div>\n" +
	                     "</body>\n" +
	                     "</html>";
	         } else if (status.equalsIgnoreCase("Rejected")) {
	             htmlContent = "<!DOCTYPE html>\n" +
	                     "<html lang=\"en\">\n" +
	                     "<head>\n" +
	                     "    <meta charset=\"UTF-8\">\n" +
	                     "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
	                     "    <title>Job Application Status</title>\n" +
	                     "    <style>\n" +
	                     "        body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; max-width: 600px; margin: 0 auto; padding: 20px; background-color: #f4f4f4; }\n" +
	                     "        .container { background-color: white; border-radius: 10px; padding: 30px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }\n" +
	                     "        .header { background-color: #e24a4a; color: white; text-align: center; padding: 20px; border-top-left-radius: 10px; border-top-right-radius: 10px; }\n" +
	                     "        .content { margin-top: 20px; }\n" +
	                     "        .footer { text-align: center; margin-top: 20px; font-size: 0.8em; color: #777; }\n" +
	                     "    </style>\n" +
	                     "</head>\n" +
	                     "<body>\n" +
	                     "    <div class=\"container\">\n" +
	                     "        <div class=\"header\">\n" +
	                     "            <h1>Job Application Status</h1>\n" +
	                     "        </div>\n" +
	                     "        <div class=\"content\">\n" +
	                     "            <p>Dear " + name + ",</p>\n" +
	                     "            <p>We regret to inform you that your application for the position of <strong>" + jtitle + "</strong> has not been successful at this time.</p>\n" +
	                     "            <p>We encourage you to apply for other roles in the future and thank you for your interest in joining our company.</p>\n" +
	                     "        </div>\n" +
	                     "        <div class=\"footer\">\n" +
	                     "            <p>© 2024 Company Name | Recruitment Division</p>\n" +
	                     "        </div>\n" +
	                     "    </div>\n" +
	                     "</body>\n" +
	                     "</html>";
	         } else {
	             throw new IllegalArgumentException("Invalid application status provided.");
	         }

	         helper.setText(htmlContent, true);
	         mailSender.send(mimeMessage);

	         return recruiterService.updateapplicationstatus(id, status);
	     }

	     
	    
	     
	     @PutMapping("updateProfile")
			public String updateProfile(@RequestBody Recruiter r)
			{
				return recruiterService.updateprofile(r);
			}
			
			@GetMapping("getprofile")
			public Recruiter getRecruiter(@RequestParam int id)
			{
				return recruiterService.getRecruiter(id);
			}
			
			@GetMapping("getCandidates")
			public List<Applications> getcandidates(@RequestParam int id)
			{
				return recruiterService.getCandidates(id);
			}
			
			@PostMapping("addimage")
		      public String addimage(@RequestParam("image") MultipartFile file, @RequestParam("id") int id) throws Exception
		      {
		         byte[] bytes = file.getBytes();
		          Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
		          Photo p = new Photo();
		          p.setId(id);
		          p.setImage(blob);
		          return recruiterService.addimage(p);
		      }
		      
		      @GetMapping("displayimage")
		      public ResponseEntity<byte[]> displayimage(@RequestParam int id) throws Exception
		      {
		        Photo p =  recruiterService.viewimage(id);
		        byte [] imageBytes = null;
		        imageBytes = p.getImage().getBytes(1,(int) p.getImage().length());

		        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
		        
		      // Response Body, HTTP Status Code, Headers
		      }
	     
	     
}