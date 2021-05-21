package com.BoB.mvc.owner.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.BoB.mvc.owner.model.dto.LicenseManagerDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.PictureDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;
import com.BoB.mvc.owner.model.service.OwnerService;

/**
 * Servlet implementation class OwnerRegistServlet
 */
@WebServlet("/member/owner/regist")
public class OwnerRegistServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/owner/signin_owner.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			System.out.println("파일 저장 Root 경로 : " + rootLocation);
			System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
			System.out.println("인코딩 방식 : " + encodingType);
			
			/* 경로를 맞춘다. */
			
			// C:\\upload-files/commons
			String fileUploadDirectory = rootLocation + "/commons";
			
			/* 파일에 추가 */
			/* string을 폴더(file 객체)로 만들어주기위해 */ 
			File directory = new File(fileUploadDirectory);
			
//			------------ 폴더 위치 생성 ------------
			
			// exists() : 파일이 있는지 여부를 판단해서 있으면 true, 없으면 false
			// 파일 저장경로가 존재하지 않는 경우 디렉토리를 생성하자
			if(!directory.exists()) { 
				/* 폴더를 한 개만 생성할거면 mkdir, 상위 폴더도 존재하지 않으면 한 번에 생성하라는 의미로 mkdirs를 이용하자 */
				System.out.println("폴더 생성 : " + directory.mkdirs()); //boolean 리턴 생성하고 잘됐는지 안됐는지 true false반환
			}
			
			
			
			/*
			 * 최종적으로 request를 parsing하고 파일을 저장한 뒤 필요한 내용을 담을 리스트와 맵이다.
			 * 파일에 대한 정보는 리스트(fileList)에 다른 파라미터의 정보는 모두 맵에 담을 것이다.
			 */
			
			/* 파일이 여러개일 수 있으니 리스트 / 파일에대한 정보 속성을 키밸류값으로 갖고있는것을 리스트에 담는다.*/
			List<Map<String,String>> fileList = new ArrayList<>();
			/* 파일결과값말고 파라미터 담아주는 공간 / parameter, fileList 이둘을 db에 넣어준다.*/
			Map<String,String> parameter = new HashMap<>();
			
			
//			--------------------------------------------------
			
			/* 파일에 대한 속성정보를 commons는 객체단위로 만들어놔야함 */
			/* 파일을 업로드할 때 최대 크기나 임시 저장할 폴더의 경로 등을 포함하기 위한 인스턴스 */
			/* 즉, fileItemFactory는 commons의 속성정보를 담고있다. */
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			/* 저장공간 */
			fileItemFactory.setRepository(new File(fileUploadDirectory));
			fileItemFactory.setSizeThreshold(maxFileSize);
			
