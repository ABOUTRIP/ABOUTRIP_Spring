<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/head.jsp"%>

<link rel="stylesheet" href="assets/css/main.css" />
</head>


<body style="margin-top: 80px;">
	<%@ include file="/common/nav.jsp"%>

	<main style="padding-bottom:80px;"> <%@ include
		file="/main/carousel.jsp"%> <%@ include
		file="/main/regionalTrip.jsp"%> <%@ include
		file="/main/myTripPlan.jsp"%> <%@ include
		file="/main/hotPlace.jsp"%> <%@ include
		file="/main/shareTrip.jsp"%> <%@ include
		file="/main/notice.jsp"%> </main>

	<%@ include file="/common/footer.jsp"%>
	<script>
		// 이미지 지도에 표시할 마커입니다
		// 이미지 지도에 표시할 마커를 아래와 같이 배열로 넣어주면 여러개의 마커를 표시할 수 있습니다
		var markers = [ {
			position : new kakao.maps.LatLng(33.450701, 126.570667),
		}, {
			position : new kakao.maps.LatLng(33.450001, 126.570467),
			text : "텍스트를 표시할 수 있어요!", // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다
		}, ];

		var staticMapContainer = document.getElementById("staticMap1"), // 이미지 지도를 표시할 div
		staticMapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 이미지 지도의 중심좌표
			level : 3, // 이미지 지도의 확대 레벨
			marker : markers, // 이미지 지도에 표시할 마커
		};

		// 이미지 지도를 생성합니다
		var staticMap = new kakao.maps.StaticMap(staticMapContainer,
				staticMapOption);
		var markers = [ {
			position : new kakao.maps.LatLng(33.450701, 126.570667),
		}, {
			position : new kakao.maps.LatLng(33.450001, 126.570467),
			text : "텍스트를 표시할 수 있어요!", // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다
		}, ];

		var staticMapContainer = document.getElementById("staticMap2"), // 이미지 지도를 표시할 div
		staticMapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 이미지 지도의 중심좌표
			level : 3, // 이미지 지도의 확대 레벨
			marker : markers, // 이미지 지도에 표시할 마커
		};

		// 이미지 지도를 생성합니다
		var staticMap = new kakao.maps.StaticMap(staticMapContainer,
				staticMapOption);
		var markers = [ {
			position : new kakao.maps.LatLng(33.450701, 126.570667),
		}, {
			position : new kakao.maps.LatLng(33.450001, 126.570467),
			text : "텍스트를 표시할 수 있어요!", // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다
		}, ];

		var staticMapContainer = document.getElementById("staticMap3"), // 이미지 지도를 표시할 div
		staticMapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 이미지 지도의 중심좌표
			level : 3, // 이미지 지도의 확대 레벨
			marker : markers, // 이미지 지도에 표시할 마커
		};

		// 이미지 지도를 생성합니다
		var staticMap = new kakao.maps.StaticMap(staticMapContainer,
				staticMapOption);
		var markers = [ {
			position : new kakao.maps.LatLng(33.450701, 126.570667),
		}, {
			position : new kakao.maps.LatLng(33.450001, 126.570467),
			text : "텍스트를 표시할 수 있어요!", // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다
		}, ];

		var staticMapContainer = document.getElementById("staticMap4"), // 이미지 지도를 표시할 div
		staticMapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 이미지 지도의 중심좌표
			level : 3, // 이미지 지도의 확대 레벨
			marker : markers, // 이미지 지도에 표시할 마커
		};

		// 이미지 지도를 생성합니다
		var staticMap = new kakao.maps.StaticMap(staticMapContainer,
				staticMapOption);
		var markers = [ {
			position : new kakao.maps.LatLng(33.450701, 126.570667),
		}, {
			position : new kakao.maps.LatLng(33.450001, 126.570467),
			text : "텍스트를 표시할 수 있어요!", // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다
		}, ];

		var staticMapContainer = document.getElementById("staticMap5"), // 이미지 지도를 표시할 div
		staticMapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 이미지 지도의 중심좌표
			level : 3, // 이미지 지도의 확대 레벨
			marker : markers, // 이미지 지도에 표시할 마커
		};

		// 이미지 지도를 생성합니다
		var staticMap = new kakao.maps.StaticMap(staticMapContainer,
				staticMapOption);
		var markers = [ {
			position : new kakao.maps.LatLng(33.450701, 126.570667),
		}, {
			position : new kakao.maps.LatLng(33.450001, 126.570467),
			text : "텍스트를 표시할 수 있어요!", // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다
		}, ];

		var staticMapContainer = document.getElementById("staticMap6"), // 이미지 지도를 표시할 div
		staticMapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 이미지 지도의 중심좌표
			level : 3, // 이미지 지도의 확대 레벨
			marker : markers, // 이미지 지도에 표시할 마커
		};

		// 이미지 지도를 생성합니다
		var staticMap = new kakao.maps.StaticMap(staticMapContainer,
				staticMapOption);
	</script>
</body>
</html>