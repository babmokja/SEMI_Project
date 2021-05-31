<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/User_Board_Read.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/main_board.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/bootstrap.min.css" type="text/css">
    <title>Document</title>
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <aside class="aside">
        <div class="aside_top2">BABMOKJA </div>
        <div class="aside_top">건의 상세보기 </div>
    </aside>
  
    <section id="section">

       
          
        <!-- 버튼 -->

        <div class="wrap"  >
          <div class="gap">
            <div class="content">
              <div class="title">
                <h2>${ requestScope.boardRead.title }</h2>
              </div>
              <div class="small-title">
                <p>${ requestScope.username } <span>${ requestScope.boardRead.createdDate}</span></p>
              </div>
              <div class="under-line"></div>
              <p class="container">
              <textarea style="resize:none; width:90%; height:200px;" readonly>
              <c:out value="${ requestScope.boardRead.body }"/>
              </textarea>
              </p>
              <div class="coment-count">
                
              </div>
              <div class="under-line"></div>
              <div class="coment clearfix">
                <div class="name">관리자</div>
                <div class="text-wrap">${ requestScope.commentRead.reply }</div>
                <div class="date-wrap">${ requestScope.commentRead.replyDate }</div>
              </div>
              <div class="under-line line-gap"></div>
              <div class="under-line"></div>
              <form action="#" name="asd" method="get" class="clearfix">
               
              </form>
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