<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<!--Section: Content-->
	<section class="text-center">
		<h2 class="my-5">
			<strong>핫플 자랑하기</strong>
		</h2>
		<div class="d-flex flex-row flex-wrap">
			<c:forEach items="tripPlans" var="plan">

				<div class="col-lg-4 col-md-6 col-sm-12 mb-4">
					<div class="card h-100 m-2">
						<div class="bg-image hover-overlay ripple"
							data-mdb-ripple-color="light">
							<img
								src="https://mdbootstrap.com/img/new/standard/nature/184.jpg"
								class="img-fluid" /> <a href="#!">
								<div class="mask"
									style="background-color: rgba(251, 251, 251, 0.15)"></div>
							</a>
						</div>
						<div class="card-body d-flex flex-column justify-content-between">
							<h5 class="card-title">호어모아</h5>
							<p class="card-text">대구광역시 남구 안지랑로5길 88</p>
							<div>
								<button type="button" class="btn btn-info"
									data-mdb-toggle="modal" data-mdb-target="#exampleModal">
									더보기</button>
								<!-- Modal -->
								<div class="modal fade" id="exampleModal" tabindex="-1"
									aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">호어모아</h5>
												<button type="button" class="btn-close"
													data-mdb-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="bg-image hover-overlay ripple m-2"
												data-mdb-ripple-color="light">
												<img
													src="https://mdbootstrap.com/img/new/standard/nature/023.jpg"
													class="img-fluid rounded-3" /> <a href="#!">
													<div class="mask"
														style="background-color: rgba(251, 251, 251, 0.15);"></div>
												</a>
											</div>
											<div class="modal-body">
												<h4>대구광역시 남구 안지랑로5길 88</h4>
												<p class="text-start">호어모아는 대구광역시 남구 대명동, 앞산맛 둘레길에 있는
													양식집이다. 주택을 개조해서 건물 외부는 가정집 같지만 깔끔하고 고급스러운 내부 인테리어가 눈에 띈다.
													호어모어는 하와이 말로 ‘요리하는 집이란 뜻이다. 식당 내부에는 단체석이 마련되어 있어 각종 모임을 가지기
													좋다. 대표 메뉴는 새우와 꽃게 향이 가득한 해산물 로제이며, 고소한 크림소스에 매콤함을 더한 투움바
													파스타, 새우와 마늘을 버터에 볶아 허브로 맛을 낸 버터갈릭 쉬림프도 인기다. 이 밖에 핫칠리 쉬림프,
													하와이안 갈비 등을 맥주와 함께 즐길 수 있다.</p>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-primary"
													data-mdb-dismiss="modal" aria-label="Close">닫기</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	<!--Section: Content-->
</div>