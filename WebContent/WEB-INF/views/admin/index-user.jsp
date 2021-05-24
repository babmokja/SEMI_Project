<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <title>고객 관리</title>
  
  <link href="/SEMI_Project/resources/css/admin/bootstrap.min.css" rel="stylesheet">
  <link href="/SEMI_Project/resources/css/admin/main.css" rel="stylesheet">
  
</head>
  
  <body>
    
    <div class="container-fluid root">
      <div class="row main">
        <nav class="col-md-2 d-none d-md-block bg-yellow sidebar sidebar-bapmakja">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item logo">
                bakmokja
              </li>
              <li class="nav-item title">
                고객 관리   
              </li>
            </ul>
            
            
          </div>
        </nav>
        
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          
          <div class="row">
            <span class="col-2 menu-item">
              <a href="${pageContext.servletContext.contextPath}/admin/order" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item1.png" />
                &nbsp;&nbsp;&nbsp;주문확인   </a>
            </span>
            <span class="col-2 menu-item menu-item-selected ">
              <img src="/SEMI_Project/resources/image/admin/item2.png" />
              &nbsp;&nbsp;&nbsp; 고객관리
            </span>
            <span class="col-2 menu-item">
              <a href="${pageContext.servletContext.contextPath}/admin/owner" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item3.png" />
              
                &nbsp;&nbsp;&nbsp; 업소관리</a> 
            </span>
            <span class="col-2 menu-item">
              <a href="${pageContext.servletContext.contextPath}/admin/customer/board" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item4.png" />
                &nbsp;&nbsp;&nbsp;  게시판</a>
            </span>
          </div>
          
          <br>
          <br>
          <br>
          
          <div class="row">
            <div class="table-responsive col-10 offset-md-1">
              
              <form id="loginForm" action="${ pageContext.servletContext.contextPath }/admin/user/search" method="get">
              <div class="row">
                <c:choose>
				    <c:when test="${ !empty requestScope.searchValue }">
   					    <div class="col-3">
	                  유저번호,유저아이디,유저명
	                  <select class="form-select" id="searchCondition" name="searchCondition" >
	                    <option value="userNum" <c:if test="${requestScope.searchCondition eq 'userNum'}">selected</c:if>>유저번호</option>
		                <option value="userId"<c:if test="${requestScope.searchCondition eq 'userId'}">selected</c:if>>유저아이디</option>
		                <option value="userName"<c:if test="${requestScope.searchCondition eq 'userName'}">selected</c:if>>유저명</option>
	                  </select>
	                </div>
	                <div class="col-3">
	                  유저번호,유저아이디,유저명 입력
	                  <input class="form-control" type="search" id="searchValue" name="searchValue" value="${ requestScope.searchValue }" >
	                </div>
				    </c:when>
				    <c:otherwise>
						    <div class="col-3">
		                  유저번호,유저아이디,유저명
		                  <select class="form-select" id="searchCondition" name="searchCondition" >
		                    <option value="userNum">유저번호</option>
		                    <option value="userId">유저아이디</option>
		                    <option value="userName">유저명</option>
		                  </select>
		                </div>
		                <div class="col-3">
		                  유저번호,유저아이디,유저명
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
              <br>
              <table class="table table-striped table-sm  text-center">
                <thead>
                  <tr>
                    <th>유저번호</th>
                    <th>블랙리스트 여부</th>
                    <th>유저명</th>
                    <th>유저아이디</th>
                    <th>주소</th>
                    <th>상세보기</th>
                  </tr>
                </thead>
                <tbody>
                  
                  <c:forEach var="user" items="${ requestScope.userList }">
					<c:choose>
			    	<c:when test="${ user.withDrawYN =='N' }">
					<tr>
						<td><c:out value="${ user.userNum }"/></td>
						<td><c:out value="${ user.blackList }"/></td>
						<td><c:out value="${ user.userName }"/></td>
						<td><c:out value="${ user.userId }"/></td>
						<td><c:out value="${ user.userAddr }"/></td>
						<td><a href="${pageContext.servletContext.contextPath}/admin/owner/detail?ownerNum=${ board.ownerNum }"  class="link-dark">상세보기</a></td>
					</tr>
					</c:when>
					</c:choose>
					</c:forEach>
                </tbody>
              </table>
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
          </div>
        </main>
      </div>
      
      <div class="footer text-right align-middle" style="background-color:#EF9309;">
        <a class="text-dark footer-text text-decoration-none">Copyright &copy; BABMOKJA All Right Reserved.&nbsp;</a>
      </div>
      
    </div>
    
    
  </body></html>