<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문확인</title>
<%-- <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/order.css">
        <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/main.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/bootstrap.min.css"> --%>
        <!-- <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/admin_Sales_day_Board.css"> -->
  <link href="/SEMI_Project/resources/css/admin/bootstrap.min.css" rel="stylesheet">
  <link href="/SEMI_Project/resources/css/admin/main.css" rel="stylesheet">
</head>

<%-- <aside class="aside" style="float:left;">
       <div class="aside_top2"><a href="${ pageContext.servletContext.contextPath }/main" 
        style="text-decoration: none;
   		color: black;
    	font-style: normal;
    	font-weight: bolder;}"> babmokja </a></div>
        <div class="aside_top">주문확인</div>
       
    </aside> --%>
    
    
    
<body>

<div class="container-fluid root">
      <div class="row main">
        <nav class="col-md-2 d-none d-md-block bg-yellow sidebar sidebar-bapmakja">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item logo">
                
                <a href="${pageContext.servletContext.contextPath}/main" class="link-dark">babmokja</a>
              </li>
              <li class="nav-item title">
                주문 내역  
              </li>
            </ul>
            
            
          </div>
        </nav>
        
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          
         <div class="row">
            <span class="col-2 menu-item menu-item-selected">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item1.png" />
                &nbsp;&nbsp;&nbsp;<a href="${ pageContext.servletContext.contextPath }/order/confirm">주문확인</a>
              </span>
              <span class="col-2 menu-item  ">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item2.png" />
                &nbsp;&nbsp;&nbsp;<a href="${ pageContext.servletContext.contextPath }/owner/modify">내 정보관리</a>
              </span>
              <span class="col-2 menu-item">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item3.png" />
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/menu/all">내 업소 관리</a>
              </span>
              <span class="col-2 menu-item">
                <img class="img-fluid" style ="width:40px; height:40px;"src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_board/computer.png" />
                &nbsp;&nbsp;&nbsp;<a class="text-dark" href="${ pageContext.servletContext.contextPath }/owner/delivery">PC주문현황</a>
              </span>
  
              <span class="col-2 menu-item">
                  <span class="imagesize"><img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item4.png" /></span>
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/owner/replycomment">리뷰관리</a>
                  </span>
  
                <span class="col-2 menu-item">
                  <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item4.png" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/suggestion/list">1:1 문의하기</a>
                </span>
        </div>
          
          <br>
          <br>
          <br>
          <br>
          <br>
          
          <div class="row">
            <div class="table-responsive col-10 offset-md-1">
              
              
              
              <br>
              <table class="table table-striped table-sm  text-center">
                <thead>
                  <tr>
                    <th>주문번호</th>
                    <th>고객아이디(고객명)</th>
                    <th>주문일자</th>
                    <th>주문상태</th>
                    <th>금액</th>
                   
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
              <br>
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
          </div>
        </main>
      </div>
      
      <div class="footer text-right align-middle" style="background-color:#EF9309;">
        <a class="text-dark footer-text text-decoration-none">Copyright &copy; BABMOKJA All Right Reserved.&nbsp;</a>
      </div>
      
    </div>
<%--         <aside class="aside">
<div class="logo"><a href="${pageContext.servletContext.contextPath}/link/admin/login" class="link-dark text-decoration-none">babmokja</a></div>        
<div class="aside_top">일별 매출 관리 </div>
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
                        <th class="section_contest section_contest_1">고객아이디(고객명)</th>
                        <th class="section_contest section_contest_1">주문일자</th>
                        <th class="section_contest section_contest_1">주문상태</th>
                        <th class="section_contest section_contest_1">금액</th>
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
       <table class="text-center table-striped table-sm table">
                <thead>
                  <tr>
                    <th >주문번호</th>
                    <th >고객명</th>
                    <th >주문일자</th>
                    <th >주문상태</th>
                    <th >금액</th>
                   
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
     --%>
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