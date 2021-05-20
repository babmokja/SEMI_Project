package com.BoB.mvc.customer.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UserReviewServlet
 */
@WebServlet("/review")
public class UserReviewServlet extends HttpServlet {

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("check");
//		String path = "/WEB-INF/views/customer/Review.jsp";
//		
//		request.getRequestDispatcher(path).forward(request, response);
//				
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			ServletContext context = request.getServletContext();
			String rootLocation = context.getInitParameter("upload-location");
			int maxFileSize = Integer.parseInt(context.getInitParameter("max-file-size"));
			String encodingType = context.getInitParameter("encoding-type");
			
			String singleFileUploadDirectory = rootLocation + "/plz/insert";
			
			File directory = new File(singleFileUploadDirectory);
			
			if(!directory.exists()) {
				
				System.out.println("폴더 생성 : " + directory.mkdirs());
			}
			
			MultipartRequest multiRequest = new MultipartRequest(request, singleFileUploadDirectory, maxFileSize, encodingType);
			
			int satisfied = Integer.parseInt(multiRequest.getParameter("emoji"));
			System.out.println(satisfied);
			String reviewContent  = multiRequest.getParameter("reviewContent");
			System.out.println(reviewContent);
			
			Enumeration<String> names = multiRequest.getFileNames();
			while(names.hasMoreElements()) {
				System.out.println(names.nextElement());
			}
			
			String originFileName = multiRequest.getOriginalFileName("singlefile");
			System.out.println("form 전송된 파일의 원본 이름 : " + originFileName);
			
			String filePath = singleFileUploadDirectory;
			
		}
			
		
		int satisfied = Integer.parseInt(request.getParameter("emoji"));
		String reviewContent = request.getParameter("reviewContent");
		
	    
		
		
	}

}
