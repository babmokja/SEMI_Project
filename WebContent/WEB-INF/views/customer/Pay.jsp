<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>BoB</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/main.css">
<link href="${ pageContext.servletContext.contextPath }/resources/css/customer/reset.css" type="text/css" rel="stylesheet">
<link href="${ pageContext.servletContext.contextPath }/resources/css/customer/button.css" type="text/css" rel="stylesheet">
<link href="${ pageContext.servletContext.contextPath }/resources/css/customer/common_ah.css" type="text/css" rel="stylesheet">
<link href="${ pageContext.servletContext.contextPath }/resources/css/customer/pay_home_eat.css" type="text/css" rel="stylesheet">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function payment(value) {
		
		var btn = document.getElementById("order_final_btn_choice");
		
		btn.disabled = false;
		
	}
	
	function discount() {
		
		var total = Number.parseInt(document.getElementById("order_total_pay").innerText);
		var point = Number.parseInt(document.getElementById("point_num").innerText);
		var div_total = document.getElementById('order_total_pay')
		
		var finalTotal = total;
		var checkBoxYN = document.getElementById('point_use_ckbox').checked;
		
		if(checkBoxYN){
			finalTotal = total - point;
		} else {
			finalTotal = total + point;
		}
		
		div_total.innerHTML = finalTotal;
		
	}
