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

	<main> <!-- Pills navs -->
    <div class="container min-vh-100 d-flex flex-column justify-content-center">


		<h2 class="mb-5">회원가입</h2>
		<!-- Pills content -->
		<div class="tab-content">
			<div class="tab-pane fade show active" id="pills-register"
				role="tabpanel" aria-labelledby="tab-register">
				<form>

					<div class="form-outline mb-4">
						<input type="text" id="registerName" class="form-control" /> <label
							class="form-label" for="registerName">이름</label>
					</div>

					<div class="form-outline mb-4">
						<input type="text" id="registerId" class="form-control" /> <label
							class="form-label" for="registerName">아이디</label>
					</div>

					<!-- Password input -->
					<div class="form-outline mb-4">
						<input type="password" id="registerPassword" class="form-control" />
						<label class="form-label" for="registerPassword">비밀번호</label>
					</div>

					<!-- Repeat Password input -->
					<div class="form-outline mb-4">
						<input type="password" id="registerRepeatPassword"
							class="form-control" /> <label class="form-label"
							for="registerRepeatPassword">비밀번호 확인</label>
					</div>
					<div class="form-outline mb-4">
						<input type="email" id="registerId" class="form-control" /> <label
							class="form-label" for="registerName">이메일</label>
					</div>
					<label class="form-label" for="registerName">지역</label>
					<div class="form-outline mb-4">
						<div class="d-flex">
							<select id="sido" class="form-select me-2">
								<option value="0" selected>시도선택</option>
							</select> <select id="gugun" class="form-select me-2">
								<option value="0" selected>구군선택</option>
							</select>
						</div>
					</div>
					<!-- Submit button -->
					<button type="submit" class="btn btn-primary btn-block mb-3"
						onclick="regist()">회원가입</button>
				</form>
			</div>
		</div>
	</div>
	</main>

	<%@ include file="/common/footer.jsp"%>
	<script src="${root}/assets/js/key.js"></script>
	<script>
      // index page 로딩 후 전국의 시도 설정.
      let areaUrl =
        "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
        serviceKey +
        "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

      fetch(areaUrl, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeOption(data));

      function makeOption(data) {
        let areas = data.response.body.items.item;
        let sel = document.getElementById("sido");
        areas.forEach((area) => {
          let opt = document.createElement("option");
          opt.setAttribute("value", area.code);
          opt.appendChild(document.createTextNode(area.name));

          sel.appendChild(opt);
        });
      }

    </script>
</body>
</html>
