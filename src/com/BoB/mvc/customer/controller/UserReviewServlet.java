package com.BoB.mvc.customer.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.BoB.mvc.customer.model.dto.ReviewDTO;
import com.BoB.mvc.customer.model.dto.UserDTO;
import com.BoB.mvc.customer.model.dto.UserOrderDTO;
import com.BoB.mvc.customer.model.service.ReviewService;
import com.BoB.mvc.owner.model.dto.PictureDTO;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UserReviewServlet
 */
@WebServlet("/review")
public class UserReviewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("check");
		String order= request.getParameter("order");
		String store= request.getParameter("store");
		
	   
//		Object store= request.getAttribute("store");
		
		request.setAttribute("order",order);
	    request.setAttribute("store",store);
		
		System.out.println(order);
		System.out.println(store);
      
		String path = "/WEB-INF/views/customer/Review.jsp";
		request.getRequestDispatcher(path).forward(request, response);
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
	
		if(ServletFileUpload.isMultipartContent(request)) {
			
			ServletContext context = request.getServletContext();
			String rootLocation = context.getInitParameter("upload-location");
			int maxFileSize = Integer.parseInt(context.getInitParameter("max-file-size"));
			String encodingType = context.getInitParameter("encoding-type");
			
			String singleFileUploadDirectory = rootLocation;
			
			File directory = new File(singleFileUploadDirectory);
			
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(new File(singleFileUploadDirectory));
	        fileItemFactory.setSizeThreshold(maxFileSize);
			
	        //ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			
	        
	        
			if(!directory.exists()) {
				
				System.out.println("폴더 생성 : " + directory.mkdirs());
			}
			

			MultipartRequest multiRequest = new MultipartRequest(request, singleFileUploadDirectory, maxFileSize, encodingType);

			
			String originFileName = multiRequest.getOriginalFileName("image");
			System.out.println("form 전송된 파일의 원본 이름 : " + originFileName);
			
			
			String filePath = singleFileUploadDirectory;
			
			int writerMemberNo = ((UserDTO) request.getSession().getAttribute("loginUser")).getUserCode();
			
			multiRequest.getFile("image");
			

			
			int satisfied =  Integer.parseInt(multiRequest.getParameter("emoji"));
			System.out.println(satisfied);
			String reviewContent  = multiRequest.getParameter("reviewContent");
			System.out.println(reviewContent);
			
			int orderCode =  Integer.parseInt(multiRequest.getParameter("order"));
			int storeCode =  Integer.parseInt(multiRequest.getParameter("store"));
			
			System.out.println("storeCode"+storeCode);
			System.out.println("orderCode"+orderCode);
			ReviewDTO review = new ReviewDTO();
			review.setSatisfied(satisfied);
			review.setReviewContent(reviewContent);
			review.setOrderCode(orderCode);
			review.setStoreCode(storeCode);

			
			System.out.println("서블릿에서 리뷰정보"+review);

			review.setPicture(new ArrayList<PictureDTO>());
			
			List<PictureDTO> list = review.getPicture();
			
	       PictureDTO tempFileInfo = new PictureDTO();
		   tempFileInfo.setOriginName(originFileName);
		   tempFileInfo.setRoute(singleFileUploadDirectory);
           list.add(tempFileInfo);
           System.out.println("리뷰값"+review);
           
           int result = new ReviewService().insertReview(review);
           
           //리뷰 잘들어갔으니 이제포인트 적립!!
           
           int pointResult = new ReviewService().insertPoint(writerMemberNo);
	
           String path="";
   		   if(result  > 0 && pointResult >0 ) {
   			path = "/WEB-INF/views/customer/CustomerMain.jsp";
   			request.setAttribute("successCode", "insertBoard");
   		    } else {
   			path = "/WEB-INF/views/common/failed.jsp";
   			request.setAttribute("message", "");
   		    }
	   
   		   request.getRequestDispatcher(path).forward(request, response);
		  }
			

		
	}

}

