<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/head.jsp"%>
<link rel="stylesheet" href="${root}/assets/css/main.css" />
</head>
<body>
	<%@ include file="/common/nav.jsp"%>
	<main>

	<div class="container min-vh-100">
		<div class="">
			<h3 class="mt-3 text-center fw-bold" role="alert">지역별 여행지</h3>
			<!-- 관광지 검색 start -->
			<form class="d-flex my-3" onsubmit="return false;" role="search">
				<select id="search-area" class="form-select me-2">
					<option value="0" selected>검색 할 지역 선택</option>
				</select> <select id="search-content-id" class="form-select me-2">
					<option value="0" selected>관광지 유형</option>
					<option value="12">관광지</option>
					<option value="14">문화시설</option>
					<option value="15">축제공연행사</option>
					<option value="25">여행코스</option>
					<option value="28">레포츠</option>
					<option value="32">숙박</option>
					<option value="38">쇼핑</option>
					<option value="39">음식점</option>
				</select> <input id="search-keyword" class="form-control me-2" type="search"
					placeholder="검색어" aria-label="검색어" />
				<button id="btn-search" class="btn btn-outline-success text-nowrap"
					type="button">검색</button>

			</form>
			<div id="researchBlock" class="d-flex"
				style="display: none !important;">
				<input id="research-keyword" class="form-control me-2" type="search"
					placeholder="검색어" aria-label="검색어" />
				<button id="btn-research"
					class="btn btn-outline-success text-nowrap" type="button">결과
					내 재검색</button>
			</div>
			<!-- kakao map start -->
			<div id="map" class="mt-3" style="width: 100%; height: 400px"></div>
			<!-- kakao map end -->
			<div class="row">
				<table class="table table-striped" style="display: none">
					<thead>
						<tr>
							<th>대표이미지</th>
							<th>관광지명</th>
							<th>주소</th>
							<th>위도</th>
							<th>경도</th>
						</tr>
					</thead>
					<tbody id="trip-list"></tbody>
				</table>
			</div>
			<!-- 관광지 검색 end -->
		</div>
	</div>
	</main>
	<%@ include file="/common/footer.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script src="${root}/assets/js/key.js"></script>
	<script src="${root}/assets/js/main.js"></script>

	<script>
      // index page 로딩 후 전국의 시도 설정.
      let areaUrl =
        "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
        serviceKey +
        "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

      let tripListData;
      let markers = [];
      // fetch(areaUrl, { method: "GET" }).then(function (response) { return response.json() }).then(function (data) { makeOption(data); });
      fetch(areaUrl, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeOption(data));

      function makeOption(data) {
        let areas = data.response.body.items.item;
        // console.log(areas);
        let sel = document.getElementById("search-area");
        areas.forEach((area) => {
          let opt = document.createElement("option");
          opt.setAttribute("value", area.code);
          opt.appendChild(document.createTextNode(area.name));

          sel.appendChild(opt);
        });
      }

      const KMP = (text, pattern) => {
    	  let tLength = text.length;
    	  let pLength = pattern.length;
    	  let pi = [];

    	  for (let i = 1, j = 0; i < pLength; i++) {
    	    while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];

    	    if (pattern[i] == pattern[j]) pi[i] = ++j;
    	    else pi[i] = 0;
    	  }

    	  for (let i = 0, j = 0; i < tLength; i++) {
    	    let findFlag = false;
    	    while (j > 0 && text[i] != pattern[j]) j = pi[j - 1];

    	    if (text[i] == pattern[j]) {
    	      if (j == pLength - 1) {
    	        findFlag = true;
    	      } else {
    	        j++;
    	      }
    	    }
    	    if (findFlag) {
    	      return true;
    	    }
    	  }
    	  return false;
    	};
      // 결과 내 재검색 버튼 이벤트
      document.getElementById("btn-research").addEventListener("click", () => {
          let keyword = document.getElementById("research-keyword").value;

    	  let newTripListData = tripListData.filter(d=>{
    		 return KMP(d.title, keyword)
    	  });
    	 console.log(newTripListData);
    	 makeList(newTripListData);
    	 
      });
      
      
      // 검색 버튼을 누르면..
      // 지역, 유형, 검색어 얻기.
      // 위 데이터를 가지고 공공데이터에 요청.
      // 받은 데이터를 이용하여 화면 구성.
      document.getElementById("btn-search").addEventListener("click", () => {
        let searchUrl = 'https://apis.data.go.kr/B551011/KorService1/searchKeyword1?serviceKey='+serviceKey+'&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A';

        let areaCode = document.getElementById("search-area").value;
        let contentTypeId = document.getElementById("search-content-id").value;
        let keyword = document.getElementById("search-keyword").value;

        if (parseInt(areaCode)) searchUrl += `&areaCode=${areaCode}`;
        if (parseInt(contentTypeId))
          searchUrl += `&contentTypeId=${contentTypeId}`;
        if (!keyword) {
          alert("검색어 입력 필수!!!");
          return;
        } else searchUrl += ('&keyword='+ keyword);

        fetch(searchUrl)
          .then((response) => response.json())
          .then((data) => makeList(data.response.body.items.item))
          .then((d)=>{
        	  const research = document.getElementById("researchBlock");
        	  console.log(research);
        	  research.style.display = "flex";
        		
          });
      });

      var positions; // marker 배열.
      function makeList(data) {
        document.querySelector("table").setAttribute("style", "display: ;");
        let trips = data;
        let tripList = ``;
        tripListData = trips;
        positions = [];
        if(!trips){
            document.getElementById("trip-list").innerHTML = '';
            removeMarker();
        }else{
	        trips.forEach((area) => {
	          tripList += `
	            <tr onclick="moveCenter(`+area.mapy+`, `+area.mapx+`);">
	              <td><img src="`+area.firstimage+`" width="100px"></td>
	              <td>`+area.title+`</td>
	              <td>`+area.addr1+` `+area.addr2+`</td>
	              <td>`+area.mapy+`</td>
	              <td>`+area.mapx+`</td>
	            </tr>
	          `;
	
	          let markerInfo = {
	            title: area.title,
	            latlng: new kakao.maps.LatLng(area.mapy, area.mapx),
	          };
	          positions.push(markerInfo);
	        });
	        document.getElementById("trip-list").innerHTML = tripList;
	        displayMarker();
        }
	        
      }

      // 카카오지도
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
          level: 5, // 지도의 확대 레벨
        };

      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption);

      function displayMarker() {
        // 마커 이미지의 이미지 주소입니다
        var imageSrc =
          "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

        for (var i = 0; i < positions.length; i++) {
          // 마커 이미지의 이미지 크기 입니다
          var imageSize = new kakao.maps.Size(24, 35);

          // 마커 이미지를 생성합니다
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image: markerImage, // 마커 이미지
          });
          markers.push(marker);
        }

        // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
        map.setCenter(positions[0].latlng);
      }

      function moveCenter(lat, lng) {
        map.setCenter(new kakao.maps.LatLng(lat, lng));
      }
      
      function removeMarker() {
         // 마커 이미지의 이미지 주소입니다
         for (var i = 0; i < markers.length; i++) {
           markers[i].setMap(null);
         }
       }
       function moveCenter(lat, lng) {
         map.setCenter(new kakao.maps.LatLng(lat, lng));
       }
    </script>

</body>
</html>