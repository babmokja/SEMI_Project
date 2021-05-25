<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문확인</title>
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/order.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/main.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/semi_store/bootstrap.min.css">
</head>
<body>
    <aside class="aside">
       <div class="aside_top2"><a href="${ pageContext.servletContext.contextPath }/main" 
        style="text-decoration: none;
   		color: black;
    	font-style: normal;
    	font-weight: bolder;}"> babmokja </a></div>
        <div class="aside_top">주문확인</div>
       
    </aside>

    <section class="section">

          <div class="row">
            <span class="col-2 menu-item menu-item-selected">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item1.svg" />
                &nbsp;&nbsp;&nbsp;<a href="order.html">주문확인</a>
              </span>
              <span class="col-2 menu-item  ">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item2.png" />
                &nbsp;&nbsp;&nbsp; 내 정보관리
              </span>
              <span class="col-2 menu-item">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item3.png" />
                
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/menu/all">내 업소 관리</a>
              </span>
              <span class="col-2 menu-item">
                <img class="img-fluid" src="${ pageContext.servletContext.contextPath }/resources/image/owner/computer.png" />
                &nbsp;&nbsp;&nbsp;<a class="text-dark" href="${ pageContext.servletContext.contextPath }/owner/delivery">PC주문현황</a>
              </span>
  
              <span class="col-2 menu-item">
                  <span class="imagesize"><img src="${ pageContext.servletContext.contextPath }/image/owner/item4.svg" /></span>
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board (업체용 게시판)/company/Owner_Comment_Board.html">리뷰관리</a>
                </span>
  
                <span class="col-2 menu-item">
                  <img src="${ pageContext.servletContext.contextPath }/image/owner/item4.svg" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/suggestion/list">1:1 문의하기</a>
                </span>
        </div>

        <div class="section_top">
            

       
        <div class="space"></div>


            <table> 
                <thead>
                    <tr>
                        <th class="section_contest section_contest_1">주문번호</th>
                        <th class="section_contest section_contest_2">고객아이디(고객명)</th>
                        <th class="section_contest section_contest_3">주문일자</th>
                        <th class="section_contest section_contest_4">주문상태</th>
                        <th class="section_contest section_contest_4">금액</th>
                    </tr>
                </thead>
                <tbody>

					<c:forEach var="board" items="${ requestScope.orderList }">
					<tr>
						<td><c:out value="${ board.orderNum }"/></td>
						<td><c:out value="${ board.cusName }"/></td>
						<td><c:out value="${ board.orderDate }"/></td>
						<td><c:out value="${ board.type }"/></td>
						<td><c:out value="${ board.price }"/></td>
					</tr>
					</c:forEach>
                    
                    
                </tbody>
            </table>
        <div class="text-center">
           
                	
                <c:choose>
			    <c:when test="${ empty requestScope.searchValue }">
				    <button id="startPage" class="btn btn-warning"><<</button>
	
					<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
						<button class="btn btn-warning" disabled><</button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
						<button class="btn btn-warning" id="prevPage"><</button>
					</c:if>
		
					<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
						<c:if test="${ requestScope.pageInfo.pageNo eq p }">
							<button class="btn btn-warning" disabled><c:out value="${ p }"/></button>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo ne p }">
							<button class="btn btn-warning" onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
						</c:if>
					</c:forEach>
					
					<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
						<button class="btn btn-warning" disabled>></button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
						<button class="btn btn-warning" id="nextPage">></button>
					</c:if>
					
					<button class="btn btn-warning" id="maxPage">>></button> 
			     </c:when>
			    <c:otherwise>
   				    <button class="btn btn-warning" id="searchStartPage"><<</button>
	
					<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
						<button class="btn btn-warning" disabled><</button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
						<button class="btn btn-warning" id="searchPrevPage"><</button>
					</c:if>
		
					<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
						<c:if test="${ requestScope.pageInfo.pageNo eq p }">
							<button class="btn btn-warning" disabled><c:out value="${ p }"/></button>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo ne p }">
							<button class="btn btn-warning" onclick="seachPageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
						</c:if>
					</c:forEach>
					
					<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
						<button class="btn btn-warning" disabled>></button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
						<button class="btn btn-warning" id="searchNextPage">></button>
					</c:if>
					
					<button class="btn btn-warning" id="searchMaxPage">>></button> 
			    </c:otherwise>
			</c:choose>   
              </div>
            
        </div>
    </section>

    <footer>
        <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
    
    <script>
		const link = "${ pageContext.servletContext.contextPath }/order/confirm";
		const searchLink = "${ pageContext.servletContext.contextPath }/order/confirm";
			
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