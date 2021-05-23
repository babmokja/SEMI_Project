<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/admin_Customer_Secret_Board.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/main1.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/bootstrap.min.css">
    <title>Document</title>

    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
    <aside class="aside">
        <div class="aside_top2">BABMOKJA </div>
        <div class="aside_top">고객 게시판 </div>
        <div class="button01">고객</div>
        <div class="button02"><a href="${pageContext.servletContext.contextPath}/admin/owner/board">업주</a></div>
    </aside>
  
    <section class="section">

        <div class="row">
            <span class="col-2 menu-item">
                <a href="${pageContext.servletContext.contextPath}/admin/order" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item1.svg" />
                  &nbsp;&nbsp;&nbsp;주문확인   </a>
              </span>
              <span class="col-2 menu-item">
                <a href="${pageContext.servletContext.contextPath}/admin/customer" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item2.png" />
                  &nbsp;&nbsp;&nbsp; 고객관리</a>
              </span>
              <span class="col-2 menu-item">
                <a href="${pageContext.servletContext.contextPath}/admin/owner" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item3.png" />
                
                  &nbsp;&nbsp;&nbsp; 업소관리</a> 
              </span>
            <span class="col-2 menu-item">
              <img src="/SEMI_Project/resources/image/admin/item4.svg" />
              &nbsp;&nbsp;&nbsp;  <a href="${pageContext.servletContext.contextPath}/admin/customer/board">게시판</a>
            </span>
        </div>

        <div class="section_top">
 
        <div class="top-1">
        <form id="loginForm" action="${ pageContext.servletContext.contextPath }/admin/owner/search" method="get">
        <c:choose>
				    <c:when test="${ !empty requestScope.searchValue }">
   					    <div class="col-3">
	                  제목,글쓴이
	                  <select class="form-select" id="searchCondition" name="searchCondition" >
	                    <option value="ownerNum" <c:if test="${requestScope.searchCondition eq 'boardTitle'}">selected</c:if>>제목</option>
		                <option value="bisiNum"<c:if test="${requestScope.searchCondition eq 'userName'}">selected</c:if>>글쓴이</option>
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
              
              <div class="top">
                <br>
                <button type="button" class="btn btn-outline-secondary">검색하기</button>
              </div>
        </div>
		</form>
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
				 <c:forEach var="customerBoard" items="${ requestScope.customerBoardList }">
                    <tr>
                        <td class="section_contest_first section_contest_1"><c:out value="${ customerBoard.boardCode }"/></td>
                        <td class="section_contest_first section_contest_2">건의</td>
                        
                        <td class="section_contest_first section_contest_3">
                        <a href="${pageContext.servletContext.contextPath}/admin/customer/comment"><c:out value="${ customerBoard.boardTitle }"/></a></td>
                        
                        <td class="section_contest_first section_contest_4"><c:out value="${ customerBoard.userName }"/></td>
                        <td class="section_contest_first section_contest_5"><c:out value="${ customerBoard.boardDate }"/></td>
                    </tr>
				</c:forEach>
                    
                </tbody>
            </table>

            <div class="center clearfix">
                <div class="button button_space">1</div>
                <div class="button button_space">2</div>
                <div class="button button_space">3</div>
                <div class="button button_space">4</div>
                <div class="button">5</div>
            </div>
            
        </div>
    </section>

    <footer>
        <address class="footer footer-text"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
    
</body>
</html>