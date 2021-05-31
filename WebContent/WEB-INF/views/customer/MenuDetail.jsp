<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>BoB</title>
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/button.css"
	type="text/css" rel="stylesheet">
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/common.css"
	type="text/css" rel="stylesheet">
<link rel="stylesheet"
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/main.css">
<link rel="stylesheet"
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/menu.css">
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/reset2.css"
	type="text/css" rel="stylesheet">
<link rel="stylesheet"
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/reservationCopy.css">
<script type="text/javascript"
	src="${ pageContext.servletContext.contextPath }/resources/js/customer/menu.js"></script>
<script type="text/javascript"
	src="${ pageContext.servletContext.contextPath }/resources/js/customer/reservation.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
//페이지 이동
function checkAndMove(value) {

	var container = document.getElementById("bt2");

	if (value == 1) {
	
		console.log(value);
	
		container.disabled = false;
		
		value = 0;
		
	} else if (value == 0) {
	    var reserveMenu = document.getElementsByClassName("maketable")[0];
	    
	    var data1 = [];
	    
	    var check = 0;
	    var check1 = 1;
	    for(var i = 0; i < document.getElementsByClassName("maketable")[0].childNodes.length/2; i++){
	    	var menuCode = document.getElementsByClassName("maketable")[0].childNodes[check1].children[4].innerText;
	    	var menuName = document.getElementsByClassName("maketable")[0].childNodes[check].children[0].innerText;
	    	var amount = document.getElementsByClassName("maketable")[0].childNodes[check1].children[3].innerText;
	    	var price = document.getElementsByClassName("maketable")[0].childNodes[check1].children[1].innerText;
	    	var storeCode = document.getElementsByClassName("storeId")[0].innerText;
	    	var reServeTime = document.getElementById("setT").innerText;
	    	
	    	var total = {
	    		menuCode : menuCode,
	    		menuName : menuName,
	    		amount : amount,
	    		price : price,
	    		storeCode : storeCode,
	    		reServeTime : reServeTime,
	    	}
	    	
	    	check+=2;
	    	check1+=2;
	    	
	    	data1.push(total);
	    }
	    
	    const jsonString = JSON.stringify(data1);
	 
	    var root = "${ pageContext.servletContext.contextPath }";
	    $.ajax({
	    	url: root+"/order/pay",
	    	type:"post",
	    	data: {jsonString},
	    	success:function(data,statusText, xhr){
	    		console.log(data);
	    		var code = data.split(',')[1];
	    		location.href = root+'/order/select?code='+code;
	    	},
	    	error:function(xhr,status,error){
	    		console.log(error);
	    		location.href = root+"/WEB-INF/views/common/customer/failed.jsp";
	    	}
	    });
		
	}
}
</script>
</head>

