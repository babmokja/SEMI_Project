
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/main.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/mypage.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    
      <center>
         <header>
            <div class="head">
                <div class="right">
                    <div>
                        <a href="#;" class="logo">babmokja</a>
                    </div>
                    
                    <div class="sq">
                        <c:if test="${ !empty sessionScope.loginUser }"> 
                        <div class="mypage">
                            <a href="${ pageContext.servletContext.contextPath}/user/mypage" class="mypage_icon">
                              <img src="${ pageContext.servletContext.contextPath }/resources/image/customer/user.png" alt="이미지없음"></a>
                        </div>
                         <div class="logout">
                            <a href="${ pageContext.servletContext.contextPath }/user/logout" class="logout_icon">로그아웃</a>
                        </div>
                     </c:if>   
                    </div>
                    
                </div>
                <div>
                    <a href="${ pageContext.servletContext.contextPath }" class="title">너의 밥먹는건 우리가 책임진다</a>
                </div>
                <div class="searchbox">
                    <a href="${ pageContext.servletContext.contextPath }/store/list">
                        <img src="${ pageContext.servletContext.contextPath }/resources/image/customer/magnifying.png" alt="이미지없음" id="icon">
                    </a>
                    <input type="text" class="searchpoint">
                </div>
                       


                       
                       
                        <div class="nav">
                            <div class="a">
                                <a href="${ pageContext.servletContext.contextPath }/store/list?cate=kor&type=1&order=congestion&currentPage=1" class="a" id="kor">한식</a>
                           </div>
                           <div class="a">
                              <span>
                                <a href="${ pageContext.servletContext.contextPath }/store/list?cate=fra&type=1&order=congestion&currentPage=1" class="a" id="fra">프랜차이즈</a>
                             </span>
                           </div>
                           <div class="a">
                              <span>
                                <a href="${ pageContext.servletContext.contextPath }/store/list?cate=chi&type=1&order=congestion&currentPage=1" class="a" id="chi">중식</a>
                              </span>
                            </div>
                            <div class="a">
                            <span>
                                <a href="${ pageContext.servletContext.contextPath }/store/list?cate=jap&type=1&order=congestion&currentPage=1" class="a" id="jap">일식</a>
                            </span>
                            </div>
                            <div class="a">
                            <span>
                                <a href="${ pageContext.servletContext.contextPath }/store/list?cate=ame&type=1&order=congestion&currentPage=1" class="a" id="ame">양식</a>
                            </span>
                            </div>
                        </div>
                    </div>
          </header>
    </center>


    <div class="page">
        <label >마이페이지</label>
        </div>
        
        <section id="section1">
        <div class ="myinformation" ><br><br>
        <label class='name' style="margin-left:50px">${ sessionScope.loginUser.name }님 안녕하세요</label>
        <br><br><br><br><br><br>
        <h1>밥묵자 회원정보 </h1>
        <br>
        <span style="float: right;font-size: larger;font-weight: 500;  margin-right:-20px; margin-top:10px">회원정보를 수정하시면<br>수정하기 버튼을<br>눌러주세요</span>
        <img src="${ pageContext.servletContext.contextPath }/resources/image/customer/user.png" width="150px" height="150px" style="margin-top: 10px;">

         <br>
             <button class="smallbtn" onclick="location.href='${ pageContext.servletContext.contextPath }/user/modify">정보수정</button>
<%--          <input type="button" value="수정하기" class="smallbtn" ><a href="${ pageContext.servletContext.contextPath }/user/modify"></a></input> --%>
      
          
         </div>


        <br>

     
       <div class="myinformation">
       <br><br><br><br><br><br><br>     
       <label class='pointlabel'>밥묵자 포인트</label>
       <br><br>
       <span style="font-size: larger;font-weight: 500; margin-right:-65px; width=105px; float:right;">현재 포인트<br><label>${ sessionScope.loginUser.point }</label></span> 
       <img src="${ pageContext.servletContext.contextPath }/resources/image/customer/point.png" id = "mypoint" width="150px" height="150px"style="margin-left: 150px; " >
       
<!--        <input type="button"id="modal_open_btn"  style="margin-left: 163px;" value="상세보기" class="smallbtn" > -->
       
       </div>  
             <button class='question' onclick="location.href='${ pageContext.servletContext.contextPath }/board/list">1대1문의하기</button>                                         
<%--       <input type="button" value="1대1 문의하기" class='question' ><a href="${ pageContext.servletContext.contextPath }/board/list"/></input> --%>
     </section> 
    
  
        

        
        <section id="section2">
        <label class = 'latest_name'>최근주문내역</label>
         <table class='order'>
          <thead>
            <tr >
              <th >주문일자</th>
              <th >주문방법</th>
              <th >주문가게</th>
              <th style="padding-left: 20px;" >주문상태</th>
              <th>상세보기</th>  
              <th>리뷰작성</th> 
