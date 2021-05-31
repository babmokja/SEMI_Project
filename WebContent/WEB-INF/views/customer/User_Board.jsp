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
    
  
    <section class="section" >


            <table> 
                <thead>
                    <tr class="contest_top">
                    	
                        <th class="section_contest section_contest_1">번호</th>
                        <th class="section_contest section_contest_3"style="width: 402px;">제목</th>
                        <th class="section_contest section_contest_5">작성일</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${ requestScope.boardList }" var="board" varStatus="status"  > 
                	
                    <tr>
                        <td class="section_contest_first section_contest_1">${ board.no}</td>
                        <td class="section_contest_first section_contest_3"><a href="${ pageContext.servletContext.contextPath }/board/read?no=${ board.no }">${ board.title }</a></td>
				        <td class="section_contest_first section_contest_5">${ board.createdDate }</td>
                        
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
	
		<div ><a href="${ pageContext.servletContext.contextPath }/user/board/write"><button >글작성</button></a></div>		       
         </div>
 
         
         		
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
				

				
			}
			
		}
	
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text;
		}

	</script>           
           

        
    
    <footer>
        <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
</body>
</html>