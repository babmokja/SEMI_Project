<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <title>고객 관리</title>
  
  <link href="/SEMI_Project/resources/css/admin/bootstrap.min.css" rel="stylesheet">
  <link href="/SEMI_Project/resources/css/admin/main.css" rel="stylesheet">
 
  
  <body>
    
    <div class="container-fluid root">
      <div class="row main">
        <nav class="col-md-2 d-none d-md-block bg-yellow sidebar sidebar-bapmakja">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item logo">
                bakmokja
              </li>
              <li class="nav-item title">
                고객 관리  
              </li>
            </ul>
            
            
          </div>
        </nav>
        
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4 main-scroll">
          
          <div class="row">
            <span class="col-2 menu-item">
              <a href="${pageContext.servletContext.contextPath}/admin/order" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item1.png" />
                &nbsp;&nbsp;&nbsp;주문확인   </a>
            </span>
            <span class="col-2 menu-item menu-item-selected ">
              <img src="/SEMI_Project/resources/image/admin/item2.png" />
              &nbsp;&nbsp;&nbsp; 고객관리
            </span>
            <span class="col-2 menu-item">
              <a href="${pageContext.servletContext.contextPath}/admin/owner" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item3.png" />
              
                &nbsp;&nbsp;&nbsp; 업소관리</a> 
            </span>
            <span class="col-2 menu-item">
              <a href="${pageContext.servletContext.contextPath}/admin/customer/board" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item4.png" />
                &nbsp;&nbsp;&nbsp;  게시판</a>
            </span>
          </div>
          
          <br>
          <br>
          <br>
          
          <div class="row">
            <div class="col-8 offset-md-2">
              <div class="big-font">
                고객 상세정보
                
              </div>
              <hr class="start-line">
              <div class="row">
                
                <span class="recipe-item col-3 ">유저번호</span>
                <span class="recipe-item col-6 ">US001</span>
                <br><br>
                <span class="recipe-item col-3 ">사용자 이름</span>
                <span class="recipe-item col-6 ">홍길동</span>
                <br><br>

                <span class="recipe-item col-3 ">유저아이디</span>
                <span class="recipe-item col-6 ">user1234</span>
                <br><br>

                <span class="recipe-item col-3 ">주민번호</span>
                <span class="recipe-item col-6 ">111111-1******</span>
                <br><br>

                <span class="recipe-item col-3 ">사용자 주소</span>
                <span class="recipe-item col-6 ">서울특별시 어디구 어디동</span>
                <br><br>

                <span class="recipe-item col-3 ">카드번호</span>
                <span class="recipe-item col-6 ">1234-****-****-1234</span>
                <br><br>

                <span class="recipe-item col-3 ">CVC번호</span>
                <span class="recipe-item col-6 ">1**</span>
                <br><br>

                <span class="recipe-item col-3 ">가입일</span>
                <span class="recipe-item col-6 ">2021.04.21 11:11:11</span>
                <br><br>

                <span class="recipe-item col-3 ">블랙리스트 여부</span>
                <span class="recipe-item col-6 ">N</span>
  
              </div>

            </div>
          </div>

          <br>
          <br>
          
          <br>
          <br>
          <div class="row">
            <span class="col-8"></span>
            <span class="col-1"><a href="#"><img src="/SEMI_Project/resources/image/admin/config.png" /></a></span>
            <span class="col-1"><a href="${pageContext.servletContext.contextPath}/admin/customer"><img src="/SEMI_Project/resources/image/admin/backpage.png" /></a></span>
          </div>
          <br>
          <br><br>
          
        </main>
      </div>
        
      <div class="footer text-right align-middle" style="background-color:#EF9309;">
        <a class="text-dark footer-text text-decoration-none">Copyright &copy; BABMOKJA All Right Reserved.&nbsp;</a>
      </div>
      
    </div>
    
  </body></html>