package com.BoB.mvc.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptReqeustWrapper extends HttpServletRequestWrapper{

	/* 부모쪽에 기본생성자가 존재하지 않기 때문에 request를 전달해주는 생성자가 필요하다. */
	public EncryptReqeustWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String key) {
		
		String value = "";
		
		if("ownerPwd".equals(key)) {
			/* 스프링 시큐리티 중 BCrypt암호화를 제공해주는 라이브러리*/
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(key)); 
		} else {
			value = super.getParameter(key);
		}
		return value;
	}

	
}
