package com.BoB.mvc.owner.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BoB.mvc.owner.model.dto.LicenseManagerDTO;
import com.BoB.mvc.owner.model.dto.OwnerDTO;
import com.BoB.mvc.owner.model.dto.PageInfoDTO;
import com.BoB.mvc.owner.model.dto.ReviewBoardListDTO;
import com.BoB.mvc.owner.model.dto.StoreInfoDTO;
import com.BoB.mvc.owner.model.service.OwnerService;
import com.BoB.mvc.owner.paging.OwnerPaging;

/**
 * Servlet implementation class OwnerBoardReplyCommentList
 */
@WebServlet("/owner/replycomment")
public class OwnerBoardReplyCommentListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		OwnerDTO dto = (OwnerDTO) session.getAttribute("ownerDTO");
		LicenseManagerDTO lmDTO = (LicenseManagerDTO) session.getAttribute("lmDTO");
		StoreInfoDTO storeDTO = (StoreInfoDTO) session.getAttribute("storeInfoDTO");
		
		if(dto==null) {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script> alert('로그인 후 사용 바랍니다'); location.href ='"+ request.getContextPath() +"/main';</script>");
			writer.close();


		} else {
		
		/* 프론트에서 넘어져오는 값 */
		String currentPage = request.getParameter("currentPage");
		/* 맨처음 페이지 클릭했을 때 보여줄 곳 = 1페이지     설정 안할 시 null로 아무것도 안뜬다.*/
		int pageNo = 1;
		
		/* 숫자 버튼 누를시 1페이지만 이동않도록 분기처리 (빈문자열만 아니면 된다) */
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		/* 0이하 정수는 1로 처리하도록 분기처리*/
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		/* 전체 게시물 수가 필요 */
		/* 데이터베이스에서 먼저 전체 게시물 수를 조회 */
		OwnerService ownerService = new OwnerService();
		int totalCount = ownerService.selectReviewReplyTotalCount(storeDTO);
		
		System.out.println("totalCount 체크 : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 7;
		/* 한 번에 보여질 페이징 버튼의 수*/
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		PageInfoDTO pageInfo = OwnerPaging.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println(pageInfo);
		
		/* 조회 해온다. */
		List<ReviewBoardListDTO> reviewList = ownerService.selectReviewList(pageInfo,storeDTO);
		
		System.out.println("reviewList : " + reviewList);
		
		String path = "";
		if(reviewList != null) {
			path = "/WEB-INF/views/owner/Owner_Comment_Board.jsp";
			request.setAttribute("reviewList", reviewList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	}
		
}
