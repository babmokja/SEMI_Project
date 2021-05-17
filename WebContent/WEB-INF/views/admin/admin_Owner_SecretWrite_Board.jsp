<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/css/admin/admin_Owner_SecretWrite_Board.css">
    <link rel="stylesheet" href="resources/css/admin/main1.css">
    <link rel="stylesheet" href="resources/css/admin/bootstrap.min.css">

    <title>Document</title>
</head>
<body>
    <aside class="aside">
        <div class="aside_top2">BABMOKJA </div>
        <div class="aside_top">업주 비밀건의 게시글 </div>
    </aside>
  
    <section id="section">

        <div class="row">
          <span class="col-2 menu-item">
            <a href="../관리자/index-order.html" class="link-dark"><img src="resources/image/admin/item1.svg" />
              &nbsp;&nbsp;&nbsp;주문확인   </a>
          </span>
          <span class="col-2 menu-item  ">
            <a href="../관리자/index-user.html" class="link-dark"><img src="resources/image/admin/item2.png" />
              &nbsp;&nbsp;&nbsp; 고객관리</a>
          </span>
          <span class="col-2 menu-item">
            <a href="../관리자/index-owner.html" class="link-dark"><img src="resources/image/admin/item3.png" />
            
              &nbsp;&nbsp;&nbsp; 업소관리</a> 
          </span>
            <span class="col-2 menu-item">
              <img src="resources/image/admin/item4.svg" />
              &nbsp;&nbsp;&nbsp;  <a href="admin_Customer_Secret_Board.html">게시판</a>
            </span>
          </div>

        <div class="wrap">
          <div class="gap">
            <div class="content">
              <div class="title">
                <h2>글제목 예시입니다.</h2>
              </div>

              <div class="small-title">
                <p>글쓴이 <span>| 2021.04.21 11:11:11</span></p>
              </div>

              <div class="under-line"></div>

              <p class="container">안녕하세요 ooo입니다. 이런이런 사연이 있었는데 건의를 할려고 글을 남깁니다.</p>

              <div class="coment-count"><p>댓글 1개</p></div>

              <div class="under-line"></div>

              <div class="coment clearfix">

                <div class="name">관리자</div>
                <div class="text-wrap">답변 댓글 예시입니다.</div>
                <div class="date-wrap">2021.04.21 11:11:11</div>
              </div>

              <div class="under-line line-gap"></div>

              <div class="under-line"></div>

              <form action="#" name="asd" method="get" class="clearfix">
                <div class="name">관리자</div>
                <textarea name="" id="" cols="30" rows="10"></textarea>
                <div class="comment_button"><button><a href="admin_Owner_Secret_Board.html">댓글 작성</a></button></div>
                <div class="menu_button"><button><a href="admin_Owner_Secret_Board.html">목록으로<br> 돌아가기</a></button></div>
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