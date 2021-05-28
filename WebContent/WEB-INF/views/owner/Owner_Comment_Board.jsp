<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owner/semi_board/Owner_Comment_Board.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owner/semi_board/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owner/semi_board/bootstrap.min.css">
    <title>Document</title>

    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
    <aside class="aside">
        <div class="aside_top2">BABMOKJA </div>
        <div class="aside_top">고객 댓글관리 </div>
    </aside>
  
    <section class="section">

        <div class="row">
            <span class="col-2 menu-item menu-item-selected">
              <img src="${pageContext.request.contextPath}/resources/image/owner/semi_board/item1.svg" />
              &nbsp;&nbsp;&nbsp;주문확인
            </span>
            <span class="col-2 menu-item  ">
              <img src="${pageContext.request.contextPath}/resources/image/owner/semi_board/item2.png" />
              &nbsp;&nbsp;&nbsp; 내 정보관리
            </span>
            <span class="col-2 menu-item">
              <img src="${pageContext.request.contextPath}/resources/image/owner/semi_board/item3.png" />
              
              &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board_sales/company/Owner_Sales_day_Board.html" >내 업소 관리</a>
            </span>
            <span class="col-2 menu-item">
              <img class="img-fluid" src="${pageContext.request.contextPath}/resources/image/owner/semi_board/computer.png" />
              &nbsp;&nbsp;&nbsp;<a class="text-dark" href="../../front_semi_store/views/delivery.html">pc주문현황</a>
            </span>

            <span class="col-2 menu-item">
                <span class="imagesize"><img src="${pageContext.request.contextPath}/resources/image/owner/semi_board/item4.svg" /></span>
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="Owner_Comment_Board.html">리뷰관리</a>
              </span>

              <span class="col-2 menu-item">
                <img src="${pageContext.request.contextPath}/resources/image/owner/semi_board/item4.svg" />
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="Owner_Seggestion_Board.html">1:1 문의하기</a>
              </span>
        </div>
       
         
    
    <div class="top-1">
        
        
        
        
        <!-- 검색 폼 -->
		<form id="loginForm" action="${ pageContext.servletContext.contextPath }/owner/searchreplycomment" method="get">		
			<div class="top" align="center">
			
										<!-- 선택한 카테고리 + 검색어 -->
										
				<c:choose>
				    <c:when test="${ !empty requestScope.searchValue }">
   					    <select id="searchCondition" name="searchCondition">
							<option value="reviewContent" <c:if test="${requestScope.searchCondition eq 'reviewContent'}">selected</c:if>>제목</option>
							<option value="satisfied" <c:if test="${requestScope.searchCondition eq 'satisfied'}">selected</c:if>>만족도</option>
							<option value="userId" <c:if test="${requestScope.searchCondition eq 'userId'}">selected</c:if>>고객아이디</option>
						</select>
				        <input type="search" id="searchValue" name="searchValue" value="${ requestScope.searchValue }">
				    </c:when>
				    <c:otherwise>
					    <select id="searchCondition" name="searchCondition">
							<option value="reviewContent">제목</option>
							<option value="satisfied">만족도</option>
							<option value="userId">고객아이디</option>
						</select>
				        <input type="search" id="searchValue" name="searchValue" >
				    </c:otherwise>
				</c:choose>
				<button type="submit" style="border: 1px solid black;">검색하기</button>
			</div>
		</form>
        
        
        
        
				       <!--  <div class="top">
				            만족도,제목,고객아이디
				            <select class="form-select" >
				              <option selected>카테고리 선택</option>
				              <option value="1">만족도</option>
				              <option value="2">제목</option>
				              <option value="3">고객아이디</option>
				            </select>
				        </div> -->
				
				        <!-- <div class="top">
				            만족도,제목,고객아이디 입력
				            <input class="form-control" type="text" >
				            
				        </div>
				          
				        <div class="top">
				            <br>
				            <button type="button" class="btn btn-outline-secondary">검색하기</button>
				        </div> -->
    </div>

            <table> 
                <thead>
                    <tr class="contest_top">
                        <th class="section_contest section_contest_1">번호</th>
                        <th class="section_contest section_contest_2">만족도</th>
                        <th class="section_contest section_contest_3">제목</th>
                        <th class="section_contest section_contest_4">고객아이디</th>
                        <th class="section_contest section_contest_5">작성일</th>
                        <th class="section_contest section_contest_6">주문일</th>
                    </tr>
                </thead>
                <c:forEach var="review" items="${ requestScope.reviewList }">
                <tbody>
                    <tr>
                        <td class="section_contest_first section_contest_1">${ review.rowNum }</td>
                        <td class="section_contest_first section_contest_2">${ review.satisfied }</td>
                        <td class="section_contest_first section_contest_3">${ review.reviewContent }</a></td>
                        <td class="section_contest_first section_contest_4">${ review.userId }</td>
                        <td class="section_contest_first section_contest_5">${ review.replyDate }</td>
                        <td class="section_contest_first section_contest_6">${ review.orderTime }</td>
                    </tr>

                    
                </tbody>
                </c:forEach>
            </table>





			<div class="center clearfix" align="center">
			<c:choose>
			    <c:when test="${ empty requestScope.searchValue }">
				    <button class="button button_space" id="startPage"><<</button>
	
					<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
						<button class="button button_space" disabled><</button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
						<button class="button button_space" id="prevPage"><</button>
					</c:if>
					<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
						<c:if test="${ requestScope.pageInfo.pageNo eq p }">
							<button class="button button_space" disabled><c:out value="${ p }"/></button>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo ne p }">
							<button class="button button_space" onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
						</c:if>
					</c:forEach>
					
					<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
						<button class="button button_space" disabled>></button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
						<button class="button button_space" id="nextPage">></button>
					</c:if>
					
					<button class="button button_space" id="maxPage">>></button> 
			     </c:when>
			     
			     
			    <c:otherwise>
   				    <button id="searchStartPage" class="button button_space"><<</button>
	
					<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
						<button class="button button_space" disabled><</button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
						<button class="button button_space" id="searchPrevPage"><</button>
					</c:if>
		
					<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
						<c:if test="${ requestScope.pageInfo.pageNo eq p }">
							<button class="button button_space" disabled><c:out value="${ p }"/></button>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo ne p }">
							<button class="button button_space" onclick="seachPageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
						</c:if>
					</c:forEach>
					
					<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
						<button class="button button_space" disabled>></button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
						<button class="button button_space" id="searchNextPage">></button>
					</c:if>
					
					<button class="button button_space" id="searchMaxPage">>></button> 
			    </c:otherwise>
			</c:choose>   
		</div>





            <!-- <div class="center clearfix">
                <div class="button button_space">1</div>
                <div class="button button_space">2</div>
                <div class="button button_space">3</div>
                <div class="button button_space">4</div>
                <div class="button">5</div>

            </div> -->
            
    </section>

    </div>
    
    
    <footer>
        <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
    
    
    <script>
		const link = "${ pageContext.servletContext.contextPath }/owner/replycomment";
		const searchLink = "${ pageContext.servletContext.contextPath }/owner/searchreplycomment";
			
		if(document.getElementById("startPage")) {
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function() {
				location.href = link + "?currentPage=1";
			}
		}
		
		if(document.getElementById("prevPage")) {
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo - 1 }";
			}
		}
		
		if(document.getElementById("nextPage")) {
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo + 1 }";
			}
		}
		
		if(document.getElementById("maxPage")) {
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.maxPage }";
			}
		}
		
		if(document.getElementById("searchStartPage")) {
			const $searchStartPage = document.getElementById("searchStartPage");
			$searchStartPage.onclick = function() {
				location.href = searchLink + "?currentPage=1&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchPrevPage")) {
			const $searchPrevPage = document.getElementById("searchPrevPage");
			$searchPrevPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.pageNo - 1 }&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchNextPage")) {
			const $searchNextPage = document.getElementById("searchNextPage");
			$searchNextPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.pageNo + 1 }&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchMaxPage")) {
			const $searchMaxPage = document.getElementById("searchMaxPage");
			$searchMaxPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.maxPage }&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementsByTagName("td")) {
			
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				
				/* $tds[i].onmouseenter = function() {
					this.parentNode.style.backgroundColor = "orangered";
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onmouseout = function() {
					this.parentNode.style.backgroundColor = "black";
				} */
				
				$tds[i].onclick = function() {
					/* alert(this.parentNode.children[0].innerText); */
					 var boardCode = $tds[0].innerHTML; 
	    			
					location.href = "${ pageContext.servletContext.contextPath }/owner/detailcomment?boardCode="+ boardCode;
				} 
				
			}
			
		}  
		
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text;
		}
		function seachPageButtonAction(text) {
			location.href = searchLink + "?currentPage=" + text + "&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
		}
	</script>
</body>
</html>