<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <title>고객 관리</title>
  
  <link href="/SEMI_Project/resources/css/admin/bootstrap.min.css" rel="stylesheet">
  <link href="/SEMI_Project/resources/css/admin/main.css" rel="stylesheet">
 
</head>  
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
                주문 확인  
              </li>
            </ul>
            
            
          </div>
        </nav>
        
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4 main-scroll">
          
          <div class="row">
            <span class="col-2 menu-item menu-item-selected  ">
              <img src="/SEMI_Project/resources/image/admin/item1.svg" />
              &nbsp;&nbsp;&nbsp; 주문확인
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
              <a href="${pageContext.servletContext.contextPath}/admin/customer/board" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item4.svg" />
                &nbsp;&nbsp;&nbsp;  게시판</a>
            </span>
          </div>
          
          <br>
          <br>
          <br>
          
          <div class="row">
            <div class="col-10 offset-md-1">
              <div class="big-font">
                주문 상세내역
                
              </div>
              <hr class="start-line">
              <div class="row">
                
                <span class="recipe-item col-3 ">아메리카노</span>
                <span class="recipe-item col-6 ">4,500원</span>
                
                <span class="recipe-sub-item col-10 ">기본 : 단품 (4,000원)</span>
                <span class="recipe-sub-item col-10 ">음료 선택 : ICE (+500원)</span>
                
                <br>
                <br>
                <span class="recipe-item col-3 ">카페라떼</span>
                <span class="recipe-item col-6 ">5,000원</span>
                
                <span class="recipe-sub-item col-10 ">기본 : 단품 (4,500원)</span>
                <span class="recipe-sub-item col-10 ">음료 선택 : ICE (+500원)</span>
                
                <br>
                <br>
                <br>
                <br>
                
                <span class="recipe-item col-3 ">총 주문금액</span>
                <span class="recipe-item col-6 ">9,500원</span>
                <span class="recipe-item col-3 ">배달팁</span>
                <span class="recipe-item col-6 ">2,000원</span>
                <br>
                <br>
                <br>
                <span class="recipe-item col-3 ">총 결제금액</span>
                <span class="recipe-item col-6 ">11,000원</span>
                
                
              </div>
              
              
              
            </div>
          </div>
          
          <br>
          <br>
          <div class="row">
            <div class="col-10 offset-md-1">
              <div class="mid-font">
                고객 정보
                
              </div>
              <hr class="start-line">
              <div class="row">
                
                <span class="list-item col-2 recipe-item ">고객명</span>
                <span class="list-item col-9 recipe-item">고객1</span>
                <span class="list-item col-2 recipe-item ">연락처</span>
                <span class="list-item col-9 recipe-item ">010-1234-1234</span>
                <span class="list-item col-2 recipe-item ">받는 주소</span>
                <span class="list-item col-9 recipe-item ">서울특별시 무슨구 무슨동</span>
                <span class="list-item col-2 recipe-item ">요청사항</span>
                <span class="list-item col-9  recipe-item">요청사항 예시입니다.</span>
                <br>
                <br>
                <hr class="end-line">
                
                
                
              </div>
              
              
              
            </div>
            
            
          </div>
          
          
          <br>
          <br>
          <div class="row">
            <div class="col-10 offset-md-1">
              <div class="mid-font">
                업체 정보
                
              </div>
              <hr class="start-line">
              <div class="row">
                
                <span class="list-item col-2 recipe-item ">가게명</span>
                <span class="list-item col-9 recipe-item ">가게1</span>
                <span class="list-item col-2 recipe-item ">연락처</span>
                <span class="list-item col-9 recipe-item ">010-1234-1234</span> 
                <span class="list-item col-2 recipe-item ">가게 주소</span>
                <span class="list-item col-9 recipe-item ">서울특별시 무슨구 무슨동</span>
                <br>
                <br>
                <hr class="end-line">
                
                
                
                
              </div>
              
              
              
            </div>
            
            
          </div>
          <br>
          <br>
          <div class="row">
            <span class="col-10"></span>
            <span class="col-2"><a href="${pageContext.servletContext.contextPath}/admin/order"><img src="/SEMI_Project/resources/image/admin/backpage.png"/></a></span>
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