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
import com.BoB.mvc.owner.model.dto.SuggestionDTO;
import com.BoB.mvc.owner.model.service.OwnerService;
import com.BoB.mvc.owner.model.service.SuggestionService;
import com.BoB.mvc.owner.paging.OwnerPaging;

/**
 * Servlet implementation class SelectSuggestionList
 */
@WebServlet("/suggestion/list")
public class SelectSuggestionList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		OwnerDTO ownerDTO = (OwnerDTO) session.getAttribute("ownerDTO");
		LicenseManagerDTO lmDTO = (LicenseManagerDTO) session.getAttribute("lmDTO");
		StoreInfoDTO storeDTO = (StoreInfoDTO) session.getAttribute("storeInfoDTO");
		
		if(ownerDTO==null) {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 후 이용가능합니다'); location.href='/WEB-INF/views/owner/main_store.jsp\';</script>");
			writer.close();
			
			
		} else {
			
			int ownerCode = ownerDTO.getUserCode();
			System.out.println("현재 로그인한 id는 " + ownerDTO.getMemberId());
			
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
			SuggestionService Service = new SuggestionService();
			int totalCount = Service.selectSuggestionTotalCount(ownerCode);
			
			System.out.println("totalCount 체크 : " + totalCount);
			
			/* 한 페이지에 보여 줄 게시물 수 */
			int limit = 7;
			/* 한 번에 보여질 페이징 버튼의 수*/
			int buttonAmount = 5;
			
			/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
			PageInfoDTO pageInfo = OwnerPaging.getPageInfo(pageNo, totalCount, limit, buttonAmount);
			
			System.out.println(pageInfo);
			
		
		String path ="";
		
		List<SuggestionDTO> suggestionList = new SuggestionService().selectAllSuggestion(pageInfo,ownerCode);
		
		if(suggestionList !=null) {
			path="/WEB-INF/views/owner/Owner_Suggestion_Board_List.jsp";
			request.setAttribute("suggestionList", suggestionList);
			request.setAttribute("pageInfo", pageInfo);
		}else {
			path="/WEB-INF/views/common/faild.jsp";
			request.setAttribute("message", "문의 목록을 불러오는데 실패하셨습니다. 다시 페이지를 시작해주세요!");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}
}


}
