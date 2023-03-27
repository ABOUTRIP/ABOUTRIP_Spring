<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<!--Section: Content-->
	<section class="text-center">
		<h2 class="my-5">
			<strong>나의 여행계획</strong>
		</h2>

		<div class="d-flex flex-row flex-wrap">
			<c:forEach items="tripPlans" var="plan">
				<div class="col-lg-4 col-md-6 col-sm-12 mb-4">

					<div class="card h-100 m-2">
						<div class="bg-image hover-overlay ripple"
							data-mdb-ripple-color="light">
							<div id="map-container-google-6"
								class="z-depth-1-half map-container">
								<div id="staticMap1" style="height: 200px"></div>
							</div>
						</div>
						<div class="card-body d-flex flex-column justify-content-between">
							<h5 class="card-title">카카오 본사</h5>
							<p class="card-text">경상남도 합천군 가야면 야천로 101</p>
							<div>
								<!-- <a href="#!" class="btn btn-info">Read</a> -->
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</div>