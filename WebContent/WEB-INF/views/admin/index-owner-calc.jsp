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
  
<style>
  .table-striped tbody tr:last-child td
{
     border-radius:5px;
}
</style>
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
                업소 관리   
              </li>
            </ul>
            
            <ul class="nav flex-column">
              <hr class="end-line">
              <li class="nav-item sublogo">
                <a href="${pageContext.servletContext.contextPath}/admin/owner" >업소 정보조회</a>
                <hr class="end-line">
              </li>
              
              <li class="nav-item sublogo">
                이용료 정산내역 조회
                <hr class="end-line">
              </li>

              <li class="nav-item sublogo">
                <a href="${pageContext.servletContext.contextPath}/admin/add/company" >업소 가입/추가신청 조회</a>
               <hr class="end-line">
             </li>
            </ul>
          </div>
        </nav>
        
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          
          <div class="row bg-white">
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
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <div class="row">
            <div class="table-responsive col-10 offset-md-1">
              <form id="loginForm" action="${ pageContext.servletContext.contextPath }/admin/fee/search" method="get">
              <div class="row">
                <div class="form-group row">
                <div class="col-1"></div>
				  <label for="example-month-input" class="col-2 col-form-label">일자,유저코드 입력</label>
				  <div class="col-3">
				    <input class="form-control" type="month" value="2021-05" id="month-input" name="month-input">
				  </div>
				  <div class="col-3">
		             <input class="form-control" type="search" id="searchValue" name="searchValue" >
		          </div>
				  <div class="col-3">
	                  <button type="submit" class="btn btn-outline-secondary">검색하기</button>
	               </div>
				</div>
              </div>
              </form>
              <br>
              
              <br>
              
              
            </div>
          </div>
        </main>
      </div>
      
      <div class="footer text-right align-middle" style="background-color:#EF9309;">
        <a class="text-dark footer-text text-decoration-none">Copyright &copy; BABMOKJA All Right Reserved.&nbsp;</a>
      </div>
      
    </div>
    
    
  </body></html>