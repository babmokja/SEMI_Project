<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                업소 관리   
              </li>
            </ul>
            
            <ul class="nav flex-column">
              <hr class="end-line">
              <li class="nav-item sublogo">
                업소 정보조회
                <hr class="end-line">
              </li>
              
              <li class="nav-item sublogo">
                 <a href="${pageContext.servletContext.contextPath}/admin/fee" >이용료 정산내역 조회</a>
                <hr class="end-line">
              </li>

              <li class="nav-item sublogo">
                <a href="${pageContext.servletContext.contextPath}/admin/add/company" >업소 가입/추가신청 조회</a>
               <hr class="end-line">
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
            <span class="col-2 menu-item ">
            <a href="${pageContext.servletContext.contextPath}/admin/customer" class="link-dark">  <img src="/SEMI_Project/resources/image/admin/item2.png" />
              &nbsp;&nbsp;&nbsp; 고객관리</a>
            </span>
            <span class="col-2 menu-item menu-item-selected  ">
              <img src="/SEMI_Project/resources/image/admin/item3.png" />
              &nbsp;&nbsp;&nbsp; 업소관리
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
                업주 상세정보
                
              </div>
              <hr class="start-line">
              <div class="row">
                <c:forEach var="owner" items="${ requestScope.ownerDetail  }">
                
                <span class="recipe-item col-3 ">사업자번호</span>
                <span class="recipe-item col-6 "><c:out value="${ owner.ownerNum }"/></span>
                <br><br>
                <span class="recipe-item col-3 ">음식점 이름</span>
                <span class="recipe-item col-6 "><c:out value="${ owner.stoName }"/></span>
                <br><br>

                <span class="recipe-item col-3 ">음식점번호</span>
                <span class="recipe-item col-6 "><c:out value="${ owner.stoNum }"/></span>
                <br><br>

                <span class="recipe-item col-3 ">업종카테고리</span>
                <span class="recipe-item col-6 "><c:out value="${ owner.category }"/></span>
                <br><br>

                <span class="recipe-item col-3 ">음식점주소</span>
                <span class="recipe-item col-6 "><c:out value="${ owner.stoAddr }"/></span>
                <br><br>

                <span class="recipe-item col-3 ">휴대전화</span>
                <span class="recipe-item col-6 "><c:out value="${ owner.phone }"/></span>
                <br><br>


                <span class="recipe-item col-3 ">서비스 유형</span>
                <span class="recipe-item col-6 "><c:out value="${ owner.type }"/></span>
                <br><br>

                <span class="recipe-item col-3 ">매출 확인</span>
                <span class="recipe-item col-6 sales-config"><a href="${pageContext.servletContext.contextPath}/admin/sales/today">매출 확인</a></span>

                </c:forEach>
              </div>

              
            </div>
          </div>
          
          <br>
          <br>

          <br>
          <br>
          <div class="row">
            <span class="col-8"></span>
            <span class="col-1"><a href="${pageContext.servletContext.contextPath}/admin/owner"><img src="/SEMI_Project/resources/image/admin/backpage.png" /></a></span>
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