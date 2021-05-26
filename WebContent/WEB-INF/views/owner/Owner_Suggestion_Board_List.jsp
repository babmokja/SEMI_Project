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
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item1.svg" />
                &nbsp;&nbsp;&nbsp;<a href="${ pageContext.servletContext.contextPath }/order/confirm">주문확인</a>
              </span>
              <span class="col-2 menu-item  ">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item2.png" />
                &nbsp;&nbsp;&nbsp; 내 정보관리
              </span>
              <span class="col-2 menu-item">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item3.png" />
                
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${pageContext.servletContext.contextPath}/menu/new">내 업소 관리</a>
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
                <tbody>
                	<c:forEach items="${ requestScope.suggestionList }" var="sugList" >
                    <tr>
                        <td class="section_contest_first section_contest_1" id="boardCode" name ="boardCode">${sugList.boardCode}</td>
                        <td class="section_contest_first section_contest_3" name ="boardTitle"><a href="${ pageContext.servletContext.contextPath }/suggestion/detail">${sugList.boardTitle}</a></td>
                        <td class="section_contest_first section_contest_5" name = "boardDate">${sugList.boardDate}</td>
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
                <div class="button3"><a href="${ pageContext.servletContext.contextPath }/suggestion/insert"><button type="button">글작성</button></a></div>
            </div>

            </form>
            

    </section>

    <footer>
        <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
    
        <script>
    	$("#boardCode").change(function(){
    		var boardCode = $("#boardCode").val();
    			
    		location.href="${ pageContext.servletContext.contextPath }/owner/sales/day?boardNum="+ boardCode;
    		
    	});
    	
    </script>
</body>
</html>