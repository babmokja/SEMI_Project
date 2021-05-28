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
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/reset.css"
	type="text/css" rel="stylesheet">
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/button.css"
	type="text/css" rel="stylesheet">
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/common_ah.css"
	type="text/css" rel="stylesheet">
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/customer/store_list.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3da12a7b5e4b9173c9bc28498213744b&libraries=services"></script>
<script>
function pagePickUp(){
	const root_url = "${ pageContext.servletContext.contextPath }/store/list";
	const url = new URL(document.URL);
	const urlType = "&type=1";
	
	const urlCate = url.searchParams.get("cate");
	const urlOrder = url.searchParams.get("order");
	const urlCurPage = url.searchParams.get("currentPage");
	
	var move_url = root_url + "?cate=" + urlCate + urlType + "&order=" + urlOrder + "&currentPage=" + urlCurPage;
	
	location.href = move_url;
}

function pageDeliver(){
	const root_url = "${ pageContext.servletContext.contextPath }/store/list";
	const url = new URL(document.URL);
	const urlType = "&type=2";
	
	const urlCate = url.searchParams.get("cate");
	const urlOrder = url.searchParams.get("order");
	const urlCurPage = url.searchParams.get("currentPage");
	
	var move_url = root_url + "?cate=" + urlCate + urlType + "&order=" + urlOrder + "&currentPage=" + urlCurPage;
	
	location.href = move_url;
}

function init(){
	const url = new URL(document.URL);
	var pick = document.getElementById("btn_pickUp");
	var deliver = document.getElementById("btn_deliver");
	
	const selectedType = url.searchParams.get("type");
	
	if(selectedType == "1"){

		// 픽업 버튼에 선택 css 추가
		pick.classList.add("on");
		// 배달 버튼에 선택 안됨 css 추가
		deliver.classList.add("off");
	}
	else if(selectedType == "2"){

		// 픽업 버튼에 선택 안됨 css 추가
		pick.classList.add("off");
		// 배달 버튼에 선택 css 추가
		deliver.classList.add("on");
	}
}

