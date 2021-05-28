<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/admin_Owner_SecretWrite_Board.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/main1.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Document</title>
</head>
<body>
    <aside class="aside">
<div class=" logo"><a href="${pageContext.servletContext.contextPath}/link/admin/login" class="link-dark text-decoration-none">babmokja</a> </div>        <div class="aside_top">업주 비밀건의 게시글 </div>
    </aside>
  
    <section id="section">

        <div class="row">
          <span class="col-2 menu-item">
            <a href="${pageContext.servletContext.contextPath}/admin/order" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item1.png" />
              &nbsp;&nbsp;&nbsp;주문확인   </a>
          </span>
          <span class="col-2 menu-item  ">
            <a href="${pageContext.servletContext.contextPath}/admin/customer" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item2.png" />
              &nbsp;&nbsp;&nbsp; 고객관리</a>
          </span>
          <span class="col-2 menu-item">
            <a href="${pageContext.servletContext.contextPath}/admin/owner" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item3.png" />
            
              &nbsp;&nbsp;&nbsp; 업소관리</a> 
          </span>
            <span class="col-2 menu-item">
              <img src="/SEMI_Project/resources/image/admin/item4.png" />
              &nbsp;&nbsp;&nbsp;  <a href="${pageContext.servletContext.contextPath}/admin/customer/board">게시판</a>
            </span>
          </div>

        <div class="wrap">
          <div class="gap">
            <div class="content">
              <div class="title">
                <h2>${ requestScope.ownerComment.boardTitle }</h2>
              </div>

              <div class="small-title">
                <p>${ requestScope.ownerComment.userName }<span>| ${ requestScope.ownerComment.boardDate }</span></p>
              </div>

              <div class="under-line"></div>

              <p class="container">${ requestScope.ownerComment.boardContent }</p>

              <div class="coment-count"><p></p></div>

              <div class="under-line"></div>

              <div id="commentArea" class="coment clearfix">
				<c:forEach var="reply" items="${ requestScope.replyList }">
	                <div class="name">${ reply.userName }</div>
	                <div class="text-wrap">${ reply.replyContent }</div>
	                <div class="date-wrap">${ reply.replyDate }</div>
				</c:forEach>
              </div>

              <div class="under-line line-gap"></div>

              <div class="under-line"></div>
				<form action="${pageContext.servletContext.contextPath}/admin/owner/insertReply" method="post">
                <div class="name">관리자</div>
                <textarea id="content" name="content" cols="30" rows="10"></textarea>
                <input type="hidden" name="boardCode" value="${ requestScope.ownerComment.boardCode }">
                <div id="reply" class="comment_button"><button type="submit">댓글 작성</button></div>
                <div class="menu_button"><button type="button"><a href="${pageContext.servletContext.contextPath}/admin/owner/board">목록으로<br> 돌아가기</a></button></div>
				</form>
              <div class="under-line"></div>

            </div>
          </div>
        </div>

      </section>

    <footer>
        <address class="footer footer-text"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
</body>
</html>