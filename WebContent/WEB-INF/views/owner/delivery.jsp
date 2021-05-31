<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PC 주문 관리</title>
  <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/reset.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/button.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/common.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/delivery.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/common_main.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/bootstrap.min.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/success_modalpop.css">

    <script src="${ pageContext.servletContext.contextPath }/resources/js/owner/semi_store_js/function_sc.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/js/owner/semi_store_js/clickevent.js"></script>


</head>

<body>
    <aside>
        <a id="logo" class="link-dark" href="${ pageContext.servletContext.contextPath }/main" 
        style="text-decoration: none;
   		color: black;
    	font-style: normal;
    	font-weight: bolder;}"> babmokja </a>
        <p>Menu</p>


        <nav>
            <ul class="sidebar">
                <li class="on"><a href="${ pageContext.servletContext.contextPath }/owner/delivery">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/delivery_pic.png" alt="배달" width="50px" height="50px">배 달</a></li>
                <li><a href="${ pageContext.servletContext.contextPath }/owner/pick_up"><img src="${ pageContext.servletContext.contextPath }/resources/image/owner/pick_up.png" alt="픽업" width="50px" height="50px">픽 업</a>
                </li>

            </ul>
        </nav>
        <div class="footer">
            <span>
                ㈜ 지금 배고프조<br><br>
                서울특별시 강남구 강남동 000, 타워 5층<br>
                사업자 등록번호: 000-00-00000 <br>
                통신판매업 신고번호: 2021-서울강남-04026 <br>
                고객 만족센터 : babmokja@babmokja.co.kr<br><br>


                고객센터: 02-123-4444
                (24시간, 연중무휴)<br>

                Copyright &copy; BABMOKJA All Right Reserved.
            </span>
        </div>
    </aside>
    
    
    
    

    <div id="wrap">
        <div class="float-wrap">

            <br>
            <div class="row bg-white">
                <span class="col-2 menu-item menu-item-selected">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item1.png" />
                &nbsp;&nbsp;&nbsp;<a href="order.html">주문확인</a>
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
                <img class="img-fluid" src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/PC주문관리.png" />
                &nbsp;&nbsp;&nbsp;<a class="text-dark" href="${ pageContext.servletContext.contextPath }/owner/delivery">PC주문현황</a>
              </span>
  
              <span class="col-2 menu-item">
                  <span class="imagesize"><img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item4.png" /></span>
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board (업체용 게시판)/company/Owner_Comment_Board.html">리뷰관리</a>
               </span>
  
                <span class="col-2 menu-item">
                  <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/item4.png" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/suggestion/list">1:1 문의하기</a>
                </span>
            </div>

            <div class="right-con">
                <ul class="tab">
                    <li class="on" id="tab1"><a href="#tab1">주문접수 내역</a></li>
                    <li id="tab2"><a href="#tab2">주문 진행중</a></li>
                    <li id="tab3"><a href="#tab3">배달 완료</a></li>
                </ul>
                <main>
	
                     <div class="content-wrap">
                   		 <c:forEach items="${requestScope.deliveryList }" var= "delivery">
                   		 	<c:choose>
                   		 		                   		
		                     	<c:when test="${ delivery.orderProceed eq '미승인' }">
			                        <div class="content-info" id="tab1">
			                            <div>
			                                <input name="userId" type="text" value=<c:out value ="${ delivery.userId }(${delivery.userName })"/> readonly>
			                                <ul>
			                                <c:forEach items="${requestScope.cartList }" var = "cart">
			                                     <li>${cart.menuName }  ${cart.amount }</li>
			                                </c:forEach>
			                                </ul>
			                                <p>총 가격 : </p><input type="text" name="totalPrice" value="${ delivery.totalPrice}" readonly>
			                                	<input type="hidden" name="orderCode" id="orderCode" value = "${delivery.orderCode }">
				                                <div class="content-btn">
				                                    <a style="cursor: pointer">주문 승인</a>
				                                    <a style="cursor: pointer">주문 거절</a>
				                                </div>
			                            </div>
			                        </div>
			                      </c:when>
			                      
			                      <c:when test="${ delivery.orderProceed eq ' ' }">
                   		 			<h1> 현재 진행중인 주문이 없습니다..! </h1>
                   		 		</c:when>
			                      
		                     </c:choose>
                        </c:forEach>
                     </div>


                    <!-- ---------------------배송---------------------- -->
                   
                  <div class="content-wrap">
                    <c:forEach items="${requestScope.deliveryList }" var= "delivery">
	                    <c:choose>
	                     	<c:when test="${ delivery.orderProceed eq '승인' }">
		                        <div class="content-info" id="tab2">
			                            <div>
			                                <input type="text" placeholder="고객번호(고객명)" value = "${ delivery.userId }(${delivery.userName })" readonly>
			                                <ul>
			                                <c:forEach items="${requestScope.cartList }" var = "cart">
			                                    <li>${cart.menuName }  ${cart.amount }</li>
			                                </c:forEach>
			                                </ul>
			                                <p>총 가격 : </p><input type="text" value="${ delivery.totalPrice}" readonly>
			                                <input type="hidden" name="orderCode" id="orderCode"  value = "${delivery.orderCode }">
			                                <div class="content-btn1">
			                                    <a>배송 진행</a>
			                                </div>
			                            </div>
		                       	 </div>
	                     	   </c:when>
	                        </c:choose>
                        </c:forEach>
                     </div>

                    <!------------------------ 배송완료 ------------------------->
                        
                        <div class="content-wrap">
		                    <c:forEach items="${requestScope.deliveryList }" var= "delivery">
			                    <c:choose>
			                     	<c:when test="${ delivery.orderProceed eq '완료' }">
				                        <div class="content-info" id="tab3">
				                            <div>
				                                <input type="text" placeholder="고객번호(고객명)" value = "${ delivery.userId }(${delivery.userName })" readonly>
				                                <ul>
					                                <c:forEach items="${requestScope.cartList }" var = "cart">
					                                    <li>${cart.menuName }  ${cart.amount }</li>
					                                </c:forEach>
				                                </ul>
				                                <p>총 가격 : </p><input type="text" value="${ delivery.totalPrice}" readonly>
				                                <input type="hidden" name="orderCode" value = "${delivery.orderCode }">
					                                <div class="content-btn2">
					                                    <a>배송 완료</a>
					                                </div>
					                            </div>
					                        </div>
			                        	</c:when>
			                        </c:choose>
		                        </c:forEach>
                   			</div>
       		    	 	</main>
                  </div>
        </div>
    </div>


    <div class="modal_wrap"></div>
    
    <!-- 소요 시간 팝업 -->
    
	<form action="${ pageContext.servletContext.contextPath }/update/time" method="post">
    	<div id="sc_modal">
      	  <p class="modal_title">배달 소요 시간 선택</p>
      	  
	       <div class="time_list">
	            <ul>
	                <li class="time" name="time"><a name="time">30 분 ~ 40 분</a></li>
	                <li class="time" name="time"><a name="time">40 분 ~ 50 분</a></li>
	                <li class="time" name="time"><a name="time">50 분 ~ 60 분</a></li>
	            </ul>
	            <input type="hidden" id="selection" name="selection">
	            <input type="hidden" class ="code" name="code">
	       </div>
	       
       	  <button type="submit" id="time_btn" >선택 완료</button>
        <a class="modal_closebtn">
            <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/semi_store/close.png" alt="닫기" width="50px" height="50px"></a>
    	</div>
    </form>

    <!-- 거절 팝업 -->
    <form action="${ pageContext.servletContext.contextPath }/update/time" method="POST">
	    <div id="sc_modal2">
	        <p class="modal_title">주문 거절은 신중하게 선택해주세요!</p>
	        <span>주문 거절로 인해 소중한 단골고객을 잃을 수 있습니다.</span>
	
	        <div class="time_list">
	            <ul>
	                <li><a> 해당 메뉴 품절</a></li>
	                <li><a> 주문량 폭주</a></li>
	                <li><a> 배달원 부재</a></li>
	            </ul>
	            <input type="hidden" id="deny" name = "deny">
	            
	        </div>
	        <button type="button" class="choice_okbtn">선택 완료</button>
	
	        <a class="modal_closebtn">
	            <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/close.png" alt="닫기" width="50px" height="50px"></a>
	    </div>

    <!-- 거절 진행 팝업 -->
	    <div class="sc_modal_process">
	        <div>
	            <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/warning.png" alt="경고!!" width="90px" height="105px">
	            <p>주문 거절을 진행하시겠습니까?</p>
	        </div>
			<input type="hidden" id="result" name="result" />
			 <input type="hidden" id ="code1" name="code1">
			
	        <div class="submit-box">
	        
	        	<button type="submit" class="okbtn">확인</button>
	   <!--          <a class="okbtn">확인</a> -->
	            <a class="nobtn">취소</a>
	        </div>
	
	    </div>
    </form>

 	<form action="${ pageContext.servletContext.contextPath }/update/time" method="POST">
	    <div class="sc_modal_process2">
	        <div>
	            <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/warning.png" alt="경고!!" width="90px" height="105px">
	            <p>배달을 진행하시겠습니까?</p>
	        </div>
		
			<input type="hidden" name="complete" value="완료" />
			 <input type="hidden" id ="code2" name="code2">
	        <div class="submit-box1">
	            <button type="submit" class="okbtn" id="okbtn">확인</button>
	            <a class="nobtn1">취소</a>
	        </div>
	
	    </div>
    </form>
    <script src="${ pageContext.servletContext.contextPath }/resources/js/owner/semi_store_js/modal.js"></script>

    <script>
        $(function () {
            $(".tab>li").on('click', function (e) {
                e.preventDefault();
                if ($(".tab>li#tab1")[0].innerText == e.target.text) {
                    $("#tab1").addClass('on');
                    $("#tab2").removeClass('on');
                    $("#tab3").removeClass('on');
                    $(".content-wrap")[0].style.display = "flex";
                    $(".content-wrap")[1].style.display = "none";
                    $(".content-wrap")[2].style.display = "none";

                } else if ($(".tab>li#tab2")[0].innerText == e.target.text) {
                    $("#tab1").removeClass('on');
                    $("#tab2").addClass('on');
                    $("#tab3").removeClass('on');
                    $(".content-wrap")[0].style.display = "none";
                    $(".content-wrap")[1].style.display = "flex";
                    $(".content-wrap")[2].style.display = "none";
                } else {
                    $("#tab1").removeClass('on');
                    $("#tab2").removeClass('on');
                    $("#tab3").addClass('on');
                    $(".content-wrap")[0].style.display = "none";
                    $(".content-wrap")[1].style.display = "none";
                    $(".content-wrap")[2].style.display = "flex";
                }
            });
        }); 

    // $(function(){
    //     $(".sidebar>li").on('click',function(e){
    //         if()
    //     })

    // })
    </script>

</body>

</html>