//			-----------------------------------------
			
			/* 서블릿에서 기본 제공하는 인스턴스 말고 꼭 commons fileUpload 라이브러리에 있는 클래스로 임포트 해야 한다. */
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			
//			-----------------------------------------
			
			try {
				/* request를 parsing(변환작업)해서 데이터 하나하나(폼태그 파일에 대한 정보)를 FileItem 인스턴스로 반환한다. 리스트에 담아줄것이다. 리스트에 담기위해.... */	
				
				/* 즉, jsp의 폼태그에서 받아온 값들을 fileItems에 넣는다.*/
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				System.out.println("================= fileItems에 뭐가있나 출력=================");
				for(FileItem itim : fileItems) {
					/* ********** 폼 데이터는 isFormField 속성이 true, 파일은 isFormField 속성이 false 이다.************************* */
					/* input태그의 name = 출력문의 FieldName이다. 
					 * isformfield로 파일vs폼태그 구분가능 ,즉 이력서 올릴때 사진, 나머지 input태그 값들은 parameter로 쪼개서 따로 관리
					 * temp에 임시저장 후 업로드하겠다.
					 * 파일이 여러개일경우 리스트로 다뽑아온다.
					 */					
					System.out.println(itim);
				}
				
				
				// isFormField 결과에 따라 각 방식으로 뽑아쓰면된다. 파일은 파일대로 태그는 태그대로
				for(int i= 0; i< fileItems.size();i++) {
					FileItem item = fileItems.get(i);
					
					/* 분기 처리 */
					if(!item.isFormField()) { // 파일 데이터인 경우
						
//						--------------------------- 업로드 파일 정제작업 (파일명 필터링, 확장자 필터링) ------------------
						if(item.getSize() > 0) {
							/*
							 * 파일의 사이즈가 0보다 커야 전송된 파일이 있다는 의미
							 * 전송된 파일이 있는 경우에만 처리하고, 0인 경우에는 무시하도록 로직을 작성하겠다.
							 */
							String filedName = item.getFieldName(); // 태그 name값
							String originFileName = item.getName(); // 파일원본이름
							
//							System.out.println("filedName : " + filedName);
//							System.out.println("originFileName : " + originFileName);
							
							/* 
							 * 업로드되는 파일명을 변경작업
							 * 1. 동일한 파일명이 들어왔을 때를 대비
							 * 2. 특수문자 또는 입력받기 힘든 문자를 받았을 때를 대비 (업로드가 안되기때문)
							 */
							
							int dot = originFileName.lastIndexOf(".");
							System.out.println("dot : " +  dot);
							String ext = originFileName.substring(dot); // substring 지정한 시작점부터 끝까지 가져온다
							System.out.println("ext : " + ext);
																					/* randomUUID로 인한 특수문자('-') 제거 */
							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;
							
							/* 저장할 파일 정보를 담을 인스턴스를 생성하고 ***지금까지 중복방지처리한 파일명을 넣어 파일생성경로를 설정한다.***** */
							File storeFile = new File(fileUploadDirectory + "/" + randomFileName);
							
							// 삭제테스트를 위해서 강제로 에러를 발생 시킴
//							String str = "";
//							System.out.println(str.charAt(1));
							
							/* **************저장한다.********************** */
							item.write(storeFile);
							
//							------------------------여기까지 file upload 끝!!!!  이제 DB에 넘겨줄 값을 담아줄것이다. -----------------------
							
//							이제 DB에 넘겨줄 값을 담아줄것이다. DB에 넣어줄 샘플링 파일 업로드해줫을때 저장해줄 기본정보 , 파일업로드날짜 수정된날짜, 삭제여부
							
							/* 필요한 정보를 Map에 담는다. */
							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("fileName", filedName);				// 태그 name값
							fileMap.put("originFileName", originFileName);	// 파일 원본이름
							fileMap.put("saveFileName", randomFileName);	// 저장된 파일이름
							fileMap.put("savePath", fileUploadDirectory);	// 파일 저장경로
							
							fileList.add(fileMap);
							
							
							
						}
					} else {
						// form 데이터인 경우
						/*
						 * 전송된 폼의 name은 getFieldName()으로 받아오고,
						 * 해당 필드의 value는 getString()으로 받아온다.
						 * 보내는 곳에서 인코딩 설정을 하더라도 받는곳에서는 전송되는 파라미터를 ISO-8859-1로 처리한다.
						 * "별도로" ISO-8859-1로 해석된 한글을 UTF-8로 변경해주어야 한다.
						 */
//						request.setCharacterEncoding("UTF-8");
//						parameter.put(item.getFieldName(), item.getString());
//						ISO8859로 받고 0101바이트로 바꾸고(.getBytes) 그 0101바이트를 new String으로 UTF-8로 바꾼다는 뜻
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"),"UTF-8") ); // form 태그의 value값을 넣어준다.
						/* ******************** 무조건 이렇게 해줘야한다.********************* */
					}
				}
				
				System.out.println("parameter : " + parameter); // form 태그의 value값을 넣어줬다.
				System.out.println("fileList : " + fileList);
				
				
//				---------- PICTURE테이블-------
				
//				---사업자등록증---
				PictureDTO pict1 = new PictureDTO();
				pict1.setOriginName(fileList.get(0).get("originFileName"));
				pict1.setRevisedName(fileList.get(0).get("saveFileName"));
				pict1.setRoute(fileList.get(0).get("savePath"));
				
				System.out.println(pict1);
				
//				---가게사진---
				PictureDTO pict2 = new PictureDTO();
				pict2.setOriginName(fileList.get(1).get("originFileName"));
				pict2.setRevisedName(fileList.get(1).get("saveFileName"));
				pict2.setRoute(fileList.get(1).get("savePath"));
				
				System.out.println(pict2);
				
				Map<String, PictureDTO> picture = new HashMap<String, PictureDTO>();
				picture.put("pict1", pict1);
				picture.put("pict2", pict2);
				
				
//				---------LICENSE MANAGE 테이블-----
				
				LicenseManagerDTO lm = new LicenseManagerDTO();
				lm.setSbName(parameter.get("sbName"));
				lm.setBISI(parameter.get("BISI"));
				lm.setOpenDate(Date.valueOf(parameter.get("openDate")));
				lm.setAddress(parameter.get("addr1")  + " " + parameter.get("addr2"));
				lm.setCondition(parameter.get("condition"));
				lm.setMajor(parameter.get("major"));
				lm.setMainAddress(parameter.get("mainAddress"));
				lm.setIssueDate(Date.valueOf(parameter.get("issueDate")));
				
				
				System.out.println(lm);
				
//				------- USER 테이블---------
				
				OwnerDTO owner = new OwnerDTO();
				owner.setMemberId(parameter.get("memberId"));
				String value = "";
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

				value = passwordEncoder.encode(parameter.get("pw"));
				owner.setMemberPwd(value);
//				owner.setMemberPwd(parameter.get("pw"));

//				System.out.println(value);
				owner.setName(parameter.get("named"));
				owner.setPhone(parameter.get("phone").replace("-",""));
				owner.setAddress(parameter.get("addr1")  + " " + parameter.get("addr2"));
				owner.setEmail(parameter.get("email"));
				owner.setResidentNum(parameter.get("residentNum"));
				
				System.out.println(owner);
				
//				----- storeinfo테이블----
				
				StoreInfoDTO store = new StoreInfoDTO();
				store.setStoreName(parameter.get("storeName"));
				store.setBusinessNum(Integer.parseInt(parameter.get("businessNum").replace("-","")));
				store.setStoreXY(parameter.get("storeXY"));
				store.setStoreIntro(parameter.get("storeIntro"));
				store.setCategory(parameter.get("category"));
				store.setAddress(parameter.get("address"));
				store.setTypeCode(Integer.parseInt(parameter.get("service")));
				
				System.out.println(store);
				
				
				
				
//				
				
				/* 서비스 메소드를 요청한다. */
				int result = new OwnerService().registOwner(picture,lm,owner,store);
				
				/* 성공 실패 페이지를 구분하여 연결한다. */
				String path = "";
				if(result > 0) {
					path = "/WEB-INF/views/common/success.jsp";
					request.setAttribute("successCode", "insertOwner");
				} else {
					path = "/WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "사업자 등록 실패!");
				}
				
				request.getRequestDispatcher(path).forward(request, response);
//				
//				
//				
				
				
				
				
				
			} catch(Exception e) {
				
				/* 어떤 종류의 Exception이 발생해서 실패를 하더라도 파일을 삭제해야 한다. */
				int cnt = 0;
				for(int i = 0 ; i < fileList.size();i++) {
					Map<String,String> file = fileList.get(i);
					
					File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
					boolean isDeleted = deleteFile.delete();
					
					if(isDeleted) {
						cnt++;
					}
				}
				
				if(cnt == fileList.size()) {
					System.out.println("업로드에 실패한 모든 사진 삭제완료!");
				} else {
					e.printStackTrace();
				}
				
			}
	}

		
		
	}

}
