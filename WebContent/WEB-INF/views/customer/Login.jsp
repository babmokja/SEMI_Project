<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
        <link rel="stylesheet" href="resources/css/customer/main.css">
        <link href="resources/css/customer/reset.css" type="text/css" rel="stylesheet">
        <link href="resources/css/customer/button.css" type="text/css" rel="stylesheet">
        <link href="resources/css/customer/common_ah.css" type="text/css" rel="stylesheet">
        <link href="resources/css/customer/login.css" type="text/css" rel="stylesheet">
</head>
   <body>
        <center>
        <!-- 헤더 -->
		<jsp:include page="/WEB-INF/views/common/customer/header.jsp" />

            <div class="body">
              <c:if test="${ empty sessionScope.loginMember }">

                <img src="resources/image/customer/eating_people.PNG" alt="이미지없음" id="eating_people">
                 <form id="loginForm" action="${ pageContext.servletContext.contextPath }/user/login" method="post">
                  <div class="result">
                    <div class="id">
                        <input type="text" class="id" placeholder="     UserID" name="userId">
                    </div>
                    <div class="pwd">
                        <input type="text" class="pwd" placeholder="     Password" name="userPwd">
                    </div>
                    <div class="btn">
                        <input type="submit" class="login_btn" value="Login">Login</a>
                    </div>
                  </form>   
                </c:if>    
                    
                    <div class="owner">
                        <a href="#;" class="owner_login">사장님 페이지로 이동</a>
                    </div>  
                <div class="manager">
                    <a href="#;" class="manager_login">관리자 로그인 바로가기</a>
                </div>
            </div>

            <br>

            <footer>
                <div class="foot">
                    <small>
                        <br>㈜ 지금 배고프조<br><br>
                        서울특별시 강남구 강남동 000, 타워 5층 | 사업자 등록번호: 000-00-00000 [사업자정보확인]<br>
                        통신판매업 신고번호: 2021-서울강남-04026 | 개인정보 담당자 : babmokja@babmokja.co.kr | 제휴문의 :
                        babmokja@babmokja.co.kr | 고객 만족센터 : babmokja@babmokja.co.kr<br><br>

                        (유)지금 배고프조는 통신판매중개자이며 통신판매의 당사자가 아닙니다. <br> 따라서 상품/ 거래정보 및 거래와 관련하여 밥먹자에 등록된 판매자의 고의
                        또는 과실로 소비자에게 발생하는 손해에 대해 (유)지금 배고프조는 책임을 지지 않습니다.<br>
                        상품 및 거래에 관하여 보다 정확한 정보는 해당 판매자에게 직접 확인하여 주시기 바랍니다. Copyright BABMOKJA. All
                        Rights Reserved.<br><br>

                        고객센터: 02-123-4567 (24시간, 연중무휴)
                        <br>
                        <address>
                            Copyright &copy; BABMOKJA All Right Reserved.</address>
                    </small>
                </div>
            </footer>
        </center>


</body>
</html>