</script>
</head>
<body>
	<center>

		<!-- header -->
		<jsp:include page="/WEB-INF/views/common/customer/header.jsp" />

		<!-- body -->
		<div class="body">
			<div class="first">
				<span class="payment">
					<div class="payment_info_total">
						<div class="payment_title">
							<input type="text" class="payment_title_title">주문자 정보
						</div>
						<div class="customer_info_total" style="width: 500px;">
							<tr class="customer_address_number">
            					<th style="margin-left: 25px; margin-right: 35px;">우편번호</th>
            					<td><input type="text" name="zip" size="25" style="vertical-align: baseline; border: 1px solid; margin-top: 10px; margin-right: -60px; width: 300px"> 
            					<button type="button" class="btn btn-yg" id="searchZipCode" style="cursor: pointer; background: none;" onclick="openZipSearch()">
            					<img src="${ pageContext.servletContext.contextPath }/resources/image/customer/address-search.png" alt="이미지없음" id="icon_adderss_search" />
            					</button></td><br>
         					</tr>
          					<tr class="customer_address" id="customer_address">
            					<th>주소</th>
            					<td><input type="text" size="25" name="addr1" id="addr1" class="customer_info_address_default" readonly  style="border: 1px solid; vertical-align: baseline; width: 300px; margin-right: -50px;"/> </td>
          					</tr><br> 
          					<tr>
            					<th class="customer_address_detail">상세주소</thß>
            					<td><input type="text"size="25" name="addr2" class="customer_info_address_default_detail" style="border: 1px solid; vertical-align: baseline; width: 300px; margin-right: -10px;"/> </td>
          					</tr>
          					<script>
            				function openZipSearch() {
                				new daum.Postcode({
                    				oncomplete: function(data) {
                        				$('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
                        				$('[name=addr1]').val(data.address);
                        				$('[name=addr2]').val(data.buildingName);
                    				}
                				}).open();
            				}
            				</script>
							<div class="customer_tel_number">
								<label>전화번호</label> 
								<input type="text"
									class="customer_info_tel_number_default"
									placeholder=" ex) 010 - 1234 - 5678" style="border: 1px solid; width: 275px; vertical-align: baseline;">
							</div>
							<div class="customer_info_hidden" style="display: none;">
								<div id="email">
									<c:out value="${ requestScope.orderPerson.email }"></c:out>
								</div>
								<div id="name">
									<c:out value="${ requestScope.orderPerson.name }"></c:out>
								</div>
								<div id="phone">
									<c:out value="${ requestScope.orderPerson.phone }"></c:out>
								</div>
								<div id="userId">
									<c:out value="${ requestScope.orderPerson.userCode }"></c:out>
								</div>
							</div>
						</div>
					</div>
					<div>
						<div class="customer_request_info_title">
							<input type="text" class="customer_request_info_title_title">주문시
							요청사항
						</div>
						<div class="customer_request_info_input">
							<div class="customer_request_info_input_detail">
								<textarea cols="15" rows="15"
									placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;요청 사항을 적어주세요"
									style="font-size: 30px;" id="customer_request_info_input_detail"></textarea>
							</div>
						</div>
					</div>
					<div>
						<div class="method_of_payment">
							<input type="text" class="method_of_payment_title">결제 수단
							선택
						</div>
						<div class="method_of_payment_choice">
							<form>
								<label class="method_of_payment_kakao"> <input
									type="radio" name="method_of_payment" id="kakao" value="kakao"
									onclick="payment(this);" /> 카카오페이
								</label> <label class="method_of_payment_money"> <input
									type="radio" name="method_of_payment" id="cash" value="cash"
									onclick="payment(this);" /> 현금
								</label>
							</form>
						</div>
					</div>
				</span> <span class="order_list">
					<div class="order_list_title">
						<input type="text" class="order_list_title_title">주문내역
					</div>
					<div class="order_info">
						<div class="restaurant_name">
							<div class="restaurant_name_title">음식점 이름</div>
							<div class="restaurant_name_choice">
								<c:out value="${ requestScope.selectBasket[0].storeName }"></c:out>
							</div>
							<div class="restaurant_id_choice" id="restaurant_id_choice" style="display: none;">
								<c:out value="${ requestScope.selectBasket[0].storeCode }"></c:out>
							</div>
						</div>
						<div class="order_list_detail" style="margin-bottom: 0px;">
							<div class="order_list_detail_title" style="margin-bottom: 20px;">주문
								내역</div>
							<c:forEach var="orderList" items="${ requestScope.selectBasket }">
								<div class="order_list_detail_choice"
									style="float: left; margin-left: 80px; margin-bottom: 10px;">
									<c:out value="${ orderList.menuName }"></c:out>
								</div>
								<div class="order_list_detail_choice_cnt"
									style="margin-right: 50px; margin-bottom: 10px;">
									<c:out value="${ orderList.amount }"></c:out>
								</div>
							</c:forEach>
						</div>
						<div class="order_total_pay">
							<div class="order_total_pay_title">총 금액</div>
							<div id="order_total_pay" style="float:left; margin-left: 90px;">
								<c:out value="${ requestScope.totalPay }"></c:out>
							</div>
							<div class="order_total_pay_choice" style="margin-right: 50px;">원</div>
						</div>
					</div>
					<div class="second">
						<button class="order_final_btn_choice" id="order_final_btn_choice"
							type="button" disabled>결제하기</button>
					</div>
				</span>
			</div>
			<div class="fourth">
				<div class="point_use">
					<input type="text" class="point_use_title">포인트 사용 선택
				</div>
				<div class="point_isUse_choice">
					<div class="point_info">
						포인트 :
						<div id="point_num" style="float: right; margin-left: 10px;">
							<c:out value="${ requestScope.selectPoint.point }"></c:out>
						</div>
					</div>
					<div class="point_explanation">사용 시 체크</div>
					<div class="point_use_choice">
						<input type="checkbox" class="point_use_ckbox"
							id="point_use_ckbox" value="false" onclick="discount();">
					</div>
				</div>
			</div>
		</div>

		<br>

		<!-- footer -->
		<jsp:include page="/WEB-INF/views/common/customer/footer.jsp" />

	</center>
	<script>
	const page = document.getElementById('order_final_btn_choice');
	
	page.addEventListener('click', event => {
		
		var radioCash = document.getElementById('cash').checked;
		var totalPrice = Number.parseInt(document.getElementById("order_total_pay").innerText);
		var email = document.getElementById("email").innerText;
		var emailTrim = email.trim();
		var name = document.getElementById("name").innerText;
		var nameTrim = name.trim();
		var phone = document.getElementById("phone").innerText;
		var phoneTrim = phone.trim();
		var address = document.getElementById("addr1").innerText;
		
		if(radioCash){
			alert("현금 결제 완료! 주문에 성공하였습니다.");
    		location.href = "${ pageContext.servletContext.contextPath }";
		} else {
			
			var IMP = window.IMP; // 생략가능
	        IMP.init('imp52213140'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
	        var msg;	
	        
	        IMP.request_pay({
	            pg : 'kakaopay',
	            pay_method : 'card',
	            merchant_uid : 'merchant_' + new Date().getTime(),
	            name : 'BoB (주)밥먹자',
	            amount : totalPrice,
	            buyer_email : emailTrim,
	            buyer_name : nameTrim,
	            buyer_tel : phoneTrim,
	            buyer_addr : address,
	            buyer_postcode : '123-456'
	       }, function(rsp) {
	    	   if ( rsp.success ) {
	                // 서버에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
	               jQuery.ajax({
	                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
	                    type: 'POST',
	                    dataType: 'json',
	                    data: {
	                        imp_uid : rsp.imp_uid
	                        //기타 필요한 데이터가 있으면 추가 전달
	                    }
	                }).done(function(data) {
	                	// 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
	                    if ( everythings_fine ) {
	                        msg = '결제가 완료되었습니다.';
	                        msg += '\n고유ID : ' + rsp.imp_uid;
	                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	                        msg += '\결제 금액 : ' + rsp.paid_amount;
	                        msg += '카드 승인번호 : ' + rsp.apply_num;
	                        
	                        alert(msg);
	                    } else {
	                    }
	                });
	                
	               $.ajax({
		            	 url:"${ pageContext.servletContext.contextPath }/order/complete",
		            	 type:"GET",
		            	 data:{
		            		 totalPrice : totalPrice
		            	 },
		            	 success:function(data, textStatus, xhr){
		            		 alert("카카오페이 결제 완료! 주문에 성공하였습니다.");
		            		 location.href = "${ pageContext.servletContext.contextPath }";
		            	 }
		            });
	                
	    	   } else {
	    		   msg = '결제에 실패하였습니다.';
	               msg += '에러내용 : ' + rsp.error_msg;
	               //실패시 이동할 페이지
	               location.href="${ pageContext.servletContext.contextPath }/WEB-INF/views/common/customer/failed.jsp";
	               alert(msg);
	    	   }
	       });
		}});          
	
</script>
</body>
</html>