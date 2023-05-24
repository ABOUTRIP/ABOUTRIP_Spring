package com.ssafy.project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BoardParameterDto : 게시판 파라미터 정보", description = "게시판의 글을 얻기위한 부가적인 파라미터정보.")
public class BoardParameterDto {

	@ApiModelProperty(value = "현재 페이지 번호")
	private int pg;
	@ApiModelProperty(value = "페이지당 글갯수")
	private int spp;
	@ApiModelProperty(value = "페이지의 시작 글번호")
	private int start;
//	@ApiModelProperty(value = "검색 조건")
//	private String key;
	@ApiModelProperty(value = "검색어")
	private String word;
//	@ApiModelProperty(value = "관리자인지 확인하기 위한 id (admin/그 외/빈 칸 - 세 개의 선택지)")
//	private String idCheck; 
	
	public BoardParameterDto() {
		pg = 1;
		spp = 20;
	}
	
//	public String getIdCheck() {
//		return idCheck;
//	}
//
//	public void setIdCheck(String idCheck) {
//		this.idCheck = idCheck;
//	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		pg = pg == 0 ? 1 : pg;
		this.pg = pg;
	}

	public int getSpp() {
		return spp;
	}

	public void setSpp(int spp) {
		this.spp = spp;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

//	public String getKey() {
//		return key;
//	}
//
//	public void setKey(String key) {
//		this.key = key;
//	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}

