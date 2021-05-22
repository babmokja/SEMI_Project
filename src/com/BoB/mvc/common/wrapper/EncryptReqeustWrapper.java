package com.BoB.mvc.common.wrapper;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptReqeustWrapper extends HttpServletRequestWrapper{


	public EncryptReqeustWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String key) {
		
		String value = "";
		
		if("userPwd".equals(key)) {
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(key)); 
		} else if("pw".equals(key)) {
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(key)); 
			System.out.println("Encrypt처리 완료");
		} else {
			value = super.getParameter(key);
		}
		return value;
	}

	
	
	
	


	
}
