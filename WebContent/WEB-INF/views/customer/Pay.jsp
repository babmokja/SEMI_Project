<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>BoB</title>
<link href="resources/css/customer/important.css" type="text/css" rel="stylesheet">
<link href="resources/css/customer/common_ah.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/customer/main.css">
<link href="resources/css/customer/reset.css" type="text/css" rel="stylesheet">
<link href="resources/css/customer/button.css" type="text/css" rel="stylesheet">
<link href="resources/css/customer/pay_home_eat.css" type="text/css" rel="stylesheet">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
						<div class="customer_info_total">
							<div class="customer_address_number">
								<label style="margin-left: 25px;">우편번호</label> <input
									type="text" name="zip" class="customer_info_address_number" style="border: 1px solid; height: auto; font-size: 25px;"/>
								<button type="button" onclick="openZipSearch()"
									style="background: none;">
									<img src="resources/image/customer/address-search.png" alt="이미지없음"
										id="icon_adderss_search" />
								</button>
							</div>
							<div class="customer_address">
								<label>주&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소</label> <input
									type="text" name="addr1" class="customer_info_address_default" style="border: 1px solid; height: auto; font-size: 25px;"
									readonly="readonly" />
							</div>
							<div class="customer_address_detail">
								<label>상세주소</label> <input type="text" name="addr2"
									class="customer_info_address_default_detail" style="border: 1px solid; height: auto; font-size: 25px;" re="re" />
							</div>

							<script>
								function openZipSearch() {
									new daum.Postcode(
											{
												oncomplete : function(data) {
													$('[name=zip]').val(
															data.zonecode); // 우편번호 (5자리)
													$('[name=addr1]').val(
															data.address);
													$('[name=addr2]').val(
															data.buildingName);
												}
											}).open();
								}
							</script>

							<div class="customer_tel_number">
								<label>전화번호</label> <input type="text"
									class="customer_info_tel_number_default"
									placeholder=" ex) 010 - 1234 - 5678" style="border: 1px solid; height: auto; font-size: 25px;">
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
									placeholder="
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;요청 사항을 적어주세요"
									style="font-size: 30px;"></textarea>
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
								<label class="method_of_payment_kakao"><input
									type="radio" name="method_of_payment" value="kakao" /> 카카오페이</label> <label
									class="method_of_payment_money"><input type="radio"
									name="method_of_payment" value="cash" /> 현금</label>
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
							<div class="restaurant_name_choice">더 조은 음식점</div>
						</div>
						<div class="order_list_detail">
							<div class="order_list_detail_title">주문 내역</div>
							<div class="order_list_detail_choice">주문한 음식 리스트 출력 예정</div>
						</div>
						<div class="order_total_pay">
							<div class="order_total_pay_title">총 금액</div>
							<div class="order_total_pay_choice">999999 원</div>
						</div>
					</div>

					<div class="second">
						<div class="order_final_btn">
							<a href="#;" class="order_final_btn_choice">결제하기</a>
						</div>
					</div>
				</span>

			</div>

			<div class="fourth">
				<div class="point_use">
					<input type="text" class="point_use_title">포인트 사용 선택
				</div>
				<div class="point_isUse_choice">
					<div class="point_info">포인트</div>
					<div class="point_explanation">사용 시 체크</div>
					<div class="point_use_choice">
						<input type="checkbox" class="point_use_ckbox">
					</div>
				</div>
			</div>
		</div>
		<br>

		<!-- footer -->
		<jsp:include page="/WEB-INF/views/common/customer/footer.jsp" />

	</center>

</body>
</html>