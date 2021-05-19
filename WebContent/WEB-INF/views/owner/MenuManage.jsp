<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Menu Manage</title>
  
  <link href="${ pageContext.servletContext.contextPath }/resources/css/owner/bootstrap.min.css" rel="stylesheet">
  <link href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store_css/main.css" rel="stylesheet">
  
  <style>

    td {
      position: relative;
    }
  </style>
  
  <body>
    
    <div class="container-fluid root">
      <div class="row main">
        <nav class="col-md-2 d-none d-md-block bg-yellow sidebar sidebar-bapmakja">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item logo"><a href="../../front_semi_store/views/main_store.html">
                bakmokja</a>
              </li>
              <li class="nav-item title">
                	메뉴 관리  
              </li>
            </ul>
            
            
          </div>
        </nav>
        
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          
          <div class="row">
            <span class="col-2 menu-item menu-item-selected">
                <img src="resources/image/owner/item1.svg" />
                &nbsp;&nbsp;&nbsp;주문확인
              </span>
              <span class="col-2 menu-item  ">
                <img src="resources/image/owner/item2.png" />
                &nbsp;&nbsp;&nbsp; 내 정보관리
              </span>
              <span class="col-2 menu-item">
                <img src="resources/image/owner/item3.png" />
                
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board_sales/company/Owner_Sales_day_Board.html">내 업소 관리</a>
              </span>
              <span class="col-2 menu-item">
                <img class="img-fluid" src="resources/image/owner/PC주문관리.png" width="40px" height="40px" />
                &nbsp;&nbsp;&nbsp;<a class="text-dark" href="${ pageContext.servletContext.contextPath }/owner/delivery">pc주문현황</a>
              </span>
  
              <span class="col-2 menu-item">
                  <span class="imagesize"><img src="resources/image/owner/item4.svg" /></span>
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board/company/Owner_Comment_Board.html">리뷰관리</a>
                </span>
  
                <span class="col-2 menu-item">
                  <img src="resources/image/owner//item4.svg" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board/company/Owner_Seggestion_Board.html">1:1 문의하기</a>
                </span>
        </div>
          
          <br>
          <br>
          <br>
          
          <div class="row">
            <div class="table-responsive col-10 offset-md-1">
              
             
              <br>
              <table class="table  table-sm  text-center">
                <thead>
                  <tr>
                    <th>메뉴</th>
                    <th>메뉴가격</th>
                    <th>상태</th>
                    <th>메뉴설명</th>
                    <th>사진</th>
                    <th>메뉴 삭제</th>

                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${ requestScope.menuList }" var="menu">
                  <tr>
                    <td><input class="form-control" type="text" value=<c:out value="${menu.menuName}"/>></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;" value=<c:out value="${menu.price}"/>> 원</td>
                    <td><select class="form-select" >
                      <option >판매여부 선택</option>
                      <option value="Y" selected>판매중</option>
                      <option value="N" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" value= <c:out value ="${menu.menuExplain}" /> ></td>
                    <td><a href="#"><img src="resources/image/owner/pic.png" /></a></td>
                    <td><a href="#"><img src="resources/image/owner/delete.png" /></a></td>
                  </tr>
                </c:forEach>
                
                
                <form action="${pageContext.servletContext.contextPath}/menu/insert" method="post">
	                  <tr>
	                    <td><input class="form-control" type="text"  value="갈비천왕(순살)"></td>
	                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;" value="18000"> 원</td>
	                    <td><select class="form-select" >
	                      <option >판매여부 선택</option>
	                      <option value="1">판매중</option>
	                      <option value="2" selected>품절</option>
	                    </select></td>
	                    <td><input class="form-control" type="text" value="달콤한 갈비양념이 제대로!치킨의 새로운 지존"></td>
	                    <!-- <td><input type=><a href="#"><img src="../images/pic.png" /></a></td> -->
	                    <td><a href="#"><img src="../images/delete.png" /></a></td>
	                  </tr>
                  </form>
                      
                  
                </tbody>
              </table>
              

              
            </div>
          </div>
          <div class="row">
            <span class="col-10"></span>
            
            <span class="col-1"><a href="#"><img src="resources/image/owner/config.png" /></a></span>
            <span class="col-1"><a href="#"><img src="resources/image/owner/backpage.png" /></a></span>
          </div>
        </main>
        
      </div>
      
      <div class="footer text-right align-middle" style="background-color:#EF9309;">
        <a class="text-dark footer-text text-decoration-none">Copyright &copy; BABMOKJA All Right Reserved.&nbsp;</a>
      </div>
      
    </div>
    
    
  </body></html>