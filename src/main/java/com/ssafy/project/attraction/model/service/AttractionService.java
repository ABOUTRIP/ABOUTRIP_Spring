package com.ssafy.project.attraction.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.project.attraction.model.AttractionDto;
import com.ssafy.project.util.PageNavigation;

public interface AttractionService {

	List<AttractionDto> attractionList(Map<String, String> map) throws Exception;

	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;

	AttractionDto getAttraction(int articleNo) throws Exception;

//	void updateHit(int articleNo) throws Exception;

}
