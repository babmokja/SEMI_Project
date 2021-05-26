<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/User_Board_Write.css" type="text/css">
        <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/main_board.css" type="text/css">
        <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/bootstrap.min.css" type="text/css">
        <title>Document</title>
        <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
        
        <aside class="aside">
                <div class="aside_top2">BABMOKJA </div>
                <div class="aside_top">건의 글쓰기 </div>
        </aside>
        
        <section id="section">

                
        </section>
        <div class="wrapper">
        <form action="${ pageContext.servletContext.contextPath }/user/board/write" method="post">

                        <div class="content" style="margin-top:100px">
                                <div class="as">제목 :</div>
                                <div class="ass"><input class="text1" type="text" size="30"name="title"></div>

                        </div >

                       
                        <div class="content2">

                                <div class="content2-1 as">	내용 : </div>

                                <div class="content2-1 ass">
                                <textarea cols="90" rows="12"name="body"></textarea>
                                </div>

                        </div>

                <div class="button2"><button type="submit">글작성</button></div>

        </form>
        </div>



        <footer>
                <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
        </footer>
</body>
</html>