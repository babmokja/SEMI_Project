<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store_css/Owner_Seggestion_Board.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/main2.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/bootstrap.min.css">
    <title>건의 게시판</title>

    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
    <aside class="aside">
        <div class="aside_top2"><a href="${ pageContext.servletContext.contextPath }/main" 
        style="text-decoration: none;
   		color: black;
    	font-style: normal;
    	font-weight: bolder;}"> babmokja </a></div>
        <div class="aside_top">건의 게시판 </div>
    </aside>
  
    <section class="section">

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
                <img class="img-fluid" src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_board/computer.png" />
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
     
        <div class="top-1">
        
        </div>
        <form action="${ pageContext.servletContext.contextPath }/suggestion/insert" method="GET">

            <table> 
                <thead>
                    <tr class="contest_top">
                    	
                        <th class="section_contest section_contest_1">번호</th>
                        <th class="section_contest section_contest_3">제목</th>
                        <th class="section_contest section_contest_5">작성일</th>
                    </tr>
                </thead>
                	<c:forEach items="${ requestScope.suggestionList }" var="sugList" >
                <tbody>
                    <tr>
                        <td class="section_contest_first section_contest_1" id="boardCode" name ="boardCode">${sugList.boardCode}</td>
                        <td class="section_contest_first section_contest_3" name ="boardTitle">${sugList.boardTitle}</a></td>
                        <td class="section_contest_first section_contest_5" name = "boardDate">${sugList.boardDate}</td>
                        
                    </tr>      
                </tbody>
                    </c:forEach>              
            </table>
           <%--  <div class="center clearfix">
                <div class="button button_space">1</div>
                <div class="button button_space">2</div>
                <div class="button button_space">3</div>
                <div class="button button_space">4</div>
                <div class="button">5</div>
                <div class="button3"><a href="${ pageContext.servletContext.contextPath }/suggestion/insert"><button type="button">글작성</button></a></div>
            </div> --%>

            </form>
            
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
			        <div class="button3"><a href="${ pageContext.servletContext.contextPath }/suggestion/insert"><button type="button">글작성</button></a></div>
			
		</div>
            

    </section>

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
					 var boardCode = this.parentNode.children[0].innerText;
	    			
					location.href = "${ pageContext.servletContext.contextPath }/suggestion/detail?boardCode="+ boardCode;
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
    
        <!-- <script>
    	$("#boardCode").change(function(){
    		var boardCode = $("#boardCode").val();
    			
    		location.href="${ pageContext.servletContext.contextPath }/suggestion/detail?boardNum="+ boardCode;
    		
    	});
    	
    </script> -->
</body>
</html>