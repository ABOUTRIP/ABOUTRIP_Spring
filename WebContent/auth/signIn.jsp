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

	<div
		class="container min-vh-100 d-flex flex-column justify-content-center">
		<h2 class="mb-5">로그인</h2>

		<!-- Pills content -->
		<div class="tab-content">
			<div class="tab-pane fade show active" id="pills-login"
				role="tabpanel" aria-labelledby="tab-login">
				<form method="post" action="${root}/UserController?action=login">
					<input type="hidden" name="action" value="${root}/UserController?action=login">
					<!-- ID input -->
					<div class="form-outline mb-4">
						<input type="id" id="loginId" class="form-control" name="id" /> <label
							class="form-label" for="loginId">아이디</label>
					</div>

					<!-- Password input -->
					<div class="form-outline mb-4">
						<input type="password" id="loginPassword" class="form-control"
							name="password" /> <label class="form-label" for="loginPassword">비밀번호</label>
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
					<!-- <button type="button" id="loginButton"
						class="btn btn-primary btn-block mb-4" onclick="login()">
						로그인</button> -->
					<input type="submit" id="loginButton"
						class="btn btn-primary btn-block mb-4" value="로그인">
				</form>
			</div>
		</div>
	</div>
	</main>
	<%@ include file="/common/footer.jsp"%>

</body>
</html>