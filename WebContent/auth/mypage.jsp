<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/head.jsp"%>

<link rel="stylesheet" href="assets/css/main.css" />
</head>

<body>
	<%@ include file="/common/nav.jsp"%>


	<div
		class="container min-vh-100 d-flex flex-column justify-content-center">
		<h3 class="m-5">마이페이지(회원 정보 확인/수정)</h3>
		<div class="tab-pane" id="pills-register" role="tabpanel"
			aria-labelledby="tab-register">
			<form method="post" action="${root}/UserController">
				<input type="hidden" name="action" value="update">
				<div class="form-outline mb-4">
					<input type="text" id="registerName" class="form-control"
						name="name" value="${userInfo.name}" /> <label class="form-label"
						for="registerName">이름</label>
				</div>

				<div class="form-outline mb-4">
					<input type="text" id="registerId" class="form-control" name="id"
						value="${userInfo.id}" readonly /> <label class="form-label"
						for="registerName">아이디</label>
				</div>

				<!-- Password input -->
				<div class="form-outline mb-4">
					<input type="password" id="registerPassword" class="form-control"
						name="password" /> <label class="form-label"
						for="registerPassword">비밀번호</label>
				</div>

				<!-- Repeat Password input -->
				<div class="form-outline mb-4">
					<input type="password" id="registerRepeatPassword"
						class="form-control" name="registerRepeatPassword" /> <label
						class="form-label" for="registerRepeatPassword">비밀번호 확인</label>
				</div>
				<div class="form-outline mb-4">
					<input type="email" id="registerId" name="email"
						class="form-control" value="${userInfo.email}" /> <label
						class="form-label" for="registerName">이메일</label>
				</div>

				<!-- Submit button -->
				<!-- <button type="submit" class="btn btn-primary btn-block mb-3"
						onclick="regist()">회원가입</button>  -->
				<input type="submit" class="btn btn-primary btn-block mb-3"
					value="수정하기">
			</form>
		</div>
	</div>
	<%@ include file="/common/footer.jsp"%>

</body>
</html>