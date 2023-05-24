package com.ssafy.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.model.LikeInfoDto;
import com.ssafy.project.model.service.JwtService;
import com.ssafy.project.model.service.JwtServiceImpl;
import com.ssafy.project.model.service.RegionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/region")
@CrossOrigin("*")
@Api("지역별여행지 찜하기 컨트롤러  API V1")
public class RegionController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegionController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private RegionService regionService;
	
	JwtService jwtService = new JwtServiceImpl();
	
	@ApiOperation(value = "찜", notes = "찜할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/like")
	public ResponseEntity<String> like(
			@RequestBody @ApiParam(value = "찜할 글정보 (글번호만 포함)", required = true) LikeInfoDto likeInfoDto) throws Exception {
		logger.info("like - 호출 {}", likeInfoDto);
		
		if (regionService.like(likeInfoDto) == true) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "찜 취소", notes = "찜 취소할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/cancellike")
	public ResponseEntity<String> cancelLike(
			@RequestBody @ApiParam(value = "찜 취소할 글정보 (글번호만 포함)", required = true) LikeInfoDto likeInfoDto) throws Exception {
		logger.info("cancelLike - 호출 {}", likeInfoDto);
		
		if (regionService.cancelLike(likeInfoDto) == true) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "찜한 content_id 목록", notes = "id를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@GetMapping("/listlike")
	public ResponseEntity<?> listLike(
			@RequestParam @ApiParam(value = "찜 목록을 확인할 id", required = true) String userid) throws Exception {
		
		if (regionService.listLike(userid) != null) {
			return new ResponseEntity<List<Integer>>(regionService.listLike(userid), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
}
