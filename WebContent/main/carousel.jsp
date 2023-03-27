<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Carousel wrapper -->
<div id="introCarousel"
	class="carousel slide carousel-fade shadow-2-strong"
	data-mdb-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-mdb-target="#introCarousel" data-mdb-slide-to="0"
			class="active"></li>
		<li data-mdb-target="#introCarousel" data-mdb-slide-to="1"></li>
		<li data-mdb-target="#introCarousel" data-mdb-slide-to="2"></li>
	</ol>

	<!-- Inner -->
	<div class="carousel-inner">
		<!-- Single item -->
		<div class="carousel-item active">
			<div class="mask" style="background-color: rgba(0, 0, 0, 0.6)">
				<div class="d-flex justify-content-center align-items-center h-100">
					<div class="text-white text-center w-75">
						<h1 class="mb-5">
							지금
							<!-- <span class="text-warning">Enjoy!!!Trip</span> -->
							<img src="assets/img/logo.png" width="200px" /> 과 함께 우리지역의 관광지를
							알아보고 나만의 여행 계획을 만들어보세요
						</h1>
						<hr class="my-5" />
						<h5 class="mb-4">나만의 여행 계획을 세우고 공유해 보세요.</h5>
						<a class="btn btn-outline-light btn-lg m-2" href="${root}/myTripPlan/index.jsp"
							role="button" rel="nofollow">일정 더보기</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Single item -->
		<div class="carousel-item">
			<div class="mask" style="background-color: rgba(0, 0, 0, 0.3)">
				<div class="d-flex justify-content-center align-items-center h-100">
					<div class="text-white text-center w-75">
						<h1 class="mb-5">
							지금
							<!-- <span class="text-warning">Enjoy!!!Trip</span> -->
							<img src="assets/img/logo.png" width="200px" /> 과 함께 우리지역의 관광지를
							알아보고 나만의 여행 계획을 만들어보세요
						</h1>
						<hr class="my-5" />
						<h5 class="mb-4">나만의 여행 계획을 세우고 공유해 보세요.</h5>
						<a class="btn btn-outline-light btn-lg m-2" href="#" role="button"
							rel="nofollow">일정 더보기</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Single item -->
		<div class="carousel-item">
			<div class="mask"
				style="background: linear-gradient(45deg, rgba(29, 236, 197, 0.7), rgba(91, 14, 214, 0.7) 100%);">
				<div class="d-flex justify-content-center align-items-center h-100">
					<div class="text-white text-center w-75">
						<h1 class="mb-5">
							지금
							<!-- <span class="text-warning">Enjoy!!!Trip</span> -->
							<img src="assets/img/logo.png" width="200px" /> 과 함께 우리지역의 관광지를
							알아보고 나만의 여행 계획을 만들어보세요
						</h1>
						<hr class="my-5" />
						<h5 class="mb-4">나만의 여행 계획을 세우고 공유해 보세요.</h5>
						<a class="btn btn-outline-light btn-lg m-2" href="#" role="button"
							rel="nofollow">일정 더보기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Inner -->

	<!-- Controls -->
	<a class="carousel-control-prev" href="#introCarousel" role="button"
		data-mdb-slide="prev"> <span
		class="carousel-control-prev-icon" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#introCarousel" role="button"
		data-mdb-slide="next"> <span
		class="carousel-control-next-icon" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a>
</div>
<!-- Carousel wrapper -->