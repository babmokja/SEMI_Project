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
  
  <link href="${pageContext.servletContext.contextPath}/resources/css/owner/semi_store/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.servletContext.contextPath}/resources/css/owner/semi_store/main.css" rel="stylesheet">
  
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
        <nav class="col-md-2 d-none d-md-block bg-yellow sidebar sidebar-bapmakja" style="height: 95vh;">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item logo">
               <a href="${ pageContext.servletContext.contextPath }/main" 
		        style="text-decoration: none;
		   		color: black;
		    	font-style: normal;
		    	font-weight: bolder;}"> babmokja </a>
              </li>
              <li class="nav-item title">
                업소 관리   
              </li>
            </ul>
            
                   <ul class="nav flex-column">
              <hr class="end-line">
              <li class="nav-item sublogo">
                <a href="${ pageContext.servletContext.contextPath }/menu/all">메뉴 관리</a>
                <hr class="end-line">
              </li>
              
              <li class="nav-item sublogo">
                <a href="${ pageContext.servletContext.contextPath }/owner/sales/day">매출 관리</a>
                <hr class="end-line">
              </li>

              <li class="nav-item sublogo">
                <a href="${ pageContext.servletContext.contextPath }/onwer/fee">세금계산서 확인</a>
               <hr class="end-line">
             </li>

            </ul>
          </div>
        </nav>
        
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          
          <div class="row bg-white">
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
                <img class="img-fluid" src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_board/computer.png" style="width:40px; height:40px" />
                &nbsp;&nbsp;&nbsp;<a class="text-dark" href="${ pageContext.servletContext.contextPath }/owner/delivery">PC주문현황</a>
              </span>
  
              <span class="col-2 menu-item">
                  <span class="imagesize"><img src="${ pageContext.servletContext.contextPath }/image/owner/semi_store/item4.png" /></span>
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board (업체용 게시판)/company/Owner_Comment_Board.html">리뷰관리</a>
                </span>
  
                <span class="col-2 menu-item">
                  <img src="${ pageContext.servletContext.contextPath }/image/owner/semi_store/item4.png" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/suggestion/list">1:1 문의하기</a>
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
              <form id="loginForm" action="${ pageContext.servletContext.contextPath }/owner/taxconfirm" method="get">
              <div class="row">
                <div class="form-group row">
                <div class="col-1"></div>
				  <label for="example-month-input" class="col-2 col-form-label">월 입력: </label>

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