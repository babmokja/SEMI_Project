package com.BoB.mvc.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoB.mvc.customer.model.dto.StoreDetailDTO;
import com.BoB.mvc.customer.model.service.StoreDetailService;

/**
 * Servlet implementation class SelectStoreDetailServlet
 */
@WebServlet("/store/detail")
public class SelectStoreDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int storeId = Integer.parseInt(request.getParameter("storeId"));

		StoreDetailService storedetailService = new StoreDetailService();
		
		List<StoreDetailDTO> selectedPhoto = storedetailService.selectPhotoById(storeId);
		StoreDetailDTO selectedInfo = storedetailService.selectInfoById(storeId);
		StoreDetailDTO selectedReviewCnt = storedetailService.selectReviewCntById(storeId);
		List<StoreDetailDTO> selectedReview = storedetailService.selectReviewById(storeId);
		
		String path = "";
		if ((selectedPhoto != null) && (selectedInfo != null) && (selectedReviewCnt != null) && (selectedReview != null)) {
			path = "/WEB-INF/views/customer/StoreDetail.jsp";
			request.setAttribute("selectedPhoto", selectedPhoto);
			request.setAttribute("selectedInfo", selectedInfo);
			request.setAttribute("selectedReviewCnt", selectedReviewCnt);
			request.setAttribute("selectedReview", selectedReview);
			request.setAttribute("storeId", selectedPhoto.get(0).getStoreId());
		} else {
			path = "/WEB-INF/views/common/customer/failed.jsp";
			request.setAttribute("message", "가게 상세 정보를 조회할 수 없습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}

}
