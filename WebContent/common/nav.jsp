<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
	<div class="container">
		<a class="navbar-brand text-primary fw-bold" href="${root}/index.jsp">
			<img src="${root}/assets/img/logo.png" alt="" width="60" /> Enjoy
			Trip
		</a>
		<button class="navbar-toggler" type="button"
			data-mdb-toggle="collapse" data-mdb-target="#navbarText"
			aria-controls="navbarText" aria-expanded="false"
			aria-label="Toggle navigation">
			<i class="fas fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="tripSearch.html">지역별여행지</a></li>
				<li class="nav-item"><a class="nav-link" href="myTripPlan.html">나의여행계획</a></li>
				<li class="nav-item"><a class="nav-link" href="hotPlace.html">핫플자랑하기</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="shareTrip.html">여행정보공유</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="notice.html">공지사항</a>
				</li>
			</ul>
			<!-- 로그인 전 -->
			<div id="header_nav_confirm_off" style="display: block">
				<ul class="navbar-nav mb-2 me-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="${root}/auth/signUp.jsp">회원가입</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="${root}/auth/signIn.jsp">로그인</a></li>
				</ul>
			</div>

			<!-- 로그인 후 -->
			<div id="header_nav_confirm_on" style="display: none">
				<ul class="navbar-nav mb-2 me-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="mypage.html">마이페이지</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="#" onclick="logout();">로그아웃</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="#" onclick="withdrawal();">회원탈퇴</a></li>
				</ul>
			</div>
		</div>
	</div>
</nav>