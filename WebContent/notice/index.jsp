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

	<div class="container min-vh-100">
		<!--Section: Content-->
		<section class="text-center">
			<div class="d-flex justify-content-around my-5 align-items-center">
				<h2 class="">
					<strong>공지사항</strong>
				</h2>
				<div class="btn btn-info" data-mdb-toggle="modal"
					data-mdb-target="#newShareTrip">새글쓰기</div>
			</div>
			<!-- Modal -->
			<div class="modal fade" id="newShareTrip" tabindex="-1"
				aria-labelledby="newShareTrip" aria-hidden="true">
				<div class="modal-dialog d-flex justify-content-center">
					<div class="modal-content w-75">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel4">새 공지사항</h5>
							<button type="button" class="btn-close" data-mdb-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body p-4">
							<form>
								<!-- Name input -->
								<div class="form-outline mb-4">
									<input type="text" id="name4" class="form-control" /> <label
										class="form-label" for="name4">제목</label>
								</div>

								<!-- textarea input -->
								<div class="form-outline mb-4">
									<textarea id="textarea4" rows="4" class="form-control"></textarea>
									<label class="form-label" for="textarea4">내용</label>
								</div>

								<!-- Submit button -->
								<button type="submit" class="btn btn-primary btn-block">글올리기</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- Modal -->
			<table class="table shadow-5">
				<thead class="table-info">
					<tr>
						<!-- <th scope="col">No.</th> -->
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
						<th scope="col">추천수</th>
					</tr>
				</thead>
				<tbody>
					<tr data-mdb-toggle="modal" data-mdb-target="#shareTrip">
						<!-- <th scope="row">1</th> -->
						<td>안녕하세요 enjoytrip입니다.</td>
						<td>김싸피</td>
						<td>23.03.17</td>
						<td>1100</td>
						<td>800</td>
					</tr>
					<tr data-mdb-toggle="modal" data-mdb-target="#shareTrip1">
						<!-- <th scope="row">1</th> -->
						<td>재미있는 여행 많이 올려 주세요!!</td>
						<td>이싸피</td>
						<td>23.03.20</td>
						<td>800</td>
						<td>600</td>
					</tr>
					<tr data-mdb-toggle="modal" data-mdb-target="#shareTrip2">
						<!-- <th scope="row">1</th> -->
						<td>제주도 가면 마라도 꼭 다녀오세요!!</td>
						<td>안효인</td>
						<td>23.03.24</td>
						<td>600</td>
						<td>400</td>
					</tr>
					<tr data-mdb-toggle="modal" data-mdb-target="#shareTrip">
						<!-- <th scope="row">1</th> -->
						<td>안녕하세요 enjoytrip입니다.</td>
						<td>김싸피</td>
						<td>23.03.17</td>
						<td>1100</td>
						<td>800</td>
					</tr>
					<tr data-mdb-toggle="modal" data-mdb-target="#shareTrip1">
						<!-- <th scope="row">1</th> -->
						<td>재미있는 여행 많이 올려 주세요!!</td>
						<td>이싸피</td>
						<td>23.03.20</td>
						<td>800</td>
						<td>600</td>
					</tr>
					<tr data-mdb-toggle="modal" data-mdb-target="#shareTrip2">
						<!-- <th scope="row">1</th> -->
						<td>제주도 가면 마라도 꼭 다녀오세요!!</td>
						<td>안효인</td>
						<td>23.03.24</td>
						<td>600</td>
						<td>400</td>
					</tr>
					<tr data-mdb-toggle="modal" data-mdb-target="#shareTrip">
						<!-- <th scope="row">1</th> -->
						<td>안녕하세요 enjoytrip입니다.</td>
						<td>김싸피</td>
						<td>23.03.17</td>
						<td>1100</td>
						<td>800</td>
					</tr>
					<tr data-mdb-toggle="modal" data-mdb-target="#shareTrip1">
						<!-- <th scope="row">1</th> -->
						<td>재미있는 여행 많이 올려 주세요!!</td>
						<td>이싸피</td>
						<td>23.03.20</td>
						<td>800</td>
						<td>600</td>
					</tr>
					<tr data-mdb-toggle="modal" data-mdb-target="#shareTrip2">
						<!-- <th scope="row">1</th> -->
						<td>제주도 가면 마라도 꼭 다녀오세요!!</td>
						<td>안효인</td>
						<td>23.03.24</td>
						<td>600</td>
						<td>400</td>
					</tr>
					<tr data-mdb-toggle="modal" data-mdb-target="#shareTrip">
						<!-- <th scope="row">1</th> -->
						<td>안녕하세요 enjoytrip입니다.</td>
						<td>김싸피</td>
						<td>23.03.17</td>
						<td>1100</td>
						<td>800</td>
					</tr>
				</tbody>
			</table>
			<!-- Pagination -->
			<nav class="my-4" aria-label="...">
				<ul class="pagination pagination-circle justify-content-center">
					<li class="page-item"><a class="page-link" href="#"
						tabindex="-1" aria-disabled="true">Previous</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item active" aria-current="page"><a
						class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
					</li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</section>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="shareTrip" tabindex="-1"
		aria-labelledby="shareTrip" aria-hidden="true">
		<div class="modal-dialog d-flex justify-content-center">
			<div class="modal-content w-75">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel4">여행정보</h5>
					<button type="button" class="btn-close" data-mdb-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body p-4">
					<form>
						<!-- Name input -->
						<div class="form-outline mb-4">
							<input type="text" id="name4" class="form-control disabled"
								value="안녕하세요 enjoytrip입니다." /> <label
								class="form-label" for="name4">제목</label>
						</div>

						<!-- textarea input -->
						<div class="form-outline mb-4">
							<textarea id="textarea4" rows="4" class="form-control" disabled>
