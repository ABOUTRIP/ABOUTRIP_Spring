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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.HotplaceDto;
import com.ssafy.project.model.service.HotplaceService;
import com.ssafy.project.model.service.JwtService;
import com.ssafy.project.model.service.JwtServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.models.media.MediaType;

//http://localhost:9999/vue/swagger-ui.html
//@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
@RestController
@RequestMapping("/hotplace")
@CrossOrigin("*")
@Api("핫플자랑하기 컨트롤러  API V1")
public class HotplaceController {

	private static final Logger logger = LoggerFactory.getLogger(HotplaceController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private HotplaceService hotplaceService;
	
	JwtService jwtService = new JwtServiceImpl();

//	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
//	@PostMapping
//	public ResponseEntity<String> writeHotplace(
//			@RequestBody @ApiParam(value = "게시글 정보.", required = true) HotplaceDto hotplaceDto) throws Exception {
//		logger.info("writeHotplace - 호출");
//		if (hotplaceService.writeHotplace(hotplaceDto)) {
//			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//		}
//		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//	}
	
	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보와 파일을 함께 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping(value = "/write", consumes = { "application/json", "multipart/form-data" })
	public ResponseEntity<String> writeHotplaceWithFile(
	        @RequestPart(value = "file") MultipartFile file,
	        @RequestBody @ApiParam(value = "게시글 정보.", required = true) HotplaceDto hotplaceDto) throws Exception {
	    logger.info("writeHotplaceWithFile - 호출");

	    // 파일 업로드 처리
	    if (!file.isEmpty()) {
	        byte[] fileData = file.getBytes();
	        // 파일 저장 로직 추가
	        hotplaceDto.setImg(fileData);
	    }

	    // 게시글 작성 처리
	    if (hotplaceService.writeHotplace(hotplaceDto)) {
	        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	    }
	    return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}


	@ApiOperation(value = "게시판 글목록", notes = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<HotplaceDto>> listHotplace(@ApiParam(value = "게시글을 얻기위한 부가정보.", required = true) BoardParameterDto boardParameterDto
														) throws Exception {
		logger.info("listHotplace - 호출");
//		String id = jwtService.extractIdFromJwt(token);
//		Jws<Claims> jws = Jwts.parser().parseClaimsJws(token);
//		Claims claims = jws.getBody();
//		String id = claims.getSubject();
		
//		Claims claims = Jwts.parser().parseClaimsJws(token).getBody();
//		String id = claims.get("userid", String.class);
		
//		BoardProperty boardProperty = new BoardProperty(board);
		return new ResponseEntity<List<HotplaceDto>>(hotplaceService.listHotplace(boardParameterDto), HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = HotplaceDto.class)
	@GetMapping("/{hotplaceno}")
	public ResponseEntity<?> getHotplace(
			@PathVariable("hotplaceno") @ApiParam(value = "얻어올 글의 글번호.", required = true) int hotplaceno) throws Exception {
		logger.info("getHotplace - 호출 : " + hotplaceno);
//		hotplaceService.updateHit(hotplaceno);
//		return new ResponseEntity<HotplaceDto>(hotplaceService.getHotplace(hotplaceno), HttpStatus.OK);		
		if (hotplaceService.getHotplace(hotplaceno) != null) {
//			hotplaceService.updateHit(hotplaceno); // Hotplace에서는 updateHit이 like_cnt 증가로 쓰임. 
			return new ResponseEntity<HotplaceDto>(hotplaceService.getHotplace(hotplaceno), HttpStatus.OK);	
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "게시판 글수정", notes = "수정할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyHotplace(
			@RequestBody @ApiParam(value = "수정할 글정보.", required = true) HotplaceDto hotplaceDto) throws Exception {
		logger.info("modifyHotplace - 호출 {}", hotplaceDto);

		if (hotplaceService.modifyHotplace(hotplaceDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}

	@ApiOperation(value = "게시판 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{hotplaceno}")
	public ResponseEntity<String> deleteHotplace(
			@PathVariable("hotplaceno") @ApiParam(value = "살제할 글의 글번호.", required = true) int hotplaceno) throws Exception {
		logger.info("deleteHotplace - 호출");
		if (hotplaceService.deleteHotplace(hotplaceno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "게시판 글추천", notes = "추천할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/{hotplaceno}")
	public void LikeHotplace(
			@PathVariable("hotplaceno") @ApiParam(value = "추천할 글정보.", required = true) int hotplaceno) throws Exception {
		logger.info("likeHotplace - 호출 {}", hotplaceno);
		hotplaceService.updateHit(hotplaceno);
	}
}

