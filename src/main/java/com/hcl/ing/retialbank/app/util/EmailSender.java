package com.hcl.ing.retialbank.app.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.hcl.ing.retialbank.app.dto.OtpRequest;
import com.hcl.ing.retialbank.app.entity.OtpDetails;
import com.hcl.ing.retialbank.app.repository.OtpRepository;

@Component
public class EmailSender {
	
	
	@Autowired
	public JavaMailSender emailSender;
	
	@Autowired
	private OtpRepository otpRepository;

	public void sendOtp(OtpRequest request) throws Exception{
		try {
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(request.getEmail());
			message.setSubject("OTP verification");
			Random random=new Random();
			int otp = random.nextInt(10000);
			Long userOtp=Long.valueOf(""+otp);
			
			OtpDetails findByAccountNo = otpRepository.findByAccountNo(request.getAccountNo());
			if(findByAccountNo!=null) {
				findByAccountNo.setOtp(userOtp);
				findByAccountNo.setOtpUsed('F');
				message.setText("This is OTP for adding payee : "+userOtp);
			}else {
				OtpDetails otpDetails=new OtpDetails();
				otpDetails.setAccountNo(request.getAccountNo());
				otpDetails.setOtp(userOtp);
				otpDetails.setOtpUsed('F');
				message.setText("This is OTP for adding payee : "+userOtp);
				otpRepository.save(otpDetails);
			}
			
			emailSender.send(message);
			
		} catch (Exception e) {
		}
	}

}
