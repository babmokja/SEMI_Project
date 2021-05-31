<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owner/semi_board/Owner_Comment_Write_Board.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owner/semi_board/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owner/semi_board/bootstrap.min.css">

    <title>Document</title>
</head>
<body>
    <aside class="aside" style="width:340px;">
        <div class="aside_top2"><a href="${ pageContext.servletContext.contextPath }/main" 
        style="text-decoration: none;
         color: black;
       font-style: normal;
       font-weight: bolder;}"> babmokja </a> </div>
        <div class="aside_top" style="width:100%; font-size: 40px;">업체 댓글달기 </div>
    </aside>
  
    <section id="section">

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
        <!-- 버튼 -->

        <div class="wrap">
          <div class="gap">
            <div class="content">
              <div class="title">
                <h2>${ commentDetail.reviewContent }</h2>
              </div>
              <div class="small-title">
                <p>${ commentDetail.userId } <span>| ${ commentDetail.replyDate }</span></p>
              </div>
              <div class="under-line"></div>
              <p class="container">${ commentDetail.reviewContent }</p>
              <div class="coment-count">
                <p></p>
              </div>
              <div class="under-line"></div>
              <!-- <div class="coment clearfix">
                <div class="name">관리자</div>
                <div class="text-wrap">답변 댓글 예시입니다.</div>
                <div class="date-wrap">2021.04.21 11:11:11</div>
              </div>
              <div class="under-line line-gap"></div>
              <div class="under-line"></div>
              <form action="#" name="asd" method="get" class="clearfix">
                <div class="name">관리자</div>
                <textarea name="" id="" cols="30" rows="10"></textarea>
                <button><a href="Owner_Comment_Board.html">댓글작성</a></button>
              </form>
              <div class="under-line"></div> -->
			<button style="float:left; font-weight:bold; border:1px solid black; margin-top :10px;" class="btn" onclick="location.href='${ pageContext.servletContext.contextPath }/owner/replycomment'">뒤로 가기</button>
	            </div>
          </div>
        </div>


      </section>


    <footer>
        <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
</body>
</html>