package com.ssafy.project.sido.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.sido.model.SidoDto;
import com.ssafy.project.sido.model.service.SidoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/sido")
@CrossOrigin("*")
@Api("어드민 컨트롤러  API V1")
public class SidoController {

	private static final Logger logger = LoggerFactory.getLogger(SidoController.class);

	private SidoService sidoService;

	@Autowired
	public SidoController(SidoService sidoService) {
		this.sidoService = sidoService;
	}

	@ApiOperation(value = "시/도목록", notes = "시/도의 <big>전체 목록</big>을 반환해 줍니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "시/도목록 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@GetMapping(value = "/list")
	public ResponseEntity<?> sidoList() {
		logger.debug("userList call");
		try {
			List<SidoDto> list = sidoService.sidoList();
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<List<SidoDto>>(list, HttpStatus.OK);
//				return new ResponseEntity<List<MemberDto>>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	@ApiOperation(value = "시/도정보", notes = "시/도 하나에 대한 정보.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "sidoCode", value = "시/도 코드", required = true, dataType = "int", paramType = "path")
//			@ApiImplicitParam(name = "param1", value = "파라미터1", required = true, dataType = "String", paramType = "query"),
//			@ApiImplicitParam(name = "param2", value = "파마미터2", required = false, dataType = "int", paramType = "query") 
	})
	@GetMapping(value = "/{sidoCode}")
	public ResponseEntity<?> userInfo(@PathVariable("sidoCode") int sidoCode) {
		logger.debug("userInfo userid : {}", sidoCode);
		try {
			SidoDto sidoDto = sidoService.getSido(sidoCode);
			if (sidoDto != null)
				return new ResponseEntity<SidoDto>(sidoDto, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