<body>
	<center>
		<!-- header -->
		<jsp:include page="/WEB-INF/views/common/customer/header.jsp" />
	</center>

	<!-- body -->
	<div id="main">

		<div class="eatselect">
			<p class="menupan">메뉴판</p>
		</div>

		<div class="section">
			<table>
				<caption style="font-size: 35px;">주문표</caption>
				<tbody class="maketable"></tbody>
				<tr>
					<td class="emp"></td>
					<td class="emp"></td>
					<td class="emp"></td>
					<td class="emp"></td>
				</tr>
				<tr style="line-height: 3;">
					<td colspan="2">총 금액</td>
					<td id="allprice" colspan="2" name="totalPay"></td>
				</tr>
				<tr>
					<td class="emp"></td>
					<td class="emp"></td>
					<td class="emp"></td>
					<td class="emp"></td>
				</tr>
				<tr>
					<td colspan="4" class="execute">
						<!-- 로그인 되어 있지 않은 경우 --> <!-- !없어야함 --> 
						<!-- 로그인 되어 있는 경우 --> <!-- !있어야함 --> 
						<c:if test="${ !empty sessionScope.loginUser }">
							<button type="button2" class="button2" onclick="reservePopUp(this);">주문하기</button>
						</c:if>

					</td>
				</tr>

			</table>
		</div>

		<c:forEach var="menuInfo" items="${ requestScope.selectMenu }" varStatus="status">
			<!-- 리스트 -->
			<div class="allsection">
				<div class="section1">
					<div class="pic">
						<img src="${ menuInfo.photo }" alt="">
					</div>
					<div class="menu1">
						<label class="menu01"><c:out value="${ menuInfo.name }"></c:out></label>
					</div>
					<div class="price1">
						<label class="price01"><c:out value="${ menuInfo.price }"></c:out>원</label>
					</div>
					<div class="storeId" style="display: none;"><c:out value="${ menuInfo.storeId }"></c:out></div>
					<button class="cancel" onclick="del1(this);">취소</button>
					<button class="damgi" id="damgi" onclick="PopUp1(this);">담기</button>
				</div>
			</div>

			<!-- 담기 모달 -->
			<div class="bg"></div>
			<div class="menuwrap">
				<div class="top">메뉴 상세</div>
				<img src="${ menuInfo.photo }" alt="" class="pict">

				<div class="menuname">
					<c:out value="${ menuInfo.name }"></c:out>
				</div>
				<div class="section1">
					&nbsp;&nbsp;&nbsp;&nbsp;
					가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;격 :
					<div class="price">
						<c:out value="${ menuInfo.price }"></c:out>
						원
					</div>
				</div>
				<div class="about">
					<c:out value="${ menuInfo.content }"></c:out>
				</div>
				<div class="section2">
					&nbsp;&nbsp;&nbsp;&nbsp;
					수&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;량 : <input
						type="text" class="spinner" value="1">
				</div>
				<div class="menuCode" style="display: none;"><c:out value="${ menuInfo.menuCode }"></c:out></div>
				<div class="storeId" style="display: none;"><c:out value="${ menuInfo.storeId }"></c:out></div>
				<div class="add" onclick="cancel1(this);">취소</div>
				<div class="order" onclick="makeTable1(this);">주문표에 추가</div>
			</div>

		</c:forEach>
	</div>

	<center>
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/common/customer/footer.jsp" />
	</center>

	<!-- ---------------------주문모달----------------------- -->
	<div class="bg"></div>
	<div class="medal">
		<div class="reservewrap">
			<div class="section1">
				<div class="part1">
					<div class="time"></div>
					<div class="db1"></div>
				</div>
				<div class="line"></div>
				<div class="part1">
					<div class="time">시간</div>
					<div class="dbTime">
						<label id="setT">시간을 선택해주세요</label>
					</div>
				</div>
				<div class="line"></div>
				<div class="part1">
					<div class="time">오전</div>
					<button class="dbt">
						<label id="t1" onclick="setTime1();" class="menuTablecall_td">바로
							주문하기</label>
					</button>
				</div>
				<div class="line"></div>

				<div class="part4">
					<div class="time">오후</div>
					<table class="table">
						<tr>
							<td><label id="t2" onclick="setTime2();"
								class="menuTable_td">13:00</label></td>
							<td><label id="t3" onclick="setTime3();"
								class="menuTable_td">14:00</label></td>
							<td><label id="t4" onclick="setTime4();"
								class="menuTable_td">15:00</label></td>
						</tr>
						<tr>
							<td><label id="t5" onclick="setTime5();"
								class="menuTable_td">16:00</label></td>
							<td><label id="t6" onclick="setTime6();"
								class="menuTable_td">17:00</label></td>
							<td><label id="t7" onclick="setTime7();"
								class="menuTable_td">18:00</label></td>
						</tr>
						<tr>
							<td><label id="t8" onclick="setTime8();"
								class="menuTable_td">19:00</label></td>
							<td><label id="t9" onclick="setTime9();"
								class="menuTable_td">20:00</label></td>
							<td><label id="t10" onclick="setTime10();"
								class="menuTable_td">21:00</label></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="section3">
				<span>알립니다!</span> <br> <br> 바로 결제를 제외한 예약일 때 취소의 경우<br>
				<span>사장님께 전화</span> 꼭 부탁드립니다. <br> <br> 바로 주문하기 후 동시간대
				손님이 몰릴경우 음식이<br> <span>다소 늦게 나오는점</span> 미리 양해 말씀드립니다.
			</div>
			<div class="section4">
				<div class="bt1" onclick="reservePopup(this);">취소</div>
				<button class="bt2" id="bt2" disabled="disabled"
					onclick="checkAndMove(0);">주문</button>
			</div>

		</div>
	</div>

</body>
</html>