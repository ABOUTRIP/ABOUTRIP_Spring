package com.ssafy.project.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.TipDto;
import com.ssafy.project.model.mapper.TipMapper;
import com.ssafy.project.util.PageNavigation;

@Service
public class TipServiceImpl implements TipService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean writeTip(TipDto tipDto) throws Exception {
		if(tipDto.getTipTitle() == null || tipDto.getTipContents() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(TipMapper.class).writeTip(tipDto) == 1;
	}

	@Override
	public List<TipDto> listTip(BoardParameterDto boardParameterDto) throws Exception {
		int start = boardParameterDto.getPg() == 0 ? 0 : (boardParameterDto.getPg() - 1) * boardParameterDto.getSpp();
		boardParameterDto.setStart(start);
		return sqlSession.getMapper(TipMapper.class).listTip(boardParameterDto);
	}

	@Override
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(boardParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(TipMapper.class).getTotalCount(boardParameterDto);//총글갯수  269
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
	public TipDto getTip(int tipno) throws Exception {
		return sqlSession.getMapper(TipMapper.class).getTip(tipno);
	}
	
	@Override
	public void updateHit(int tipno) throws Exception {
		sqlSession.getMapper(TipMapper.class).updateHit(tipno);
	}

	@Override
	@Transactional
	public boolean modifyTip(TipDto tipDto) throws Exception {
		return sqlSession.getMapper(TipMapper.class).modifyTip(tipDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteTip(int tipId) throws Exception {
		sqlSession.getMapper(TipMapper.class).deleteTip(tipId);
		return sqlSession.getMapper(TipMapper.class).deleteTip(tipId) == 1;
	}
	
	
	
}
