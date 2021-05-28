<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>BoB</title>
<link rel="stylesheet"
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/main.css">
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/reset2.css"
	type="text/css" rel="stylesheet">
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/button.css"
	type="text/css" rel="stylesheet">
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/common_ah.css"
	type="text/css" rel="stylesheet">
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/select.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="${ pageContext.servletContext.contextPath }/resources/js/customer/select.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3da12a7b5e4b9173c9bc28498213744b&libraries=services"></script>
<script>
function mapInfo() {
	
	const address = "${ requestScope.selectedInfo.address }";
	
	kakao_api(address);
}

function kakao_api(address){
	
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(33.450701, 126.570667),
		level: 3
	};

	var map = new kakao.maps.Map(container, options);
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다	
	geocoder.addressSearch(address, function(result, status) {

		// 정상적으로 검색이 완료됐으면 
			if (status === kakao.maps.services.Status.OK) {

			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			// 결과값으로 받은 위치를 마커로 표시합니다
			var marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});

			// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			map.setCenter(coords);
		} 
	});
}
</script>
</head>

<body onload="mapInfo();">
	<center>
		<!-- header -->
		<jsp:include page="/WEB-INF/views/common/customer/header.jsp" />
	</center>
	
	<!-- body -->
	<div id="selectwrap">
		<div id="main">
			<div class="wrap">
				<div class="section1">
				
					<!-- 가게가 가지고 있는 대표 사진의 개수만큼 반복 시행 -->
					<!-- 가게 코드를 기준으로 사진 정보를 담은 리스트를 가져온다 -->
					<!-- 1가게 : 4사진 -->
					<c:forEach var="storeimg" items="${ requestScope.selectedPhoto }">
						<div class="pic"><img src="${ storeimg.photo }"></div>
					</c:forEach>
				</div>
				<div class="section2">
					<div class="section3">
						<div class="house">
							<div class="name">
								<c:out value="${ requestScope.selectedInfo.storeName }" />
							</div>
							<div class="score">
								<c:out value="${ requestScope.selectedInfo.star }" />
							</div>
						</div>
						<div class="pic1">
							주소 : <c:out value="${ requestScope.selectedInfo.address }" />
						</div>
						<div class="pic1">
							전화번호 : <c:out value="${ requestScope.selectedInfo.phone }" />
						</div>
						<div class="pic1">
							카테고리 : <c:out value="${ requestScope.selectedInfo.cate }" />
						</div>
						<br>
						<hr>
						<br>
						<div class="pic2">식당 소개</div>
						<br>
						<div class="pic1">
							<c:out value="${ requestScope.selectedInfo.detailInto }" />
						</div>
						<br> <br> <br> <br>
					</div>
					<div id="map"></div>
				</div>
			</div>

			<div class="buttonwrap">
				<button type="button" class="button1">
					<a href="${ pageContext.servletContext.contextPath }/menu/list?storeId=${ requestScope.storeId }">메뉴판</a>
				</button>
			</div>

			<div class="emot">
				<div class="emoticon">
					<img src="${ pageContext.servletContext.contextPath }/resources/image/customer/goodgood.png" alt=""> 
					<img src="${ pageContext.servletContext.contextPath }/resources/image/customer/good.png" alt=""> 
					<img src="${ pageContext.servletContext.contextPath }/resources/image/customer/notgood.png" alt="">
				</div>
				<div class="icon">
					<img src="" alt="">
				</div>
				<div class="emodesc">&nbsp;&nbsp;맛있다(<c:out value="${ requestScope.selectedReviewCnt.bestReviewCnt }"/>) &nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;&nbsp;
					괜찮다(<c:out value="${ requestScope.selectedReviewCnt.goodReviewCnt }" />) &nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;&nbsp; 별로(<c:out value="${ requestScope.selectedReviewCnt.badReviewCnt }" />)
				</div>
			</div>

			<!-- 리뷰의 개수 만큼 반복문 시행 -->
			<!-- 가게 코드를 기준으로 리뷰 정보를 담은 리스트를 가져온다 -->
			<!-- 1리뷰 : 1리뷰사진 -->
			<c:forEach var="reviewinfo" items="${ requestScope.selectedReview }" varStatus="status">
				<div class="section4">
					<div class="review">
						<div class="line"></div>
						<div class="profile">
							<div class="user">
								<c:choose> 
									<c:when test="${ reviewinfo.satisfied eq 1}">
										<img alt="" src="${ pageContext.servletContext.contextPath }/resources/image/customer/goodgood.png" id="user_satisfied_Img">
									</c:when>
									
									<c:when test="${ reviewinfo.satisfied eq 2}">
										<img alt="" src="${ pageContext.servletContext.contextPath }/resources/image/customer/good.png" id="user_satisfied_Img">
									</c:when>
									
									<c:otherwise>
										<img alt="" src="${ pageContext.servletContext.contextPath }/resources/image/customer/notgood.png" id="user_satisfied_Img">
									</c:otherwise>
								</c:choose>
							</div>
							<div class="uname"><c:out value="${ reviewinfo.reviewId }" /></div>
						</div>
						<div class="desc"><c:out value="${ reviewinfo.review }" /></div>
						<div class="preview">
							<img src="${ reviewinfo.photo }">
						</div>
					</div>
					<div class="line"></div>
				</div>
			</c:forEach>
			
		</div>
	</div>
	
	<center>
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/common/customer/footer.jsp" />
	</center>
</body>

</html>