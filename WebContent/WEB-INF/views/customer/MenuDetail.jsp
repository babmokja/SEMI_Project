<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BoB</title>
	<link href="resources/css/customer/button.css" type="text/css" rel="stylesheet">
	<link href="resources/css/customer/common.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/customer/main.css">
	<link rel="stylesheet" href="resources/css/customer/menu.css">
	<link href="resources/css/customer/reset2.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/customer/reservationCopy.css">
    <script type="text/javascript" src="resources/js/customer/menu.js"></script>
    <script type="text/javascript" src="resources/js/customer/select.js"></script>
    <script type="text/javascript" src="resources/js/customer/reservation.js"></script>
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
                        <a href="#;" class="mypage_icon"><img src="resources/image/customer/user.png" alt="이미지없음"></a>
                    </div>
                </div>
            </div>
            <div>
                <a href="#;" class="title">너의 밥먹는건 우리가 책임진다</a>
            </div>
            <div class="searchbox">
                <a href="#;">
                    <img src="resources/image/customer/magnifying.png" alt="이미지없음" id="icon">
                </a>
                <input type="text" class="searchpoint">
            </div>
            <div class="nav">
                <span>
                    <a href="#;" class="a" id="kor">한식</a>
                </span>
                <span>
                    <a href="#;" class="a" id="fra">프랜차이즈</a>
                </span>
                <span>
                    <a href="#;" class="a" id="chi">중식</a>
                </span>
                <span>
                    <a href="#;" class="a" id="jap">일식</a>
                </span>
                <span>
                    <a href="#;" class="a" id="ame">양식</a>
                </span>
            </div>
        </div>
    </header>
