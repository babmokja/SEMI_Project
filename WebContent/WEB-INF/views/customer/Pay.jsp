<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>BoB</title>
<link rel="stylesheet" href="resources/css/customer/main.css">
<link href="resources/css/customer/reset.css" type="text/css" rel="stylesheet">
<link href="resources/css/customer/button.css" type="text/css" rel="stylesheet">
<link href="resources/css/customer/common_ah.css" type="text/css" rel="stylesheet">
<link href="resources/css/customer/pay_home_eat.css" type="text/css" rel="stylesheet">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
						<div class="join">
							<a href="#;" class="join_icon">회원가입</a>
						</div>
						<div class="logout">
							<a href="#;" class="logout_icon">로그아웃</a>
						</div>
						<div class="login">
							<a href="#;" class="login_icon">로그인</a>
						</div>
						<div class="mypage">
							<a href="#;" class="mypage_icon"><img
								src="resources/image/customer/user.png" alt="이미지없음"></a>
						</div>
					</div>
				</div>
				<div>
					<a href="#;" class="title">너의 밥먹는건 우리가 책임진다</a>
				</div>
				<div class="searchbox">
					<a href="#;"> <img src="resources/image/customer/magnifying.png" alt="이미지없음"
						id="icon">
					</a> <input type="text" class="searchpoint">
				</div>
				<div class="nav">
					<span> <a href="#;" class="a"
						id="kor">한식</a>
					</span> <span> <a href="#;" class="a"
						id="fra">프랜차이즈</a>
					</span> <span> <a href="#;" class="a"
						id="chi">중식</a>
					</span> <span> <a href="#;" class="a"
						id="jap">일식</a>
					</span> <span> <a href="#;" class="a"
						id="ame">양식</a>
					</span>
				</div>
			</div>
		</header>

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
									type="text" name="zip" class="customer_info_address_number" />
								<button type="button" onclick="openZipSearch()"
									style="background: none;">
									<img src="resources/image/customer/address-search.png" alt="이미지없음"
										id="icon_adderss_search" />
								</button>
							</div>
							<div class="customer_address">
								<label>주&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소</label> <input
									type="text" name="addr1" class="customer_info_address_default"
									readonly="readonly" />
							</div>
							<div class="customer_address_detail">
								<label>상세주소</label> <input type="text" name="addr2"
									class="customer_info_address_default_detail" re="re" />
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
									placeholder=" ex) 010 - 1234 - 5678">
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

		<footer>
			<div class="foot">
				<small> <br>㈜ 지금 배고프조<br> <br> 서울특별시 강남구 강남동
					000, 타워 5층 | 사업자 등록번호: 000-00-00000 [사업자정보확인]<br> 통신판매업 신고번호:
					2021-서울강남-04026 | 개인정보 담당자 : babmokja@babmokja.co.kr | 제휴문의 :
					babmokja@babmokja.co.kr | 고객 만족센터 : babmokja@babmokja.co.kr<br>
					<br> (유)지금 배고프조는 통신판매중개자이며 통신판매의 당사자가 아닙니다. <br> 따라서 상품/
					거래정보 및 거래와 관련하여 밥먹자에 등록된 판매자의 고의 또는 과실로 소비자에게 발생하는 손해에 대해 (유)지금
					배고프조는 책임을 지지 않습니다.<br> 상품 및 거래에 관하여 보다 정확한 정보는 해당 판매자에게 직접
					확인하여 주시기 바랍니다. Copyright BABMOKJA. All Rights Reserved.<br> <br>
					고객센터: 02-123-4567 (24시간, 연중무휴) <br>
					<address>Copyright &copy; BABMOKJA All Right Reserved.</address>
				</small>
			</div>
		</footer>

	</center>

</body>
</html>