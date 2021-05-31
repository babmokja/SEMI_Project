<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/admin_Sales_day_Board.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/main1.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/bootstrap.min.css">
    <title>Document</title>

</head>
<body>
    <aside class="aside">
<div class="logo"><a href="${pageContext.servletContext.contextPath}/link/admin/login" class="link-dark text-decoration-none">babmokja</a></div>        
<div class="aside_top">일별 매출 관리 </div>
    </aside>

    <section class="section">

        <div class="row">
            <span class="col-2 menu-item">
                <a href="${pageContext.servletContext.contextPath}/admin/order" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item1.png" />
                  &nbsp;&nbsp;&nbsp;주문확인   </a>
              </span>
              <span class="col-2 menu-item ">
              <a href="${pageContext.servletContext.contextPath}/admin/customer" class="link-dark">  <img src="/SEMI_Project/resources/image/admin/item2.png" />
                &nbsp;&nbsp;&nbsp; 고객관리</a>
              </span>
              <span class="col-2 menu-item menu-item-selected  ">
                <img src="/SEMI_Project/resources/image/admin/item3.png" />
                &nbsp;&nbsp;&nbsp; 업소관리
              </span>
              <span class="col-2 menu-item">
                <a href="${pageContext.servletContext.contextPath}/admin/customer/board" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item4.png" />
                  &nbsp;&nbsp;&nbsp;  게시판</a>
              </span>
        </div>

        <div class="section_top">
            
       
        <div class="button01">오늘</div>
        <div class="button02"><a href="${pageContext.servletContext.contextPath}/admin/sales/month?&ownerNum=${ requestScope.ownerNum }">월별</a></div>

       
        <div class="space"></div>

		<c:set var="intArray" value="0" />
            <table> 
                <thead>
                    <tr>
                        <th class="section_contest section_contest_1">주문번호</th>
                        <th class="section_contest section_contest_2">주문시간</th>
                        <th class="section_contest section_contest_3">서비스 유형</th>
                        <th class="section_contest section_contest_4">결제금액</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="sales" items="${ requestScope.salesList }">
                    <tr>
                        <td class="section_contest_first section_contest_1"><c:out value="${ sales.orderNum }"/></td>
                        <td class="section_contest_first section_contest_2"><c:out value="${ sales.orderDate }"/></td>
                        <td class="section_contest_first section_contest_3"><c:out value="${ sales.type }"/></td>
                        <td class="section_contest_first section_contest_4"><c:out value="${ sales.price }"/>원</td>
                        <c:set var="intArray" value="${intArray+sales.price}" />
                    </tr>
                    </c:forEach>

                    
                    
                </tbody>
            </table>

            <div class="text-center">
           
                	
                <c:choose>
			    <c:when test="${ empty requestScope.searchValue }">
				    <button class="btn btn-warning" id="startPage"><<</button>
	
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
				<span class="total">오늘 총 <c:out value="${ requestScope.totalPrice }원"/> 판매 하셨습니다.</span>
					
			     </c:when>
			</c:choose>   
              </div>
            
        </div>
    </section>

    <footer>
        <address class="footer footer-text"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
    
            <script>
		const link = "${ pageContext.servletContext.contextPath }/admin/sales/today";
		const searchLink = "${ pageContext.servletContext.contextPath }/admin/sales/today";
		const detail = "${ pageContext.servletContext.contextPath }/admin/owner/detail";
			
		if(document.getElementById("startPage")) {
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function() {
				location.href = link + "?currentPage=1&ownerNum=${ requestScope.ownerNum }";
			}
		}
		
		if(document.getElementById("prevPage")) {
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo - 1 }&ownerNum=${ requestScope.ownerNum }";
			}
		}
		

		
		if(document.getElementById("nextPage")) {
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo + 1 }&ownerNum=${ requestScope.ownerNum }";
			}
		}
		
		if(document.getElementById("maxPage")) {
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.maxPage }&ownerNum=${ requestScope.ownerNum }";
			}
		}
		
		if(document.getElementById("searchStartPage")) {
			const $searchStartPage = document.getElementById("searchStartPage");
			$searchStartPage.onclick = function() {
				location.href = searchLink + "?currentPage=1&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}&ownerNum=${ requestScope.ownerNum }";
			}
		}
		
		if(document.getElementById("searchPrevPage")) {
			const $searchPrevPage = document.getElementById("searchPrevPage");
			$searchPrevPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.pageNo - 1 }&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}&ownerNum=${ requestScope.ownerNum }";
			}
		}
		
		if(document.getElementById("searchNextPage")) {
			const $searchNextPage = document.getElementById("searchNextPage");
			$searchNextPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.pageNo + 1 }&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}&ownerNum=${ requestScope.ownerNum }";
			}
		}
		
		if(document.getElementById("searchMaxPage")) {
			const $searchMaxPage = document.getElementById("searchMaxPage");
			$searchMaxPage.onclick = function() {
				location.href = searchLink + "?currentPage=${ requestScope.pageInfo.maxPage }&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}&ownerNum=${ requestScope.ownerNum }";
			}
		}
		
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text+"&ownerNum=${ requestScope.ownerNum }";
		}
		function seachPageButtonAction(text) {
			location.href = searchLink + "?currentPage=" + text + "&searchCondition=${ requestScope.searchCondition}&searchValue=${ requestScope.searchValue}&ownerNum=${ requestScope.ownerNum }";
		}
	</script>
</body>
</html>