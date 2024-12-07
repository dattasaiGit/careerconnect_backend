package com.klef.jfsd.springboot.controller;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.klef.jfsd.springboot.models.Photo;
import com.klef.jfsd.springboot.models.PlacementOfficer;
import com.klef.jfsd.springboot.models.Student;
import com.klef.jfsd.springboot.services.PlacementOfficerService;

import jakarta.mail.internet.MimeMessage;

@RestController
@RequestMapping("officer")
public class PlacementOfficerController 
{
	@Autowired
	private PlacementOfficerService placementofficerService;
	
	@Autowired
	private JavaMailSender mailSender;

	
	@PostMapping("insertofficer")
	public String insertofficer(@RequestBody PlacementOfficer officer)
	{
		
	    String msg = placementofficerService.PlacementofficerRegistration(officer);
	    
	    return msg;
	}
	

	
	
	@PostMapping("insertstudent")
	  public String insertStudent(@RequestBody Student s) throws Exception {
	      String name = s.getName();
	      String toemail = s.getEmail();
	      String subject = "Welcome to PlaceZen - Registration Successful";
	      
	      // Embedded HTML template
	      String htmlContent = "<!DOCTYPE html>" +
	      "<html lang=\"en\">" +
	      "<head>" +
	          "<meta charset=\"UTF-8\">" +
	          "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
	          "<title>Welcome to PlaceZen</title>" +
	          "<style>" +
	              "body { font-family: 'Arial', sans-serif; line-height: 1.6; color: #333; max-width: 600px; margin: 0 auto; padding: 20px; background-color: #f4f4f4; }" +
	              ".container { background-color: white; border-radius: 10px; padding: 30px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }" +
	              ".header { background-color: #4a90e2; color: white; text-align: center; padding: 20px; border-top-left-radius: 10px; border-top-right-radius: 10px; }" +
	              ".header h1 { margin: 0; font-size: 24px; }" +
	              ".content { margin-top: 20px; }" +
	              ".password-info { background-color: #f0f0f0; border-left: 4px solid #4a90e2; padding: 15px; margin: 20px 0; }" +
	              ".footer { margin-top: 30px; text-align: center; color: #666; font-size: 12px; }" +
	              ".cta-button { display: block; width: 200px; margin: 20px auto; padding: 12px 20px; background-color: #4a90e2; color: white; text-align: center; text-decoration: none; border-radius: 5px; font-weight: bold; }" +
	          "</style>" +
	      "</head>" +
	      "<body>" +
	          "<div class=\"container\">" +
	              "<div class=\"header\">" +
	                  "<h1>Welcome to PlaceZen</h1>" +
	              "</div>" +
	              
	              "<div class=\"content\">" +
	                  "<p>Dear " + name + ",</p>" +
	                  
	                  "<p>Congratulations! You have been successfully registered on the PlaceZen placement portal. We're excited to have you on board and help you navigate your career journey.</p>" +
	                  
	                  "<div class=\"password-info\">" +
	                      "<strong>Initial Login Details:</strong>" +
	                      "<p>Username: Your registered email<br>" +
	                      "Temporary Password: <code>klef1234</code></p>" +
	                      "<p><strong>Important:</strong> Please change your password immediately after your first login for account security.</p>" +
	                  "</div>" +
	                  
	                  "<a href=\"https://placezen.com/login\" class=\"cta-button\">Login to PlaceZen</a>" +
	                  
	                  "<p>If you have any questions or need assistance, please don't hesitate to reach out to our support team. We're here to help you succeed!</p>" +
	                  
	                  "<p>Best regards,<br>" +
	                  "The PlaceZen Team</p>" +
	              "</div>" +
	              
	              "<div class=\"footer\">" +
	                  "<p>© 2024 PlaceZen. All rights reserved.<br>" +
	                  "This is an automated email. Please do not reply.</p>" +
	              "</div>" +
	          "</div>" +
	      "</body>" +
	      "</html>";
	      
	      MimeMessage mimeMessage = mailSender.createMimeMessage();
	      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

	      helper.setTo(toemail);
	      helper.setSubject(subject);
	      helper.setFrom("placezen2110@gmail.com");
	      
	      // Set the HTML content
	      helper.setText(htmlContent, true);
	      mailSender.send(mimeMessage);

	      String msg = placementofficerService.addStudent(s);
	      return msg;
	  }
	
	 @PostMapping("checkofficerlogin")
	  public PlacementOfficer checkofficerlogin(@RequestParam("email") String email , @RequestParam("password") String password)
	  {
	    
	      PlacementOfficer officer = placementofficerService.checkofficerlogin(email, password);
	      
	     
	      return officer;
	  }
	 
	 @PutMapping("updateProfile")
		public String updateProfile(@RequestBody PlacementOfficer p)
		{
			return placementofficerService.updateprofile(p);
		}
		
		@GetMapping("getprofile")
		public PlacementOfficer getOfficer(@RequestParam int id)
		{
			return placementofficerService.getOfficer(id);
		}
		
		@PostMapping("addimage")
	    public String addimage(@RequestParam("image") MultipartFile file, @RequestParam("id") int id) throws Exception
	    {
	       byte[] bytes = file.getBytes();
	        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
	        Photo p = new Photo();
	        p.setId(id);
	        p.setImage(blob);
	        return placementofficerService.addimage(p);
	    }
	    
	    @GetMapping("displayimage")
	    public ResponseEntity<byte[]> displayimage(@RequestParam int id) throws Exception
	    {
	      Photo p =  placementofficerService.viewimage(id);
	      byte [] imageBytes = null;
	      imageBytes = p.getImage().getBytes(1,(int) p.getImage().length());

	      return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	      
	    // Response Body, HTTP Status Code, Headers
	    }
	 
	 
	
}
