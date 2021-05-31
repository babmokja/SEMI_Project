<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store_css/Owner_SeggestionWrite2_Board.css">
        <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/main.css">
        <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/Sresources/css/owner/semi_store/bootstrap.min.css">
        <title>건의 글쓰기</title>
</head>
<body>
        
        <aside class="aside">
                <div class="aside_top2"><a href="${ pageContext.servletContext.contextPath }/main" 
        style="text-decoration: none;
   		color: black;
    	font-style: normal;
    	font-weight: bolder;}"> babmokja </a></div>
                <div class="aside_top">건의 글쓰기 </div>
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
     
        </section>
        <div class="wrapper">
        <form action="${ pageContext.servletContext.contextPath }/suggestion/insert" method="post">

                        <div class="content">
                                <div class="as">글내용 : </div>
                                <div class="ass"><input name = "title" class="text1" type="text" size="30"></div>

                        </div >

                       
                        <div class="content2">

                                <div class="content2-1 as">건의내용 : </div>

                                <div class="content2-1 ass">
                                <textarea name="suggestion" cols="90" rows="12"></textarea>
                                </div>

                        </div>

		                <div class="button2">
		                <button type="submit" style=" width: 150px;
					    height: 40px;
					    font-size: 20px;
					    border-radius: 10px;
					    background-color: #FFCC00;
					    color: white;
					    font-weight: bold;
					    margin-right: 100px;">글 작 성 </button></div>
			</form>
		  </div>


        <footer>
                <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
        </footer>
</body>
</html>