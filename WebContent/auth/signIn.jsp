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

	<!-- Pills navs -->
	<main>

	<div class="container min-vh-100">
		<ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
			<li class="nav-item" role="presentation"><a
				class="nav-link active" id="tab-login" data-mdb-toggle="pill"
				href="#pills-login" role="tab" aria-controls="pills-login"
				aria-selected="true">로그인</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link "
				id="tab-register" data-mdb-toggle="pill" href="#pills-register"
				role="tab" aria-controls="pills-register" aria-selected="false">회원가입</a></li>
		</ul>
		<!-- Pills navs -->
		<!-- Pills content -->
		<div class="tab-content">
			<div class="tab-pane fade show active" id="pills-login"
				role="tabpanel" aria-labelledby="tab-login">
				<form>
					<!-- ID input -->
					<div class="form-outline mb-4">
						<input type="id" id="loginId" class="form-control" /> <label
							class="form-label" for="loginId">아이디</label>
					</div>

					<!-- Password input -->
					<div class="form-outline mb-4">
						<input type="password" id="loginPassword" class="form-control" />
						<label class="form-label" for="loginPassword">비밀번호</label>
					</div>

					<!-- 2 column grid layout -->
					<div class="row mb-4">
						<div class="col-md-6 d-flex justify-content-center">
							<!-- Checkbox -->
							<div class="form-check mb-3 mb-md-0">
								<input class="form-check-input" type="checkbox" value=""
									id="loginCheck" checked /> <label class="form-check-label"
									for="loginCheck"> 아이디 저장하기 </label>
							</div>
						</div>

						<div class="col-md-6 d-flex justify-content-center">
							<!-- Simple link -->
							<button class="btn btn-primary">비밀번호 찾기</button>
						</div>
					</div>

					<!-- Submit button -->
					<button type="button" id="loginButton"
						class="btn btn-primary btn-block mb-4" onclick="login()">
						로그인</button>

				</form>
			</div>
			<div class="tab-pane fade" id="pills-register" role="tabpanel"
				aria-labelledby="tab-register">
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

</body>
</html>