우리나라에 있는 전국의 가볼만한 여행지를 소개해 드리고,
여러분의 좋은 여행계획과 본인만 알고있는 숨어있는 핫플등을 소개, 자랑하는 사이트입니다.
우리나라의 예쁜곳들을 많이 많이 소개해주세요!!!</textarea>
							<label class="form-label" for="textarea4">내용</label>
						</div>
						<div class="text-end">22.03.17</div>

						<!-- Submit button -->
						<!-- <button type="submit" class="btn btn-primary btn-block">
                글올리기
              </button> -->
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<!-- Modal -->
	<div class="modal fade" id="shareTrip2" tabindex="-1"
		aria-labelledby="shareTrip2" aria-hidden="true">
		<div class="modal-dialog d-flex justify-content-center">
			<div class="modal-content w-75">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel4">여행정보</h5>
					<button type="button" class="btn-close" data-mdb-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body p-4">
					<form>
						<!-- Name input -->
						<div class="form-outline mb-4">
							<input type="text" id="name4" class="form-control disabled"
								value="제주도 가면 마라도 꼭 다녀오세요!!" /> <label
								class="form-label" for="name4">제목</label>
						</div>

						<!-- textarea input -->
						<div class="form-outline mb-4">
							<textarea id="textarea4" rows="4" class="form-control" disabled>
제주도 가면 마라도 꼭 다녀오세요!!</textarea>
							<label class="form-label" for="textarea4">내용</label>
						</div>
						<div class="text-end">22.03.17</div>

						<!-- Submit button -->
						<!-- <button type="submit" class="btn btn-primary btn-block">
                글올리기
              </button> -->
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<!-- Modal -->
	<div class="modal fade" id="shareTrip1" tabindex="-1"
		aria-labelledby="shareTrip1" aria-hidden="true">
		<div class="modal-dialog d-flex justify-content-center">
			<div class="modal-content w-75">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel4">여행정보</h5>
					<button type="button" class="btn-close" data-mdb-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body p-4">
					<form>
						<!-- Name input -->
						<div class="form-outline mb-4">
							<input type="text" id="name4" class="form-control disabled"
								value="재미있는 여행
                많이 올려 주세요!!" />
							<label class="form-label" for="name4">제목</label>
						</div>
						<!-- textarea input -->
						<div class="form-outline mb-4">
							<textarea id="textarea4" rows="4" class="form-control" disabled>
재미있는 여행 많이 올려 주세요.
</textarea>
							<label class="form-label" for="textarea4">내용</label>
						</div>
						<div class="text-end">22.03.17</div>
						<!-- Submit button -->
						<!-- <button type="submit" class="btn btn-primary btn-block">
                글올리기
              </button> -->
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
</body>
</html>