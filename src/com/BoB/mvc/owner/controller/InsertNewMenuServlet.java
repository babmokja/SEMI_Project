package com.BoB.mvc.owner.controller;

import java.io.File;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.net.FileNameMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.deploy.FileMessage;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.BoB.mvc.owner.model.dto.MenuListDTO;
import com.BoB.mvc.owner.model.dto.PictureDTO;
import com.BoB.mvc.owner.model.service.MenuListService;

/**
 * Servlet implementation class InsertNewMenuServlet
 */
@WebServlet("/menu/new")
public class InsertNewMenuServlet extends HttpServlet {
	
	private String rootLocation;
	private int maxFileSize;
	private String encodingType;
	
	@Override
	public void init() throws ServletException{
		
		ServletContext context = getServletContext();
		// web.xml context-param속성에 지정한 값들은 getInitParameter()메소드를 이용해서 꺼내어 쓸수있다.
		rootLocation = context.getInitParameter("upload-location");
		maxFileSize = Integer.parseInt(context.getInitParameter("max-file-size"));
		encodingType = context.getInitParameter("encoding-type");
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String path ="/WEB-INF/views/owner/MenuManage.jsp";
//		
//		request.getRequestDispatcher(path).forward(request, response);
		
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doPost test in insert servlet");
		
		if(ServletFileUpload.isMultipartContent(request)) {
		System.out.println("파일 저장 ROOT 경로: "+ rootLocation);
		System.out.println("최대 업로드 파일 용량: "+ maxFileSize);
		System.out.println("인코딩 방식: "+ encodingType);
		
		String fileUploadDirectory = rootLocation + "/semi";
		
		File directory = new File(fileUploadDirectory);
		
		//파일 저장경로가 존재하지 않는 경우 디렉토리를 생성하자
		if(!directory.exists()) {
			/* 폴더를 한개만 생성할거면 mkdir, 상위 폴더도 존재하지않으면 한번에 생성하라는 의미로 mkdirs를 이용하자*/
			System.out.println("폴더 생성 : "+ directory.mkdirs());
	
		}
		
		/*
		 * 최종적으로 request를 parsing 하고 파일을 저장한뒤 필요한 내용을 담을 리스트와 맵이다.
		 * 파일에 대한 정보는 리스트 (fileList)에 다른 파라미터의 정보를 모두 맵에 답을것ㄱ이다.
		 */
		Map<String,String> parameter = new HashMap<>();
		Map<String,String> fileList = new HashMap<>();
		
		/* 파일을 업로드할 시 최대 크기나 임시 저장할 폴더의 경로 등을 포함하기 위한 인스턴스 */
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		fileItemFactory.setRepository(new File(fileUploadDirectory));
		fileItemFactory.setSizeThreshold(maxFileSize);
		
		/* 서블릿에서 기본 제공하는 인스턴스 말고 꼭 commons fileUpload 라이브러리에 있는 클래스로 임포트 해야한다.*/
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		
		try {
			
			/* request를 파싱하여 데이터 하나 한를 FileItem 인스턴스로 반환한다. */
			List<FileItem> fileItem = fileUpload.parseRequest(request);
			
			for(FileItem item: fileItem) {
				System.out.println(item);
			}
			
				/* 폼 데이터 isFormField 속성이 true이고, 파일은 isFormField 속성이 false이다. */
				System.out.println("fileItem:  "+fileItem);
				Map<String, String> fileMap =null;
			
			for(int i=0; i<fileItem.size();i++) {
				FileItem itm = fileItem.get(i);
				
				if(!itm.isFormField()) { 
			
					if(itm.getSize()>0) {
						
						
						String filedName = itm.getFieldName();
						String originFileName = itm.getName();
						java.util.Date UploadDate = new java.util.Date(System.currentTimeMillis());
						SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
						
						String upload = dateFormat.format(UploadDate);
					
						
						int dot= originFileName.lastIndexOf(".");
						System.out.println("dot"+ dot);
						String ext = originFileName.substring(dot);
						System.out.println("ext"+ ext);
						
						String randomFileName = UUID.randomUUID().toString().replace("-", "")+ext;
						
						File storeFile = new File(fileUploadDirectory+"/"+randomFileName);
						
						// 삭제테스트를 위해서 강제로 에러를 발생시킴
						// String str="";
//						System.out.println(str.charAt(1));
						
						itm.write(storeFile);
						
						/* 필요한 정보를 Map에 담는다 -> 디비에 저장하기위해 */
						fileMap = new HashMap<>();
//						fileMap.put("fileName", filedName);
						fileMap.put("originFileName", originFileName);
						fileMap.put("saveFileName", randomFileName);
						fileMap.put("savePath", fileUploadDirectory);
						fileMap.put("uploadDate", upload);
						
					}
					
				}else {
				
					parameter.put(itm.getFieldName(), new String(itm.getString().getBytes("ISO-8859-1"),"UTF-8"));	
				}
			}
			System.out.println("parameter: "+ parameter);
			System.out.println("fileMap: "+ fileMap);
			
			MenuListDTO newMenu = new MenuListDTO();
			newMenu.setMenuName(parameter.get("menuName"));
			newMenu.setPrice(Integer.parseInt(parameter.get("price")));
			newMenu.setSalesYN(parameter.get("salesYN"));
			newMenu.setMenuExplain(parameter.get("menuExplain"));
			
//			newMenu.setPicture(new ArrayList<PictureDTO>());
			
			
				Set<String> keySet = parameter.keySet();
				Iterator<String> keyIter = keySet.iterator();
				
				while(keyIter.hasNext()) {
					switch(keyIter.toString()) {
					case "menuName":
						newMenu.setMenuName(parameter.get("menuName"));
						break;
					case "price":
						newMenu.setPrice(Integer.parseInt(parameter.get("price")));
						break;
					case "salesYN":
						newMenu.setSalesYN(parameter.get("salesYN"));
						break;
					case "menuExplain":
						newMenu.setMenuExplain(parameter.get("menuExplain"));
						break;
				
	
					}
					
				}
//				System.out.println(newMenu);
				MenuListService menuService = new MenuListService();
				int result = menuService.insertBoard(newMenu);
				
				String path ="";
				if(result>0) {
					path="/WEB-INF/views/owner/MenuManage.jsp";
//					request.setAttribute(name, o);
				}else{
					path="/WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "메뉴등록에 실패하셨습니다! 다시 등록해주세요.");
				}
				request.getRequestDispatcher(path).forward(request, response);
							
			
		}catch(Exception e) {
			
			/* 어떤 종류의 exception이 발생해서 실패를 하더라도 파일을 삭제해야한다. */
			int cnt = 0;
//			for(int i=0;i<fileList.size();i++) {
//				Map<String,String> file = fileList.get(i)
;
				File deleteFile = new File(fileUploadDirectory +"/"+fileList.get("savedFileName"));
				boolean isDeleted = deleteFile.delete();
				
				if(isDeleted) {
					cnt++;
				}
//			}
			if(cnt == fileList.size()) {
				System.out.println("없로드에 실패");
				
			}else {
				e.printStackTrace();
			}
		}
		
	
//		String menuName = request.getParameter("menuName");
//		int price = Integer.parseInt(request.getParameter("price"));
//		String salesYN = request.getParameter("salesYN");
//		String menuExplain = request.getParameter("menuExplain");
		
		
		
	

		
	}
}

}