function click_rest(id){
	const tr = document.getElementById(id);
	const tr_address = document.getElementById("name_" + id);
	const address = tr_address.innerHTML ;
	
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

function orderChange(order){
	
	const root_url = "${ pageContext.servletContext.contextPath }/store/list";
	const url = new URL(document.URL);
	
	const urlCate = url.searchParams.get("cate");
	const urlType = url.searchParams.get("type");
	
	if(order.selectedIndex == 1) {
		var urlOrder = "&order=congestion"
	} else if(order.selectedIndex == 2) {
		var urlOrder = "&order=star"
	} else if(order.selectedIndex == 3) {
		var urlOrder = "&order=name"
	}
	
	const urlCurPage = "&currentPage=1"
	
	var move_url = root_url + "?cate=" + urlCate +  "&type=" + urlType + urlOrder + urlCurPage;
	
	location.href = move_url;
}
</script>

</head>
<body onload="init();">
	<center>

		<!-- header -->
		<jsp:include page="/WEB-INF/views/common/customer/header.jsp" />

		<!-- body -->
		<div class="body">
			<br>

			<div class="how_eat">
				<span> 
					<button id="btn_pickUp" onclick="pagePickUp()" class="home_eat">픽업</button>
				</span> 
				<span>
					<button id="btn_deliver" onclick="pageDeliver()" class="home_eat">배달</button>
				</span> 
				<span>
					<form>
						<select onchange="orderChange(this)" class="acolist">
							<option value="none" hidden="hidden">&nbsp&nbsp▶ 혼잡도별/별점별/이름별 정렬</option>
							<option value="list_congestion">혼잡도</option>
							<option value="list_star">별점</option>
							<option value="list_name">이름</option>
						</select>
					</form>
				</span>
			</div>
 
			<div id="map" style="height:700px; border: 5px solid #ffcc00; margin-top: 115px; width: 710px; margin-right: -350px; float: right;"></div>

			<br><br><br><br><br><br>

			<c:forEach var="store" items="${ requestScope.selectedStore }" varStatus="status">
					<div class="store">
						<table>
							<tr>
								<td onclick="click_rest('tr_rest_${status.index}')" id="tr_rest_${status.index}"> 
									<img id="store_photo_choice" src="${ store.photo }">
								</td>
								<td>
									<div class="restaurants-info">
										<div class="restaurant-name" title="가게이름">
											<c:out value="${ store.storeName }" />
										</div>
										<div class="congestion" title="혼잡도">
											<label id="congestion"> <c:out value="${ store.congestion }" /> </label>
										</div>
										<label id="name_tr_rest_${status.index}" disabled></label>
										<div class="stars_reviw">
											<span class="ico-star1">★ <c:out value="${ store.star }" /></span> 
											<span class="break-line"> | </span> 
											<span class="reviw-num">리뷰 <c:out value="${ store.reviewCnt }" /> 건</span>
										</div>
										<div class="choice">
											<button id="store_choice" class="store_choice"><a href="${ pageContext.servletContext.contextPath }/store/detail?storeId=${ store.storeId }">선택</a></button>
										</div>
									</div>
								</td>
							</tr>
						</table>
					</div>
			</c:forEach>
			<br>
		</div>

		<%-- 페이지 처리 --%>
		<div class="Number">
			<c:choose>
			    <c:when test="${ empty requestScope.searchValue }">
				    <button id="startPage" class="page_Number"><<</button>
	
					<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
						<button disabled class="page_Number"><</button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
						<button id="prevPage" class="page_Number"><</button>
					</c:if>
		
					<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
						<c:if test="${ requestScope.pageInfo.pageNo eq p }">
							<button disabled class="page_Number"><c:out value="${ p }"/></button>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo ne p }">
							<button onclick="pageButtonAction(this.innerText);" class="page_Number"><c:out value="${ p }"/></button>
						</c:if>
					</c:forEach>
					
					<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
						<button disabled class="page_Number">></button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
						<button id="nextPage" class="page_Number">></button>
					</c:if>
					
					<button id="maxPage" class="page_Number">>></button> 
			     </c:when>
			    <c:otherwise>
   				    <button id="searchStartPage" class="page_Number"><<</button>
	
					<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
						<button disabled class="page_Number"><</button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
						<button id="searchPrevPage" class="page_Number"><</button>
					</c:if>
		
					<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
						<c:if test="${ requestScope.pageInfo.pageNo eq p }">
							<button disabled class="page_Number"><c:out value="${ p }"/></button>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo ne p }">
							<button onclick="seachPageButtonAction(this.innerText);" class="page_Number"><c:out value="${ p }"/></button>
						</c:if>
					</c:forEach>
					
					<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
						<button disabled class="page_Number">></button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
						<button id="searchNextPage" class="page_Number">></button>
					</c:if>
					
					<button id="searchMaxPage" class="page_Number">>></button> 
			    </c:otherwise>
			</c:choose>   
		</div>
		
		<script>
		const root_url = "${ pageContext.servletContext.contextPath }/store/list";
		
		const url = new URL(document.URL);
		const urlCate = url.searchParams.get("cate");
		const urlType = url.searchParams.get("type");
		const urlOrder = url.searchParams.get("order");
		
		const link = root_url + "?cate=" + urlCate + "&type=" + urlType + "&order=" + urlOrder;
		
		if(document.getElementById("startPage")) {
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function() {
				location.href = link + "&currentPage=1";
			}
		}
		
		if(document.getElementById("prevPage")) {
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function() {
				location.href = link + "&currentPage=${ requestScope.pageInfo.pageNo - 1 }";
			}
		}
		
		if(document.getElementById("nextPage")) {
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function() {
				location.href = link + "&currentPage=${ requestScope.pageInfo.pageNo + 1 }";
			}
		}
		
		if(document.getElementById("maxPage")) {
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function() {
				location.href = link + "&currentPage=${ requestScope.pageInfo.maxPage }";
			}
		}
		
		function pageButtonAction(text) {
			location.href = link + "&currentPage=" + text;
		}
		
	</script>

		<br>

		<!-- footer -->
		<jsp:include page="/WEB-INF/views/common/customer/footer.jsp" />
	</center>

</body>
</html>