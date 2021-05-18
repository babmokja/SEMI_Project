<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <title>주문 내역</title>
  
  <link href="resources/css/admin/bootstrap.min.css" rel="stylesheet">
  <link href="resources/css/admin/main.css" rel="stylesheet">
  
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
                주문 내역  
              </li>
            </ul>
            
            
          </div>
        </nav>
        
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          
          <div class="row">
            <span class="col-2 menu-item menu-item-selected  ">
              <img src="resources/image/admin/item1.svg" />
              &nbsp;&nbsp;&nbsp; 주문확인
            </span>
            <span class="col-2 menu-item  ">
              <a href="./index-user.html" class="link-dark"><img src="resources/image/admin/item2.png" />
                &nbsp;&nbsp;&nbsp; 고객관리</a>
            </span>
            <span class="col-2 menu-item">
              <a href="./index-owner.html" class="link-dark"><img src="resources/image/admin/item3.png" />
              
                &nbsp;&nbsp;&nbsp; 업소관리</a> 
            </span>
            <span class="col-2 menu-item">
              <a href="../admin/admin_Customer_Secret_Board.html" class="link-dark"><img src="resources/image/admin/item4.svg" />
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
                  주문번호,고객명,가게명
                  <select class="form-select" >
                    <option selected>카테고리 선택</option>
                    <option value="1">주문번호</option>
                    <option value="2">고객명</option>
                    <option value="3">가게명</option>
                  </select>
                </div>
                <div class="col-3">
                  주문번호,고객명,가게명 입력
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
                    <th>주문번호</th>
                    <th>고객명</th>
                    <th>가게명</th>
                    <th>주문일시</th>
                    <th>가격</th>
                    <th>전화번호(업체)</th>
                    <th>전화번호(고객)</th>
                    <th>상세보기</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>OR001</td>
                    <td>고객명</td>
                    <td>가게명</td>
                    <td>2021.04.21 11:11:11</td>
                    <td>$1000</td>
                    <td>070-1234-1234</td>
                    <td>070-1234-1234</td>
                    <td><a href="./index-order2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  	<c:forEach var="board" items="${ requestScope.boardList }">
					<tr>
						<td><c:out value="${ board.no }"/></td>
						<td><c:out value="${ board.category.name }"/></td>
						<td><c:out value="${ board.title }"/></td>
						<td><c:out value="${ board.writer.nickname }"/></td>
						<td><c:out value="${ board.count }"/></td>
						<td><c:out value="${ board.createdDate }"/></td>
					</tr>
					</c:forEach>
                </tbody>
              </table>
              <br>
              <div class="text-center">
                
                <span class="col-1"><a href="#" class="page-item link-dark" >1</a></span>
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