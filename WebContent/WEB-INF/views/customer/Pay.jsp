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
							<input type="text" class="payment_title_title">????????? ??????
						</div>
						<div class="customer_info_total" style="width: 500px;">
							<tr class="customer_address_number">
            					<th style="margin-left: 25px; margin-right: 35px;">????????????</th>
            					<td><input type="text" name="zip" size="25" style="vertical-align: baseline; border: 1px solid; margin-top: 10px; margin-right: -60px; width: 300px"> 
            					<button type="button" class="btn btn-yg" id="searchZipCode" style="cursor: pointer; background: none;" onclick="openZipSearch()">
            					<img src="${ pageContext.servletContext.contextPath }/resources/image/customer/address-search.png" alt="???????????????" id="icon_adderss_search" />
            					</button></td><br>
         					</tr>
          					<tr class="customer_address" id="customer_address">
            					<th>??????</th>
            					<td><input type="text" size="25" name="addr1" id="addr1" class="customer_info_address_default" readonly  style="border: 1px solid; vertical-align: baseline; width: 300px; margin-right: -50px;"/> </td>
          					</tr><br> 
          					<tr>
            					<th class="customer_address_detail">????????????</th??>
            					<td><input type="text"size="25" name="addr2" class="customer_info_address_default_detail" style="border: 1px solid; vertical-align: baseline; width: 300px; margin-right: -10px;"/> </td>
          					</tr>
          					<script>
            				function openZipSearch() {
                				new daum.Postcode({
                    				oncomplete: function(data) {
                        				$('[name=zip]').val(data.zonecode); // ???????????? (5??????)
                        				$('[name=addr1]').val(data.address);
                        				$('[name=addr2]').val(data.buildingName);
                    				}
                				}).open();
            				}
            				</script>
							<div class="customer_tel_number">
								<label>????????????</label> 
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
							<input type="text" class="customer_request_info_title_title">?????????
							????????????
						</div>
						<div class="customer_request_info_input">
							<div class="customer_request_info_input_detail">
								<textarea cols="15" rows="15"
									placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;?????? ????????? ???????????????"
									style="font-size: 30px;" id="customer_request_info_input_detail"></textarea>
							</div>
						</div>
					</div>
					<div>
						<div class="method_of_payment">
							<input type="text" class="method_of_payment_title">?????? ??????
							??????
						</div>
						<div class="method_of_payment_choice">
							<form>
								<label class="method_of_payment_kakao"> <input
									type="radio" name="method_of_payment" id="kakao" value="kakao"
									onclick="payment(this);" /> ???????????????
								</label> <label class="method_of_payment_money"> <input
									type="radio" name="method_of_payment" id="cash" value="cash"
									onclick="payment(this);" /> ??????
								</label>
							</form>
						</div>
					</div>
				</span> <span class="order_list">
					<div class="order_list_title">
						<input type="text" class="order_list_title_title">????????????
					</div>
					<div class="order_info">
						<div class="restaurant_name">
							<div class="restaurant_name_title">????????? ??????</div>
							<div class="restaurant_name_choice">
								<c:out value="${ requestScope.selectBasket[0].storeName }"></c:out>
							</div>
							<div class="restaurant_id_choice" id="restaurant_id_choice" style="display: none;">
								<c:out value="${ requestScope.selectBasket[0].storeCode }"></c:out>
							</div>
						</div>
						<div class="order_list_detail" style="margin-bottom: 0px;">
							<div class="order_list_detail_title" style="margin-bottom: 20px;">??????
								??????</div>
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
							<div class="order_total_pay_title">??? ??????</div>
							<div id="order_total_pay" style="float:left; margin-left: 90px;">
								<c:out value="${ requestScope.totalPay }"></c:out>
							</div>
							<div class="order_total_pay_choice" style="margin-right: 50px;">???</div>
						</div>
					</div>
					<div class="second">
						<button class="order_final_btn_choice" id="order_final_btn_choice"
							type="button" disabled>????????????</button>
					</div>
				</span>
			</div>
			<div class="fourth">
				<div class="point_use">
					<input type="text" class="point_use_title">????????? ?????? ??????
				</div>
				<div class="point_isUse_choice">
					<div class="point_info">
						????????? :
						<div id="point_num" style="float: right; margin-left: 10px;">
							<c:out value="${ requestScope.selectPoint.point }"></c:out>
						</div>
					</div>
					<div class="point_explanation">?????? ??? ??????</div>
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
			alert("?????? ?????? ??????! ????????? ?????????????????????.");
    		location.href = "${ pageContext.servletContext.contextPath }";
		} else {
			
			var IMP = window.IMP; // ????????????
	        IMP.init('imp52213140'); // 'iamport' ?????? ???????????? "????????? ????????????"??? ??????
	        var msg;	
	        
	        IMP.request_pay({
	            pg : 'kakaopay',
	            pay_method : 'card',
	            merchant_uid : 'merchant_' + new Date().getTime(),
	            name : 'BoB (???)?????????',
	            amount : totalPrice,
	            buyer_email : emailTrim,
	            buyer_name : nameTrim,
	            buyer_tel : phoneTrim,
	            buyer_addr : address,
	            buyer_postcode : '123-456'
	       }, function(rsp) {
	    	   if ( rsp.success ) {
	                // ???????????? ???????????? ????????? ?????? jQuery ajax??? imp_uid ????????????
	               jQuery.ajax({
	                    url: "/payments/complete", //cross-domain error??? ???????????? ????????? ??????????????????
	                    type: 'POST',
	                    dataType: 'json',
	                    data: {
	                        imp_uid : rsp.imp_uid
	                        //?????? ????????? ???????????? ????????? ?????? ??????
	                    }
	                }).done(function(data) {
	                	// ???????????? REST API??? ?????????????????? ??? ?????????????????? ???????????? ??????
	                    if ( everythings_fine ) {
	                        msg = '????????? ?????????????????????.';
	                        msg += '\n??????ID : ' + rsp.imp_uid;
	                        msg += '\n?????? ??????ID : ' + rsp.merchant_uid;
	                        msg += '\?????? ?????? : ' + rsp.paid_amount;
	                        msg += '?????? ???????????? : ' + rsp.apply_num;
	                        
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
		            		 alert("??????????????? ?????? ??????! ????????? ?????????????????????.");
		            		 location.href = "${ pageContext.servletContext.contextPath }";
		            	 }
		            });
	                
	    	   } else {
	    		   msg = '????????? ?????????????????????.';
	               msg += '???????????? : ' + rsp.error_msg;
	               //????????? ????????? ?????????
	               location.href="${ pageContext.servletContext.contextPath }/WEB-INF/views/common/customer/failed.jsp";
	               alert(msg);
	    	   }
	       });
		}});          
	
</script>
</body>
</html>