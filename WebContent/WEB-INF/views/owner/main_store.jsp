<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사장님 메인 사이트</title>
    <link rel="stylesheet" href="resources/css/owner/semi_store_css/reset.css">
    <link rel="stylesheet" href="resources/css/owner/semi_store_css/common.css">
    <link rel="stylesheet" href="resources/css/owner/semi_store_css/button.css">
    <link rel="stylesheet" href="resources/css/owner/semi_store_css/main_store.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

	<div class="header">
            <span>babmokja</span>
            <li id="qus_btn"><a href="../../semi_board/company/Owner_Seggestion_Board.html">1대1 문의하기</a></li>
            <li id="info_enroll"><a href="../../semi_board/company/sign_up_info.html"> 입점 안내</a></li>
            <p>사장님 사이트</p>
        </div>

        <div class="wrap">
            <div class="main_menu">
                <li><a href="#;"><img src="resources/images/semi_store_image/주문확인.png" alt="주문확인">주문확인</a></li>
                <li><a href="../../semi_board/company/modifyInfo_owner.html"><img src="resources/image/owner/semi_store_image/내정보관리.png" alt="내정보관리">내 정보관리</a></li>
                <li><a href="../../semi_board_sales/company/Owner_Sales_day_Board.html"><img src="resources/image/owner/semi_store_image/내업소관리.png" alt="내업소관리">내 업소관리</a></li>
                <li><a href="./delivery.html"><img src="resources/image/owner/semi_store_image/PC주문관리.png" alt="PC주문관리">PC 주문관리</a></li>
                <li><a href="../../semi_board/company/Owner_Comment_Board.html"><img src="resources/image/owner/semi_store_image/리뷰관리.png" alt="리뷰관리">리뷰관리</a></li>
            </div>

            <div class="side_word">
                <div class="word1">배달,픽업,자리예약까지 한번에!</div>
                <div class="word2">강남지역 주문 플랫폼</div>
                <div class="word3">밥묵자</div>
            </div>

            <div class="login">
                <input type="text" class="id" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;아이디를 입력해주세요"><br>
                <input type="text" class="pw" placeholder="&nbsp;&nbsp;&nbsp;비밀번호를 입력해주세요"><br>

                <button type="submit" id="login_btn">로그인</button>
                <div class="sign_up_btn">
                    <li><a href="${ pageContext.servletContext.contextPath }/member/owner/regist">회원가입</a></li>
                </div>

            </div>
        
        </div>

       <script>

           $(document).ready(function(){
               $('.header#info_enroll').click(function(){
                    alert("로그인 후 이용해주세요!");
               });
           });
       </script>
	

</body>
</html>