<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/Owner_SeggestionWrite_Board.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/main.css">
     <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/bootstrap.min.css">

    <title>건의글 상세 조회</title>
</head>
<body>
    <aside class="aside">
        <div class="aside_top2"><a href="${ pageContext.servletContext.contextPath }/main" 
        style="text-decoration: none;
   		color: black;
    	font-style: normal;
    	font-weight: bolder;}"> babmokja </a></div>
        <div class="aside_top" style="font-size:30px;">건의글 상세 조회 </div>
    </aside>
  
    <section id="section">

        <div class="row">
             <span class="col-2 menu-item menu-item-selected">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item1.png" />
                &nbsp;&nbsp;&nbsp;<a href="${ pageContext.servletContext.contextPath }/order/confirm">주문확인</a>
              </span>
              <span class="col-2 menu-item  ">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item2.png" />
                &nbsp;&nbsp;&nbsp; 내 정보관리
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
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board (업체용 게시판)/company/Owner_Comment_Board.html">리뷰관리</a>
                </span>
  
                <span class="col-2 menu-item">
                  <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item4.png" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/suggestion/list">1:1 문의하기</a>
                </span>
        </div>
     
        <div class="wrap">
          <div class="gap">
          
            <div class="content">
              <div class="title">
                <h2>${ requestScope.suggestionDetail.boardTitle }</h2>
              </div>
              <div class="small-title">
                <p>글쓴이 <span>| ${ requestScope.suggestionDetail.boardDate }</span></p>
              </div>
              <div class="under-line"></div>
              <p class="container">${ requestScope.suggestionDetail.boardContent }</p>
             <!--  <div class="coment-count">
                <p>댓글 1개</p>
              </div> -->
              <div class="under-line"></div>
              <div class="coment clearfix">
                <div class="name">관리자</div>
                <c:if test="${ empty requestScope.replyDetail}">
                <div class="text-wrap">관리자 댓글이 없습니다. 기다려주시면 감사드립니다.</div>
                <div class="date-wrap"></div>
                          
                </c:if>
                <c:if test="${! empty requestScope.replyDetail.boardCode}">
                <div class="text-wrap">${ requestScope.replyDetail.replyContent }</div>
                <div class="date-wrap">${ requestScope.replyDetail.replyDate }</div>
                </c:if>
                
              </div>
              <div class="under-line line-gap"></div>
              <div class="under-line"></div>

            </div>
          </div>
        </div>


      </section>


    <footer>
        <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
</body>
</html>