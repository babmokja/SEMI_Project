<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>BoB</title>
<link rel="stylesheet" href="resources/css/customer/main.css">

<link href="resources/css/customer/reset.css" type="text/css"
	rel="stylesheet">
<link href="resources/css/customer/button.css" type="text/css"
	rel="stylesheet">
<link href="resources/css/customer/common_ah.css" type="text/css"
	rel="stylesheet">
<link href="resources/css/customer/store_list.css" type="text/css"
	rel="stylesheet">
</head>
<body>
	<center>
	
		<!-- header -->
		<jsp:include page="/WEB-INF/views/common/customer/header.jsp" />

		<!-- body -->
		<div class="body">

			<br>

			<div class="how_eat">
				<span> <a href="#;"
					class="home_eat">배달</a>
				</span> <span> <a href="#;"
					class="store_eat">픽업</a>
				</span> <span>
					<form>
						<select class="acolist">
							<option value="none" hidden="hidden">&nbsp&nbsp▶
								혼잡도별/별점별/이름별 정렬</option>
							<option value="list_congestion">혼잡도</option>
							<option value="list_star">별점</option>
							<option value="list_name">이름</option>
						</select>
					</form>
				</span>
			</div>

			<iframe
				src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12654.934506956371!2d127.140009!3d37.537776!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xaa042b09537cc87b!2z6ri464-Z!5e0!3m2!1sko!2skr!4v1619694772935!5m2!1sko!2skr"
				width="710" height="700" allowfullscreen="" loading="lazy" style="border: 5px solid #ffcc00; margin-top: 115px; margin-left: -100px;"></iframe>

			<br>
			<br>
			<br>
			<br>
			<br>
			<br>

			<div class="store">
				<table>
					<tr>
						<td><a href="#;"><img id="store_photo_choice"
								src="resources/image/customer/store1.PNG" alt="이미지 없음"></a></td>
						<td>
							<div class="restaurants-info">
								<div class="restaurant-name" title="가게이름">가게 이름</div>
								<div class="congestion" title="혼잡도">
									<label id="congestion">혼잡</label>
								</div>
								<div class="stars_reviw">
									<span class="ico-star1">★ 4.8</span> <span class="break-line">
										| </span> <span class="reviw-num">리뷰 2건</span>
								</div>
								<div class="choice">
									<a href="#;" class="store_choice">선택</a>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>

			<div class="store">
				<table>
					<tr>
						<td><a href="#;"><img id="store_photo_choice"
								src="resources/image/customer/store1.PNG" alt="이미지 없음"></a></td>
						<td>
							<div class="restaurants-info">
								<div class="restaurant-name" title="가게이름">가게 이름</div>
								<div class="congestion" title="혼잡도">
									<label id="congestion">혼잡</label>
								</div>
								<div class="stars_reviw">
									<span class="ico-star1">★ 4.8</span> <span class="break-line">
										| </span> <span class="reviw-num">리뷰 2건</span>
								</div>
								<div class="choice">
									<a href="#;" class="store_choice">선택</a>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>

			<div class="store">
				<table>
					<tr>
						<td><a href="#;"><img id="store_photo_choice"
								src="resources/image/customer/store1.PNG" alt="이미지 없음"></a></td>
						<td>
							<div class="restaurants-info">
								<div class="restaurant-name" title="가게이름">가게 이름</div>
								<div class="congestion" title="혼잡도">
									<label id="congestion">혼잡</label>
								</div>
								<div class="stars_reviw">
									<span class="ico-star1">★ 4.8</span> <span class="break-line">
										| </span> <span class="reviw-num">리뷰 2건</span>
								</div>
								<div class="choice">
									<a href="#;" class="store_choice">선택</a>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>

			<div class="store">
				<table>
					<tr>
						<td><a href="#;"><img id="store_photo_choice"
								src="resources/image/customer/store1.PNG" alt="이미지 없음"></a></td>
						<td>
							<div class="restaurants-info">
								<div class="restaurant-name" title="가게이름">가게 이름</div>
								<div class="congestion" title="혼잡도">
									<label id="congestion">혼잡</label>
								</div>
								<div class="stars_reviw">
									<span class="ico-star1">★ 4.8</span> <span class="break-line">
										| </span> <span class="reviw-num">리뷰 2건</span>
								</div>
								<div class="choice">
									<a href="#;" class="store_choice">선택</a>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>

			<br>
		</div>

		<div class="Number">
			<span> <a href="#;" class="page_Number">1</a>
			</span> <span> <a href="#;" class="page_Number">2</a>
			</span> <span> <a href="#;" class="page_Number">3</a>
			</span> <span> <a href="#;" class="page_Number">4</a>
			</span> <span> <a href="#;" class="page_Number">5</a>
			</span>
		</div>

		<br>

		<!-- footer -->
		<jsp:include page="/WEB-INF/views/common/customer/footer.jsp" />

	</center>

</body>
</html>