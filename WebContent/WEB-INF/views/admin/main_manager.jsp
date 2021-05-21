<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 메인 사이트</title>
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/reset.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/common.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/button.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/main_manager.css">
</head>
<body>


        <div class="header">
            <span>babmokja</span>
            <p>관리자 사이트</p>
        </div>

        <div class="wrap">
            <div class="main_menu">
            <c:if test="${ !empty sessionScope.loginAdmin }">
                <li><a href="${pageContext.servletContext.contextPath}/admin/order"><img src="/SEMI_Project/resources/image/admin/주문확인.png" alt="주문확인">주문확인</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/customer"><img src="/SEMI_Project/resources/image/admin/고객관리.png" alt="고객관리">고객관리</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/owner"><img src="/SEMI_Project/resources/image/admin/내정보관리.png" alt="내정보관리">업소관리</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/customer/board"><img src="/SEMI_Project/resources/image/admin/리뷰관리.png" alt="리뷰관리">게시판</a></li>
            </div>
            

            <div class="side_word">
                <div class="word1">배달,픽업,자리예약까지 한번에!</div>
                <div class="word2">강남지역 주문 플랫폼</div>
                <div class="word3">밥묵자</div>
            </div>
            </c:if>
        <!-- 로그인 영역 -->
            
        <!-- 로그인이 필요한 경우 -->
		<c:if test="${ empty sessionScope.loginAdmin }">
			
			<form id ="loginForm" action="${ pageContext.servletContext.contextPath }/admin/login" method="post" style="width: auto;height: auto;">
             <div class="login">
			
                <input type="text" class="id" placeholder="아이디를 입력해주세요" name="adminId"><br>
                <input type="password" class="pw" placeholder="비밀번호를 입력해주세요" name="adminPwd"><br>

                <button type="submit" id="login_btn">로그인</button>
            </div>
			</form>
		</c:if>
		<div class="login">
		<!-- 로그인 되어 있는 경우 -->
		<c:if test="${ !empty sessionScope.loginAdmin }">
				<h3><c:out value="${ sessionScope.loginAdmin.id }"/>님의 방문을 환영합니다.</h3>
				
		</c:if>
        </div>
        </div>


</body>
</html>