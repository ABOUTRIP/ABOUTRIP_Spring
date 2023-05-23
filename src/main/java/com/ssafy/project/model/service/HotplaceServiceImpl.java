package com.ssafy.project.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.HotplaceDto;
import com.ssafy.project.model.mapper.HotplaceMapper;
import com.ssafy.project.util.PageNavigation;

@Service
public class HotplaceServiceImpl implements HotplaceService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean writeHotplace(HotplaceDto hotplaceDto) throws Exception {
		if(hotplaceDto.getHotplaceName() == null || hotplaceDto.getHotplaceDescription() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(HotplaceMapper.class).writeHotplace(hotplaceDto) == 1;
	}

	@Override
	public List<HotplaceDto> listHotplace(BoardParameterDto boardParameterDto) throws Exception {
		int start = boardParameterDto.getPg() == 0 ? 0 : (boardParameterDto.getPg() - 1) * boardParameterDto.getSpp();
		boardParameterDto.setStart(start);
		return sqlSession.getMapper(HotplaceMapper.class).listHotplace(boardParameterDto);
	}

	@Override
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(boardParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(HotplaceMapper.class).getTotalCount(boardParameterDto);//총글갯수  269
		pageNavigation.setTotalCount(totalCount);  
		int totalPageCount = (totalCount - 1) / boardParameterDto.getSpp() + 1;//27
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = boardParameterDto.getPg() <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < boardParameterDto.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public HotplaceDto getHotplace(int hotplaceno) throws Exception {
		return sqlSession.getMapper(HotplaceMapper.class).getHotplace(hotplaceno);
	}
	
	@Override
	public void updateHit(int hotplaceno) throws Exception {
		sqlSession.getMapper(HotplaceMapper.class).updateHit(hotplaceno);
	}

	@Override
	@Transactional
	public boolean modifyHotplace(HotplaceDto hotplaceDto) throws Exception {
		return sqlSession.getMapper(HotplaceMapper.class).modifyHotplace(hotplaceDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteHotplace(int hotplaceId) throws Exception {
//		sqlSession.getMapper(HotplaceMapper.class).deleteHotplace(hotplaceId);
		return sqlSession.getMapper(HotplaceMapper.class).deleteHotplace(hotplaceId) == 1;
	}
	
	
}
