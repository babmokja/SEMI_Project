<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/User_Board.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/main_board.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/bootstrap.min.css">
    
    <title>Document</title>
    <script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <aside class="aside"><div class="logo">
        <div class="aside_top2"><a href="${ pageContext.servletContext.contextPath }"class="link-dark text-decoration-none">babmokja</a> </div>
        <div class="aside_top">건의 게시판 </div>
    </aside>
    
  <form action="${ pageContext.servletContext.contextPath }/board/list" method="GET">
    <section class="section" >
<%-- <div>
            <table > 
                <thead>
                    <tr class="contest_top">  
                        <th class="section_contest section_contest_1"  >제목</th>
                        <th class="section_contest section_contest_2" >작성일</th>
                    </tr>
                </thead>

                 <tbody>
                    <c:forEach var="board" items="${ requestScope.boardList }">
                    <tr>
				        <td><c:out value="${ board.title }" style="width:50px"/></td>
				        <td><c:out value="${ board.createdDate }"/></td>
				    </tr>  
                    </c:forEach>

                   </tbody>
                </table>
         </section>
</div>
           --%>


            <table> 
                <thead>
                    <tr class="contest_top">
                    	
                        <th class="section_contest section_contest_1">번호</th>
                        <th class="section_contest section_contest_3"style="width: 402px;">제목</th>
                        <th class="section_contest section_contest_5">작성일</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${ requestScope.boardList }" var="board" >
                	
                    <tr>
                        <td class="section_contest_first section_contest_1"><c:out value="${ board.no }"/></td>
                        <td class="section_contest_first section_contest_3"><a href="${ pageContext.servletContext.contextPath }/board/read"><c:out value="${ board.title }"/></a></td>
				        <td class="section_contest_first section_contest_5"><c:out value="${ board.createdDate }"/></td>
                        
                    </tr>
                          
                    </c:forEach>              
                </tbody>
            </table>        		
		
		   
		
		<div align="center" style="margin:40px " >
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
			     </c:when>
			</c:choose>   
		</div>
		
		<div style="margin:10px 0 0 1500px ">
<%-- 		<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/board/write'">글작성</button> --%>
				       
         </div>
         </form>
         
         		
		<script>
		
		const link = "${ pageContext.servletContext.contextPath }/board/list";
			
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
		

		
		if(document.getElementsByTagName("td")) {
			
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.backgroundColor = "lightgray";
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onmouseout = function() {
					this.parentNode.style.backgroundColor = "white";
				}
				
				$tds[i].onclick = function() {
					
					alert(this.parentNode.children[0].innerText);
				}
				
			}
			
		}
	
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text;
		}

	</script>           
           

            
<%--                <div class="center clearfix">
                <div class="button button_space">1</div>
                <div class="button button_space">2</div>
                <div class="button button_space">3</div>
                <div class="button button_space">4</div>
                <div class="button">5</div>
                <div class="button3"><a href='${ pageContext.servletContext.contextPath }/board/list"><button>글작성</button></a></div>
            </div> --%>
            
   

   
    
    
                        
    
    <footer>
        <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
</body>
</html>