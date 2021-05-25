<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/admin_Owner_Secret_Board.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/main1.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/bootstrap.min.css">
    <title>Document</title>

    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
    <aside class="aside">
        <div class="aside_top2">BABMOKJA </div>
        <div class="aside_top">업주 게시판 </div>
        <div class="button01"><a href="${pageContext.servletContext.contextPath}/admin/customer/board">고객</a></div>
        <div class="button02">업주</div>
    </aside>
  
    <section class="section">

        <div class="row">
            <span class="col-2 menu-item">
                <a href="${pageContext.servletContext.contextPath}/admin/order" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item1.png" />
                  &nbsp;&nbsp;&nbsp;주문확인   </a>
              </span>
              <span class="col-2 menu-item  ">
                <a href="${pageContext.servletContext.contextPath}/admin/customer" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item2.png" />
                  &nbsp;&nbsp;&nbsp; 고객관리</a>
              </span>
              <span class="col-2 menu-item">
                <a href="${pageContext.servletContext.contextPath}/admin/owner" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item3.png" />
                
                  &nbsp;&nbsp;&nbsp; 업소관리</a> 
              </span>
            <span class="col-2 menu-item">
              <img src="/SEMI_Project/resources/image/admin/item4.png" />
              &nbsp;&nbsp;&nbsp; <a href="${pageContext.servletContext.contextPath}/admin/customer/board">게시판</a>
            </span>
          </div>

        <div class="section_top">
            
        
        <div class="top-1">
        
            <form id="loginForm" action="${ pageContext.servletContext.contextPath }/admin/owner/board/search" method="get">
              <div class="row">
                <c:choose>
				    <c:when test="${ !empty requestScope.searchValue }">
   					    <div class="col-3">
	                  제목,글쓴이
	                  <select class="form-select" id="searchCondition" name="searchCondition" >
	                    <option value="boardTitle" <c:if test="${requestScope.searchCondition eq 'boardTitle'}">selected</c:if>>제목</option>
		                <option value="userName"<c:if test="${requestScope.searchCondition eq 'userName'}">selected</c:if>>글쓴이</option>
	                  </select>
	                </div>
	                <div class="col-3">
	                  제목,글쓴이 입력
	                  <input class="form-control" type="search" id="searchValue" name="searchValue" value="${ requestScope.searchValue }" >
	                </div>
				    </c:when>
				    <c:otherwise>
						    <div class="col-3">
		                  제목,글쓴이
		                  <select class="form-select" id="searchCondition" name="searchCondition" >
		                    <option value="boardTitle">제목</option>
		                    <option value="userName">글쓴이</option>
		                  </select>
		                </div>
		                <div class="col-3">
		                  제목,글쓴이 입력
		                  <input class="form-control" type="search" id="searchValue" name="searchValue" >
		                </div>
				    </c:otherwise>
				</c:choose>
                
                <div class="col-3">
                  <br>
                  <button type="submit" class="btn btn-outline-secondary">검색하기</button>
                </div>
              </div>
              </form>
        </div>

            <table> 
                <thead>
                    <tr class="contest_top">
                        <th class="section_contest section_contest_1">번호</th>
                        <th class="section_contest section_contest_2">말머리</th>
                        <th class="section_contest section_contest_3">제목</th>
                        <th class="section_contest section_contest_4">글쓴이</th>
                        <th class="section_contest section_contest_5">작성일</th>
                    </tr>
                </thead>

                <tbody>
					<c:forEach var="board" items="${ requestScope.boardList }">
					<c:choose>
			    	<c:when test="${ board.visible =='Y' }">
					<tr>
						<td class="section_contest_first section_contest_1"><c:out value="${ board.boardCode }"/></td>
                        <td class="section_contest_first section_contest_2">건의</td>
                        <td class="section_contest_first section_contest_3"><a href="${pageContext.servletContext.contextPath}/admin/owner/comment"><c:out value="${ board.boardTitle }"/></a></td>
                        <td class="section_contest_first section_contest_4"><c:out value="${ board.userName }"/></td>
                        <td class="section_contest_first section_contest_5"><c:out value="${ board.boardDate }"/></td>
					</tr>
					</c:when>
					</c:choose>
					</c:forEach>
                    
                    
                </tbody>
            </table>
<br>
			<br>
              <div class="text-center">
           
                	
                <c:choose>
			    <c:when test="${ empty requestScope.searchValue }">
				    <button id="startPage"><<</button>
	
					<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
						<button disabled><</button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
						<button id="prevPage"><</button>
					</c:if>
		
					<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
						<c:if test="${ requestScope.pageInfo.pageNo eq p }">
							<button disabled><c:out value="${ p }"/></button>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo ne p }">
							<button onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
						</c:if>
					</c:forEach>
					
					<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
						<button disabled>></button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
						<button id="nextPage">></button>
					</c:if>
					
					<button id="maxPage">>></button> 
			     </c:when>
			    <c:otherwise>
   				    <button id="searchStartPage"><<</button>
	
					<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
						<button disabled><</button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
						<button id="searchPrevPage"><</button>
					</c:if>
		
					<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
						<c:if test="${ requestScope.pageInfo.pageNo eq p }">
							<button disabled><c:out value="${ p }"/></button>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo ne p }">
							<button onclick="seachPageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
						</c:if>
					</c:forEach>
					
					<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
						<button disabled>></button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
						<button id="searchNextPage">></button>
					</c:if>
					
					<button id="searchMaxPage">>></button> 
			    </c:otherwise>
			</c:choose>   
              </div>
            
        </div>
    </section>

    <footer>
        <address class="footer footer-text"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
            <script>
		const link = "${ pageContext.servletContext.contextPath }/admin/owner/board";
		const searchLink = "${ pageContext.servletContext.contextPath }/admin/owner/board/search";
			
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
		
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text;
		}
		function seachPageButtonAction(text) {
			location.href = searchLink + "?currentPage=" + text + "&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}";
		}
	</script>
</body>
</html>