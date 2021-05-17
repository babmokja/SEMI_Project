<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoB</title>
<link rel="stylesheet" href="resources/css/customer/main.css">
<link href="resources/css/customer/reset.css" type="text/css" rel="stylesheet">
<link href="resources/css/customer/common_ah.css" type="text/css" rel="stylesheet">
</head>
<body>
	<!-- 헤더 영역 -->
			<header>
			<div class="head">
				<div class="right">
					<div>
						<a href="${ pageContext.servletContext.contextPath }" class="logo">babmokja</a>
					</div>
					<div class="sq">
						<div class="join">
							<a href="#;" class="join_icon">회원가입</a>
							<c:if test="${ empty sessionScope }"></c:if>
						</div>
						<div class="logout">
							<a href="#;" class="logout_icon">로그아웃</a>
						</div>
						<div class="login">
							<a href="#;" class="login_icon">로그인</a>
						</div>
						<div class="mypage">
							<a href="#;" class="mypage_icon">
							<img src="resources/image/customer/user.png" alt="이미지없음"></a>
						</div>
					</div>
				</div>
				<div>
					<a href="${ pageContext.servletContext.contextPath }" class="title">너의 밥먹는건 우리가 책임진다</a>
				</div>
				<div class="searchbox">
					<a href="#;"> <img src="resources/image/customer/magnifying.png" alt="이미지없음"
						id="icon">
					</a> <input type="text" class="searchpoint">
				</div>
				<div class="nav">
					<span> <a href="${ pageContext.servletContext.contextPath }/" class="a"
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

</body>
</html>