<!--               <th>주문취소</th>  -->   
           </tr>
         </thead>
       

        <tbody >
            <c:forEach var="order" items="${ requestScope.orderdto}">
            <tr>      
                <td >${ order.orderDate }</td>
                <td  >${ order.orderType }</td>
                <td >${ order.storeName }</td>
                <td style="text-align: right;" >${ order.proceed }</td>
                <td><input type="button"  value="더보기" class="modal_open_btn2" /></td>
                <td>
                <button class="btn_review" onclick="location.href='${ pageContext.servletContext.contextPath }/review?order=${order.orderCode}&store=${order.storeCode}'">리뷰작성</button>  
               
                </td>
<!--                 <td><input type="button"  value="취소"  class="modal_open_btn3"  ></td> -->
            </tr>
            </c:forEach>
         
        </tbody>
   
    </table> 


    </section>
     

    <div class="modal2">
        <div class="modal_content2">

            <label align= "center">${ order.ownerComment } </label>
            <button type="button" class="modal_close_btn2">확인</button>
        
        </div>
      <div class="modal_layer2"></div>
         <script>
           $(document).ready(function(){
               $('.modal_open_btn2').click(function(){
                   $('.modal2').show();
                   $('modal_layer2').show();
               });
           $('.modal_close_btn2').click(function(){
                $('.modal2').hide();
           $('modal_layer2').hide();
            });
         });

       </script>
    </div>

    <div class="modal3">
        <div class="modal_content3">
            <label align= "center">취소하시겠습니까?</label>
            <div class="btn_float">
              <button type="button" class="modal_yes">예</button>
              <button type="button" class="modal_no">아니요</button>
           </div>
       
        </div>
      <div class="modal_layer3"></div>
      <script>
        $(document).ready(function(){
           $('.modal_open_btn3').click(function(){
           $('.modal3').show();
           $('modal_layer3').show();
         });
           $('.modal_yes').click(function(){
           $('.modal3').hide();
           $('modal_layer3').hide();
          });
           $('.modal_no').click(function(){
           $('.modal3').hide();
           $('modal_layer3').hide();
          });

        });

    </script>
    </div>
    <div id="modal">
        <div class="modal_content">
            <label align= "center"id="nowpoint" style="margin-top: 20px;">
                                                  현재 사용가능한 포인트는<br>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        [000000]P 입니다 <br></label>
  
              <table align = "center" class="scrolltable">
                        <thead>
                          <tr>
                             <th>일자</th>
                             <th>방법</th>
                             <th>포인트</th>
                          </tr>
                        </thead>
                        <tbody>
                           <tr>  
                              <td>2020/4/20</td>
                              <td>픽업</td>
                              <td>+300</td>     
                           </tr>
                           <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>
                         <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>
                         <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>
                         <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>
                         <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>
                         <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>
                         <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>
                         <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>
                         <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>
                         <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>                                 <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>                                 <tr>
                            <td>2020/4/20</td>
                            <td>픽업</td>
                            <td>+300</td>     
                         </tr>
                         
        
                       </tbody>
                    </table>
  
           
            <button type="button" id="modal_close_btn" class="smallbtn" style="margin-left: 140px;">확인</button>
           
        </div>
       
        <div class="modal_layer"></div>
        <script>
            document.getElementById("modal_open_btn").onclick = function() {
                document.getElementById("modal").style.display="block";
            }
           
            document.getElementById("modal_close_btn").onclick = function() {
                document.getElementById("modal").style.display="none";
            }   
        </script>
    </div>
 
    

    <footer>
        <div id="footlim">
            <small>
                <br>㈜ 지금 배고프조<br><br>
                서울특별시 강남구 강남동 000, 타워 5층 | 사업자 등록번호: 000-00-00000 [사업자정보확인]<br>
                통신판매업 신고번호: 2021-서울강남-04026 | 개인정보 담당자 : babmokja@babmokja.co.kr | 제휴문의 :
                babmokja@babmokja.co.kr | 고객 만족센터 : babmokja@babmokja.co.kr<br><br>

                (유)지금 배고프조는 통신판매중개자이며 통신판매의 당사자가 아닙니다. <br> 따라서 상품/ 거래정보 및 거래와 관련하여 밥먹자에 등록된 판매자의 고의
                또는 과실로 소비자에게 발생하는 손해에 대해 (유)지금 배고프조는 책임을 지지 않습니다.<br>
                상품 및 거래에 관하여 보다 정확한 정보는 해당 판매자에게 직접 확인하여 주시기 바랍니다. Copyright BABMOKJA. All
                Rights Reserved.<br><br>

                고객센터: 02-123-4567 (24시간, 연중무휴)
                <br>
                <address>
                    Copyright &copy; BABMOKJA All Right Reserved.</address>
            </small>
        </div>
    </footer> 

</body>

</html>