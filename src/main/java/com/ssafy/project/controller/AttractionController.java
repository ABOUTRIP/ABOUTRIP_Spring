package com.ssafy.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.model.AttractionDto;
import com.ssafy.project.model.service.AttractionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/attraction")
@CrossOrigin("*")
@Api("지역별 여행지 컨트롤러  API V1")
public class AttractionController {

	private static final Logger logger = LoggerFactory.getLogger(AttractionController.class);

	private AttractionService attractionService;

	@Autowired
	public AttractionController(AttractionService attractionService) {
		this.attractionService = attractionService;
	}

	@ApiOperation(value = "지역별여행지 목록", notes = "지역별여행지 <big>전체 목록</big>을 반환해 줍니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "지역별여행지 목록 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "searchSidoCode", value = "검색지역", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "searchContentTypeId", value = "관광지유형", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "searchWord", value = "검색어", required = true, dataType = "String", paramType = "query") })
	@GetMapping(value = "/list")
	public ResponseEntity<?> attractionList(@RequestParam(required = false, defaultValue = "-1") int searchSidoCode,
			@RequestParam(required = false, defaultValue = "-1") int searchContentTypeId, @RequestParam("searchWord") String searchWord
			) {
		logger.debug("attractionList call", searchSidoCode, searchContentTypeId, searchWord);
		try {
			Map<String, String> map = new HashMap();
			map.put("searchSidoCode", String.valueOf(searchSidoCode));
			map.put("searchContentTypeId", String.valueOf(searchContentTypeId));
			map.put("searchWord", searchWord);

			List<AttractionDto> list = attractionService.attractionList(map);
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<List<AttractionDto>>(list, HttpStatus.OK);
//				return new ResponseEntity<List<AttractionDto>>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	@ApiOperation(value = "지역별 여행지 상세정보", notes = "지역별 여행지 하나에 대한 정보.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "attractionId", value = "지역별 여행지 아이디", required = true, dataType = "int", paramType = "path")
//			@ApiImplicitParam(name = "param1", value = "파라미터1", required = true, dataType = "String", paramType = "query"),
//			@ApiImplicitParam(name = "param2", value = "파마미터2", required = false, dataType = "int", paramType = "query") 
	})
	@GetMapping(value = "/detail/{attractionId}")
	public ResponseEntity<?> attractionInfo(@PathVariable("attractionId") int attractionId) {
		logger.debug("attractionInfo attractionId : {}", attractionId);
		try {
			AttractionDto attractionDto = attractionService.getAttraction(attractionId);
			if (attractionDto != null)
				return new ResponseEntity<AttractionDto>(attractionDto, HttpStatus.OK);
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
