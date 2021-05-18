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
                 <a href="${pageContext.servletContext.contextPath}/admin/fee" >이용료 정산내역 조회</a>
                <hr class="end-line">
              </li>

              <li class="nav-item sublogo">
                업소 가입/추가신청 조회
               <hr class="end-line">
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
            <span class="col-2 menu-item ">
            <a href="${pageContext.servletContext.contextPath}/admin/customer" class="link-dark">  <img src="/SEMI_Project/resources/image/admin/item2.png" />
              &nbsp;&nbsp;&nbsp; 고객관리</a>
            </span>
            <span class="col-2 menu-item menu-item-selected  ">
              <img src="/SEMI_Project/resources/image/admin/item3.png" />
              &nbsp;&nbsp;&nbsp; 업소관리
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
                <div class="col-2">
                  유저번호,유저명
                  <select class="form-select" >
                    <option selected>카테고리 선택</option>
                    <option value="1">유저번호</option>
                    <option value="2">유저명</option>
                  </select>
                </div>
                <div class="col-2">
                  신청구분
                  <select class="form-select" >
                    <option selected>카테고리</option>
                    <option value="1">신규가입</option>
                    <option value="2">추가신청</option>

                  </select>
                </div>
                <div class="col-3">
                  유저번호,유저명 입력
                  <input class="form-control" type="text" >
                  
                </div>
                
                <div class="col-3">
                  <br>
                  <button type="button" class="btn btn-outline-secondary">검색하기</button>
                </div>
              </div>
              <br>
              <table class="table table-striped table-sm  text-center ">
                <thead>
                  <tr>
                    <th>유저번호</th>
                    <th>유저명</th>
                    <th>카테고리</th>
                    <th>신청일자</th>
                    <th>처리여부</th>
                    <th>상세보기</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>OW001</td>
                    <td>홍길동</td>
                    <td>신규가입</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>승인</th>
                    <td><a href="${pageContext.servletContext.contextPath}/admin/owner/detail" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길똥</td>
                    <td>추가신청</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>미확인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길동</td>
                    <td>신규가입</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>승인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길똥</td>
                    <td>추가신청</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>미확인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길동</td>
                    <td>신규가입</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>승인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길똥</td>
                    <td>추가신청</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>미확인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길동</td>
                    <td>신규가입</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>승인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길똥</td>
                    <td>추가신청</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>미확인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길동</td>
                    <td>신규가입</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>승인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길똥</td>
                    <td>추가신청</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>미확인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길동</td>
                    <td>신규가입</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>승인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길똥</td>
                    <td>추가신청</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>미확인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길동</td>
                    <td>신규가입</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>승인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길똥</td>
                    <td>추가신청</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>미확인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길동</td>
                    <td>신규가입</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>승인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
                  </tr>
                  <tr>
                    <td>OW001</td>
                    <td>홍길똥</td>
                    <td>추가신청</td>
                    <td>2021-05-13 09:00:00</td>
                    <th>미확인</th>
                    <td><a href="./index-owner2.html" class="link-dark">상세보기</a></td>
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