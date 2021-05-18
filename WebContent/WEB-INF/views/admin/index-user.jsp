<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
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
                고객 관리   
              </li>
            </ul>
            
            
          </div>
        </nav>
        
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          
          <div class="row">
            <span class="col-2 menu-item">
              <a href="${pageContext.servletContext.contextPath}/admin/order" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item1.svg" />
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
              <a href="${pageContext.servletContext.contextPath}/admin/customer/board" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item4.svg" />
                &nbsp;&nbsp;&nbsp;  게시판</a>
            </span>
          </div>
          
          <br>
          <br>
          <br>
          
          <div class="row">
            <div class="table-responsive col-10 offset-md-1">
              
              <div class="row">
                <div class="col-3">
                  유저명,유저아이디,유저번호
                    <select class="form-select" >
                    <option selected>카테고리 선택</option>
                    <option value="1">유저명</option>
                    <option value="2">유저아이디</option>
                    <option value="3">유저번호</option>
                  </select>
                </div>
                <div class="col-3">
                  유저명,유저아이디,유저번호 입력
                  <input class="form-control" type="text" >
                  
                </div>
                
                <div class="col-3">
                  <br>
                  <button type="button" class="btn btn-outline-secondary">검색하기</button>
                </div>
              </div>
              <br>
              <table class="table table-striped table-sm  text-center">
                <thead>
                  <tr>
                    <th>유저번호</th>
                    <th>블랙리스트 여부</th>
                    <th>유저명</th>
                    <th>유저아이디</th>
                    <th>가입일</th>
                    <th>주소</th>
                    <th>상세보기</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="${pageContext.servletContext.contextPath}/admin/customer/detail" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>US001</td>
                    <td>N</td>
                    <td>홍길동</td>
                    <td>user1234</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>서울시 어디구 어디동</td>
                    <td><a href="#" class="link-dark">상세보기</a></td>
                  </tr>
                </tbody>
              </table>
              <br>
              <div class="text-center">
                
                <span class="col-1 "><a href="#" class="page-item link-dark" >1</a></span>
                <span class="col-1"><a href="#" class="page-item link-dark" >2</a></span>
                <span class="col-1"><a href="#" class="page-item link-dark" >3</a></span>
                <span class="col-1"><a href="#" class="page-item link-dark" >4</a></span>
                <span class="col-1"><a href="#" class="page-item link-dark" >5</a></span>
                
              </div>
              
            </div>
          </div>
        </main>
      </div>
      
      <div class="footer text-right align-middle" style="background-color:#EF9309;">
        <a class="text-dark footer-text text-decoration-none">Copyright &copy; BABMOKJA All Right Reserved.&nbsp;</a>
      </div>
      
    </div>
    
    
  </body></html>