</center>
            
        <div id="main">

            <div class="eatselect">
                <div class="bp">배달/픽업</div>
                <div class="or">예약</div>
                <p class="menupan">메뉴판</p>
            </div>

            <div class="section">
                <table>
                    <caption style="font-size: 35px;">주문표</caption>

                    <tbody id="maketable">
                    </tbody>

                    <tr>
                        <td class="emp"> </td>
                        <td class="emp"> </td>
                        <td class="emp"> </td>
                        <td class="emp"> </td>

                    </tr>
                    <tr>
                        <td colspan="2">총 금액</td>
                        <td id="allprice" colspan="2"></td>
                    </tr>
                    <tr>
                        <td class="emp"> </td>
                        <td class="emp"> </td>
                        <td class="emp"> </td>
                        <td class="emp"> </td>
                    </tr>
                    <tr>
                        <td colspan="4" class="execute"><button type="button2" class="button2" onclick="ReservePopUp2();">주문하기</button></td>
                    </tr>
                    
                </table>
            </div>
            
            <div class="allsection">
                <div class="section1">
                    <div class="pic"><img src="" alt=""></div>
                    <div class="menu1"><label id="menu01">특오겹살 (200g)</label></div>
                    <div class="price1"><label id="price01">16,000원</label></div>
                    <button class="cancel" onclick="del1();">취소</button>
                    <button class="damgi" onclick="PopUp1();">담기</button>
                </div>

                <div class="section1">
                    <div class="pic"><img src="" alt=""></div>
                    <div class="menu2"><label id="menu02">특삼겹살 (200g)</label></div>
                    <div class="price2"><label id="price02">13,000원</label></div>
                    <button class="cancel" onclick="del2();">취소</button>
                    <button class="damgi" onclick="PopUp2();">담기</button>
                </div>

                <div class="section1">
                    <div class="pic"><img src="" alt=""></div>
                    <div class="menu3"><label id="menu03">곱창 (200g)</label></div>
                    <div class="price1"><label id="price03">10,000원</label></div>
                    <button class="cancel" onclick="del3();">취소</button>
                    <button class="damgi" onclick="PopUp3();">담기</button>
                </div>
            </div>
        </div>

        <center>
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

 <!-- ------------------------------------------------- -->
 <div class="bg"></div>
 <div class="medal">
     <div class="reservewrap">
         <img src="resources/image/customer/store.jpg" alt="" class="pict">

         <div class="section1">
             <div class="part1">
                 <div class="time"></div>
                 <div class="db1"> </div>
             </div>
             <div class="line"> </div>
             <div class="part1">
                 <div class="time">시간</div>
                 <div class="dbTime"><label id="setT">시간을 선택해주세요</label></div>
             </div>
             <div class="line"> </div>
             <div class="part1">
                 <div class="time">오전</div>
                 <button class="dbt"><label id="t1" onclick="setTime1();" class="menuTablecall_td">바로 주문하기</label></button>
             </div>
             <div class="line"></div>

             <div class="part4">
                 <div class="time">오후</div>
                 <table class="table">
                     <tr>
                         <td><label id="t2" onclick="setTime2();" class="menuTable_td">13:00</label></td>
                         <td><label id="t3" onclick="setTime3();" class="menuTable_td">14:00</label></td>
                         <td><label id="t4" onclick="setTime4();" class="menuTable_td">15:00</label></td>
                     </tr>
                     <tr>
                         <td><label id="t5" onclick="setTime5();" class="menuTable_td">16:00</label></td>
                         <td><label id="t6" onclick="setTime6();" class="menuTable_td">17:00</label></td>
                         <td><label id="t7" onclick="setTime7();" class="menuTable_td">18:00</label></td>
                     </tr>
                     <tr>
                         <td><label id="t8" onclick="setTime8();" class="menuTable_td">19:00</label></td>
                         <td><label id="t9" onclick="setTime9();" class="menuTable_td">20:00</label></td>
                         <td><label id="t10" onclick="setTime10();" class="menuTable_td">21:00</label></td>
                     </tr>

                 </table>
             </div>
         </div>

         <div class="section2">
             <div class="part1">
                 <div class="time"> </div>
             </div>
             <div class="info">
                 <div class="infot">사용자 정보</div>
                 <div class="reservation-part1">
                     <div class="time1">사용자명</div>
                     <div class="db2">황준호</div>
                 </div>
                 <div class="reservation-part1">
                     <div class="time1">연락처</div>
                     <div class="db2">010 - 1234 - 5678</div>
                 </div>
                 <div class="reservation-part1">
                     <div class="time1">이메일</div>
                     <div class="db2">sdfjss@naver.com</div>
                 </div>
                 <div class="party">
                     <div class="timey">요청사항</div>
                     <textarea type="text" class="db88" cols="30" rows="10" style="resize: none;"></textarea>
                 </div>

             </div>
         </div>
         <div class="section3">
             <<span>알립니다!</span>
             <br>
             <br>
             픽업예약 후 사정상 못오실경우<br>
             <span>사장님께 전화</span> 꼭 부탁드립니다.
             <br>
             <br>
             바로 주문하기 후 동시간대 손님이 몰릴경우 음식이<br>
             <span>다소 늦게 나오는점</span> 미리 양해 말씀드립니다.
         </div>
         <div class="section4">
             <div class="bt1" onclick="reservePopup();">취소</div>
             <button class="bt2" onclick="location.href='#;'">픽업주문</button>
         </div>

     </div>
 </div>

    <div class="bg"></div>
    <div class="menuwrap">
        <div class="top">메뉴 상세</div>
        <img src="resources/image/customer/meat.jpg" alt="" class="pict">
        <div class="menuname">특오겹살(200g)</div>
        <div class="section1">
            &nbsp;&nbsp; 가격 : <div class="price">16000원</div>
        </div>
        <div class="about">이 고기는 참맛있어요</div>
        <div class="section2">
            &nbsp;&nbsp; 수량 : <input type="text" class="spinner" value="1">
        </div>
        <div class="section3">
           &nbsp;&nbsp; 총 주문금액 : <div class="allprice">100000원</div>
        </div>
        <div class="add" onclick="cancel1();">취소</div>
        <div class="order" onclick="makeTable1();">주문표에 추가</div>
    </div>

    <div class="bg2"></div>
    <div class="menuwrap2">
        <div class="top">메뉴 상세</div>
        <img src="images/meat.jpg" alt="" class="pict">
        <div class="menuname">특삼겹살(200g)</div>
        <div class="section1">
            &nbsp;&nbsp; 가격 : <div class="price">10000원</div>
        </div>
        <div class="about">이 고기는 참맛있어요</div>
        <div class="section2">
            &nbsp;&nbsp; 수량 : <input type="text" class="spinner2" value="1">
        </div>
        <div class="section3">
           &nbsp;&nbsp; 총 주문금액 : <div class="allprice">100000원</div>
        </div>
        <div class="add" onclick="cancel2();">취소</div>
        <div class="order" onclick="makeTable2();">주문표에 추가</div>
    </div>

    <div class="bg3"></div>
    <div class="menuwrap3">
        <div class="top">메뉴 상세</div>
        <img src="images/meat.jpg" alt="" class="pict">
        <div class="menuname">곱창(200g)</div>
        <div class="section1">
            &nbsp;&nbsp; 가격 : <div class="price">10000원</div>
        </div>
        <div class="about">이 고기는 참맛있어요</div>
        <div class="section2">
            &nbsp;&nbsp; 수량 : <input type="text" class="spinner3" value="1">
        </div>
        <div class="section3">
           &nbsp;&nbsp; 총 주문금액 : <div class="allprice">100000원</div>
        </div>
        <div class="add" onclick="cancel3();">취소</div>
        <div class="order" onclick="makeTable3();">주문표에 추가</div>
    </div>

</body>
</html>