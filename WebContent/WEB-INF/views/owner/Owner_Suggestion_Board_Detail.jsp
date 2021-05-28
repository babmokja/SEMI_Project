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
        <div class="aside_top">건의글 상세 조회 </div>
    </aside>
  
    <section id="section">

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
                
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/menu/all">내 업소 관리</a>
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
     
        <div class="wrap">
          <div class="gap">
            <div class="content">
              <div class="title">
                <h2>${ suggestionDetail.boardTitle }</h2>
              </div>
              <div class="small-title">
                <p>글쓴이 <span>| ${ suggestionDetail.boardDate }</span></p>
              </div>
              <div class="under-line"></div>
              <p class="container">${ suggestionDetail.boardContent }</p>
              <div class="coment-count">
                <p>댓글 1개</p>
              </div>
              <div class="under-line"></div>
              <div class="coment clearfix">
                <div class="name">관리자</div>
                <div class="text-wrap">${ suggestionDetail.replyContent }</div>
                <div class="date-wrap">${ suggestionDetail.replyDate }</div>
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