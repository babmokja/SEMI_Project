<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoB</title>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/main.css">
<link href="${ pageContext.servletContext.contextPath }/resources/css/customer/reset.css" type="text/css"
	rel="stylesheet">
<link href="${ pageContext.servletContext.contextPath }/resources/css/customer/common_ah.css" type="text/css"
	rel="stylesheet">
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

					<!-- 로그인이 필요한 경우 -->
					<c:if test="${ empty sessionScope.loginMember }">

						<!-- 로그인 폼 -->
						<form id="loginForm"
							action="${ pageContext.servletContext.contextPath }/customer/login"
							method="post">
							<div class="btns" align="right">
								<div class="join">
									<a href="#;" class="join_icon">회원가입</a>
								</div>
								<div class="login">
									<a href="#;" class="login_icon">로그인</a>
								</div>
							</div>
						</form>

					</c:if>

					<c:if test="${ !empty sessionScope.loginMember }">
						<!-- 로그인 되어 있는 경우 -->
						<div class="btns">
							<div class="mypage">
								<a href="#;" class="mypage_icon"> 
									<img src="${ pageContext.servletContext.contextPath }/resources/image/customer/user.png" alt="이미지없음">
								</a>
							</div>
							<div class="logout">
								<a href="#;" class="logout_icon">로그아웃</a>
							</div>
						</div>
					</c:if>
					
				</div>
			</div>
			
			<div>
				<a href="${ pageContext.servletContext.contextPath }" class="title">너의
					밥먹는건 우리가 책임진다</a>
			</div>
			<div class="searchbox">
				<a href="${ pageContext.servletContext.contextPath }/store/list">
					<img src="${ pageContext.servletContext.contextPath }/resources/image/customer/magnifying.png" alt="이미지없음"
					id="icon">
				</a> <input type="text" class="searchpoint">
			</div>
			<div class="nav">
				<span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=kor&type=1&order=congestion&currentPage=1"
					class="a" id="kor">한식</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=fra&type=1&order=congestion&currentPage=1"
					class="a" id="fra">프랜차이즈</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=chi&type=1&order=congestion&currentPage=1"
					class="a" id="chi">중식</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=jap&type=1&order=congestion&currentPage=1"
					class="a" id="jap">일식</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=ame&type=1&order=congestion&currentPage=1"
					class="a" id="ame">양식</a>
				</span>
			</div>
		</div>
	</header>

</body>
</html>