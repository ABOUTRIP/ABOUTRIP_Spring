package com.ssafy.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.PlaceDto;
import com.ssafy.project.model.PlanDto;
import com.ssafy.project.model.service.PlanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//http://localhost:9999/vue/swagger-ui.html
//@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
@RestController
@RequestMapping("/plan")
@CrossOrigin("*")
@Api("여행플랜공유 컨트롤러  API V1")
public class PlanController {

	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private PlanService planService;

	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writePlan(
			@RequestBody @ApiParam(value = "게시글 정보.", required = true) PlanDto planDto) throws Exception {
		
		// List<List<PlaceDto>> planPath in planDto
		planService.writePlan(planDto);
		List<PlaceDto> planPath = planDto.getPlanPath();
		for (int i = 0; i < planPath.size(); i++) {
			planService.writePlace(planPath.get(i));

		}
		
		
		logger.info("writePlan - 호출");
		if (planService.writePlan(planDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "게시판 글목록", notes = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<PlanDto>> listPlan(@ApiParam(value = "게시글을 얻기위한 부가정보.", required = true) BoardParameterDto boardParameterDto) throws Exception {
		logger.info("listPlan - 호출");
		return new ResponseEntity<List<PlanDto>>(planService.listPlan(boardParameterDto), HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = PlanDto.class)
	@GetMapping("/{planno}")
	public ResponseEntity<?> getPlan(
			@PathVariable("planno") @ApiParam(value = "얻어올 글의 글번호.", required = true) int planno) throws Exception {
		logger.info("getPlan - 호출 : " + planno);
//		planService.updateHit(planno);
//		return new ResponseEntity<PlanDto>(planService.getPlan(planno), HttpStatus.OK);		
		if (planService.getPlan(planno) != null) {
//			planService.updateHit(planno);
			return new ResponseEntity<PlanDto>(planService.getPlan(planno), HttpStatus.OK);	
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "게시판 글수정", notes = "수정할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyPlan(
			@RequestBody @ApiParam(value = "수정할 글정보.", required = true) PlanDto planDto) throws Exception {
		logger.info("modifyPlan - 호출 {}", planDto);

		if (planService.modifyPlan(planDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "게시판 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{planno}")
	public ResponseEntity<String> deletePlan(
			@PathVariable("planno") @ApiParam(value = "삭제할 글의 글번호.", required = true) int planno) throws Exception {
		logger.info("deletePlan - 호출");
		if (planService.deletePlan(planno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "게시판 글추천", notes = "추천할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/like")
	public ResponseEntity<String> likePlan(
			@RequestBody @ApiParam(value = "수정할 글정보 (글번호만 포함)", required = true) PlanDto planDto) throws Exception {
		logger.info("likePlan - 호출 {}", planDto);
		
		if (planService.updateLike(planDto.getPlanId()) == true) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
		
		
//		if (planService.updateLike(planDto)) {
//			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//		}
//		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시판 글조회", notes = "조회할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/hit")
	public ResponseEntity<String> hitPlan(
			@RequestBody @ApiParam(value = "조회할 글정보 (글번호만 포함)", required = true) PlanDto planDto) throws Exception {
		logger.info("hitPlan - 호출 {}", planDto);
		
		if (planService.updateHit(planDto.getPlanId())) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "myplan 목록", notes = "myplan의 정보를 반환한다.", response = List.class)
	@GetMapping("/myplan")
	public ResponseEntity<List<PlanDto>> listMyPlan(@ApiParam(value = "myplan을 얻기위한 부가정보.", required = true)String userid) throws Exception {
		logger.info("listMyPlan - 호출");
//		if (planService.listMyPlan(userid) != null) {
//			return new ResponseEntity<List<PlanDto>>(planService.listMyPlan(userid), HttpStatus.OK);
//		}
		return new ResponseEntity<List<PlanDto>>(planService.listMyPlan(userid), HttpStatus.OK);
//		return new ResponseEntity<List<PlanDto>>(planService.listMyPlan(userid), HttpStatus.NO_CONTENT);
	}
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}