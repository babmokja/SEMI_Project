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
<link href="resources/css/customer/customer_main.css" type="text/css"
	rel="stylesheet">
</head>
<body>
	<center>

		<!-- header -->
		<jsp:include page="/WEB-INF/views/common/customer/header.jsp" />
		
		<!-- body -->
		<br> <br>
		<div class="cate_list">
			<div class="cate_first">
				<div class="cate">
					<a href="#;" class="cate"> <img id="cate_detail"
						src="resources/image/customer/kor.PNG" alt="이미지 없음">
					</a>
				</div>
				<div class="cate">
					<a href="#;" class="cate"> <img id="cate_detail"
						src="resources/image/customer/fran.PNG" alt="이미지 없음">
					</a>
				</div>
				<div class="cate">
					<a href="#;" class="cate"> <img id="cate_detail"
						src="resources/image/customer/chi.PNG" alt="이미지 없음">
					</a>
				</div>
			</div>
			<div class="cate_second">
				<div class="cate">
					<a href="#;" class="cate"> <img id="cate_detail"
						src="resources/image/customer/jap.PNG" alt="이미지 없음">
					</a>
				</div>
				<div class="cate">
					<a href="#;" class="cate"> <img id="cate_detail"
						src="resources/image/customer/ame.PNG" alt="이미지 없음">
					</a>
				</div>
			</div>
		</div>
		<br>

		<!-- footer -->
		<jsp:include page="/WEB-INF/views/common/customer/footer.jsp" />

	</center>

</body>
</html>