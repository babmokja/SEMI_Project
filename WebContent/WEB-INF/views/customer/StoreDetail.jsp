<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>BoB</title>
<link rel="stylesheet" href="resources/css/customer/main.css">
<link href="resources/css/customer/reset2.css" type="text/css"
	rel="stylesheet">
<link href="resources/css/customer/button.css" type="text/css"
	rel="stylesheet">
<link href="resources/css/customer/common_ah.css" type="text/css"
	rel="stylesheet">
<link href="resources/css/customer/select.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="resources/js/customer/select.js"></script>
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
	</center>

	<div id="selectwrap">
		<div id="main">
			<div class="wrap">
				<div class="eatselect">
					<div class="bp">배달/픽업하기</div>
					<div class="or" onclick="">예약하기</div>
				</div>
				<div class="section1">
					<div class="pic"></div>
					<div class="pic"></div>
					<div class="pic"></div>
					<div class="pic"></div>
				</div>
				<div class="section2">
					<div class="section3">
						<div class="house">
							<div class="name">길목</div>
							<div class="score">4.5</div>
						</div>
						<div class="pic1">주소 : 서울특별시 강남구 어울마당로 40 2F</div>
						<div class="pic1">지번 : 서울시 강남구 서초동 411-15 2F</div>
						<div class="pic1">전화번호 : 02-508-8454</div>
						<div class="pic1">음식 종류 : 고기 요리</div>
						<div class="pic1">가격대 : 만원-2만원</div>
						<div class="pic1">주차 : 유료주차 가능 5분 4000원</div>
						<div class="pic1">영업시간 : 11:00-21:00(주문 마감 : 20:00분)</div>
						<br>
						<hr>
						<br>
						<div class="pic2">식당 소개 : 강남구 고기집 전문점임 '길목'</div>
						<br>
						<div class="pic1">강남역에서 제대로 고기먹고 싶을때 강남구에 위치한 한우등심 전문점
							'길목'에서 자신있게 만든 브랜드 매장에서 직접 한우 갈빗대를 발골하여 최상의 갈빗살만을 제공합니다. 고기의
							모범답안을 만나보세요 강남구에 위치한 한우등심 전문점 '길목'에서 자신있게 만든 브랜드 매장에서 직접 한우 갈빗대를
							발골하여 최상의 갈빗살만을 제공합니다. 고기의 모범답안을 만나보세요 강남구에 위치한 한우등심 전문점 '길목'에서
							자신있게 만든 브랜드 매장에서 직접 한우 갈빗대를 발골하여 최상의 갈빗살만을 제공합니다. 고기의 모범답안을 만나보세요

						</div>
						<br> <br> <br> <br>
					</div>
					<div id="map"></div>
					<script>
						var container = document.getElementById('map');
						var options = {
							center : new kakao.maps.LatLng(33.450701,
									126.570667),
							level : 3
						};

						var map = new kakao.maps.Map(container, options);
					</script>

				</div>
			</div>

			<div class="buttonwrap">
				<button type="button" class="button1"
					onclick="location.href='#;'">배달/픽업 메뉴판</button>
			</div>

			<div class="emot">
				<div class="emoticon">
					<img src="resources/image/customer/goodgood.png" alt=""> <img
						src="resources/image/customer/good.png" alt=""> <img src="resources/image/customer/notgood.png"
						alt="">
				</div>
				<div class="icon">
					<img src="" alt="">
				</div>
				<div class="emodesc">맛있다(15) &nbsp;&nbsp; | &nbsp;&nbsp;
					괜찮다(10) &nbsp;&nbsp; | &nbsp;&nbsp; 별로(5)</div>

			</div>

			<div class="section4">

				<div class="review">
					<div class="line"></div>
					<div class="profile">
						<div class="user">
							<img src="" alt="">
						</div>
						<div class="uname">user01</div>
					</div>
					<div class="desc">맛있어요 맛있어서 죽어요맛있어요 맛있어서 죽어요맛있어요 맛있어서 죽어요</div>
					<div class="preview"></div>
				</div>

				<div class="review">
					<div class="line"></div>
					<div class="profile">
						<div class="user">
							<img src="" alt="">
						</div>
						<div class="uname">user02</div>
					</div>
					<div class="desc">맛있어요 맛있어서 죽어요 맛있어요 맛있어서 죽어요 맛있어요 맛있어서 죽어요</div>
					<div class="preview"></div>
				</div>

				<div class="line"></div>

			</div>
		</div>
	</div>
	<center>
		<footer>
			<div class="foot">
				<small> <br>㈜ 지금 배고프조<br>
				<br> 서울특별시 강남구 강남동 000, 타워 5층 | 사업자 등록번호: 000-00-00000
					[사업자정보확인]<br> 통신판매업 신고번호: 2021-서울강남-04026 | 개인정보 담당자 :
					babmokja@babmokja.co.kr | 제휴문의 : babmokja@babmokja.co.kr | 고객 만족센터
					: babmokja@babmokja.co.kr<br>
				<br> (유)지금 배고프조는 통신판매중개자이며 통신판매의 당사자가 아닙니다. <br> 따라서 상품/
					거래정보 및 거래와 관련하여 밥먹자에 등록된 판매자의 고의 또는 과실로 소비자에게 발생하는 손해에 대해 (유)지금
					배고프조는 책임을 지지 않습니다.<br> 상품 및 거래에 관하여 보다 정확한 정보는 해당 판매자에게 직접
					확인하여 주시기 바랍니다. Copyright BABMOKJA. All Rights Reserved.<br>
				<br> 고객센터: 02-123-4567 (24시간, 연중무휴) <br>
					<address>Copyright &copy; BABMOKJA All Right Reserved.</address>
				</small>
			</div>
		</footer>
	</center>
</body>

</html>