package com.ssafy.project.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ssafy.project.controller.AttractionController;
import com.ssafy.project.model.AttractionDto;
import com.ssafy.project.model.mapper.AttractionMapper;
import com.ssafy.project.util.PageNavigation;
import com.ssafy.project.util.SizeConstant;

@Service
public class AttractionServiceImpl implements AttractionService {

	private AttractionMapper attractionMapper;

	public AttractionServiceImpl(AttractionMapper attractionMapper) {
		super();
		this.attractionMapper = attractionMapper;
	}

	private static final Logger logger = LoggerFactory.getLogger(AttractionController.class);

	@Override
	public List<AttractionDto> attractionList(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
//		String searchSidoCode = map.get("searchSidoCode");
//		param.put("key", key == null ? "" : key);
//		int searchContentTypeId = Integer.parseInt(map.get("searchContentTypeId"));
		logger.debug(map.get("searchSidoCode"));
		logger.debug(map.get("searchContentTypeId"));
		logger.debug(map.get("searchWord"));
		param.put("searchSidoCode",
				Integer.parseInt(map.get("searchSidoCode") == null ? "-1" : map.get("searchSidoCode")));
		param.put("searchContentTypeId",
				Integer.parseInt(map.get("searchContentTypeId") == null ? "-1" : map.get("searchContentTypeId")));
		param.put("searchWord", map.get("searchWord") == null ? "" : map.get("searchWord"));
		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);

		return attractionMapper.attractionList(param);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if ("userid".equals(key))
			key = "user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int totalCount = attractionMapper.getTotalAttractionCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public AttractionDto getAttraction(int contentId) throws Exception {
		return attractionMapper.getAttraction(contentId);
	}

//	@Override
//	public void updateHit(int articleNo) throws Exception {
////		attractionMapper.updateHit(articleNo);
//	}
}
