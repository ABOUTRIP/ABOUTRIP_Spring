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
import com.ssafy.project.model.TipDto;
import com.ssafy.project.model.service.TipService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//http://localhost:9999/vue/swagger-ui.html
//@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
@RestController
@RequestMapping("/tip")
@CrossOrigin("*")
@Api("여행정보공유 컨트롤러  API V1")
public class TipController {

	private static final Logger logger = LoggerFactory.getLogger(TipController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private TipService tipService;

	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeTip(
			@RequestBody @ApiParam(value = "게시글 정보.", required = true) TipDto tipDto) throws Exception {
		logger.info("writeTip - 호출");
		if (tipService.writeTip(tipDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "게시판 글목록", notes = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<TipDto>> listTip(@ApiParam(value = "게시글을 얻기위한 부가정보.", required = true) BoardParameterDto boardParameterDto) throws Exception {
		logger.info("listTip - 호출");
		return new ResponseEntity<List<TipDto>>(tipService.listTip(boardParameterDto), HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = TipDto.class)
	@GetMapping("/{tipno}")
	public ResponseEntity<?> getTip(
			@PathVariable("tipno") @ApiParam(value = "얻어올 글의 글번호.", required = true) int tipno) throws Exception {
		logger.info("getTip - 호출 : " + tipno);
		tipService.updateHit(tipno);
//		return new ResponseEntity<TipDto>(tipService.getTip(tipno), HttpStatus.OK);		
		if (tipService.getTip(tipno) != null) {
			tipService.updateHit(tipno);
			return new ResponseEntity<TipDto>(tipService.getTip(tipno), HttpStatus.OK);	
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "게시판 글수정", notes = "수정할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyTip(
			@RequestBody @ApiParam(value = "수정할 글정보.", required = true) TipDto tipDto) throws Exception {
		logger.info("modifyTip - 호출 {}", tipDto);

		if (tipService.modifyTip(tipDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{tipno}")
	public ResponseEntity<String> deleteTip(
			@PathVariable("tipno") @ApiParam(value = "삭제할 글의 글번호.", required = true) int tipno) throws Exception {
		logger.info("deleteTip - 호출");
		if (tipService.deleteTip(tipno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}