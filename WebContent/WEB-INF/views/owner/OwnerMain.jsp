<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사장님 사이트</title>
	<link rel="stylesheet" href="resource/css/owner/reset_jh.css">
    <link rel="stylesheet" href="resource/css/owner/common_js.css">
    <link rel="stylesheet" href="resource/css/owner/button_js.css">
    <link rel="stylesheet" href="resource/css/owner/main_store_jh.css">
    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
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
                <li><a href="../../semi_board_sales/company/order.html"><img src="../image/주문확인.png" alt="주문확인">주문확인</a></li>
                <li><a href="../../semi_board/company/modifyInfo_owner.html"><img src="../image/내정보관리.png" alt="내정보관리">내 정보관리</a></li>
                <li><a href="../../semi_board_sales/company/Owner_Sales_day_Board.html"><img src="../image/내업소관리.png" alt="내업소관리">내 업소관리</a></li>
                <li><a href="./delivery.html"><img src="../image/PC주문관리.png" alt="PC주문관리">PC 주문관리</a></li>
                <li><a href="../../semi_board/company/Owner_Comment_Board.html"><img src="../image/리뷰관리.png" alt="리뷰관리">리뷰관리</a></li>
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
                    <li><a href="../../semi_board/company/signin_owner.html">회원가입</a></li>
                </div>

            </div>
        
        </div>

    



</body>
</html>