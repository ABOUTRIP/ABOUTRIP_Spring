package com.ssafy.project.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.PlaceDto;
import com.ssafy.project.model.PlanDto;
import com.ssafy.project.model.mapper.PlanMapper;
import com.ssafy.project.util.PageNavigation;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean writePlan(PlanDto planDto) throws Exception {
		if(planDto == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(PlanMapper.class).writePlan(planDto) == 1;
	}

	@Override
	public List<PlanDto> listPlan(BoardParameterDto boardParameterDto) throws Exception {
		int start = boardParameterDto.getPg() == 0 ? 0 : (boardParameterDto.getPg() - 1) * boardParameterDto.getSpp();
		boardParameterDto.setStart(start);
		return sqlSession.getMapper(PlanMapper.class).listPlan(boardParameterDto);
	}

	@Override
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(boardParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(PlanMapper.class).getTotalCount(boardParameterDto);//총글갯수  269
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
	public PlanDto getPlan(int planno) throws Exception {
		return sqlSession.getMapper(PlanMapper.class).getPlan(planno);
	}
	
	@Override
	@Transactional
	public boolean updateHit(int planno) throws Exception {
		return sqlSession.getMapper(PlanMapper.class).updateHit(planno) == 1;
	}
	
	@Override
	@Transactional
	public boolean updateLike(int planno) throws Exception {
		return sqlSession.getMapper(PlanMapper.class).updateLike(planno) == 1;
	}
	
	@Override
	@Transactional
	public boolean modifyPlan(PlanDto planDto) throws Exception {
		return sqlSession.getMapper(PlanMapper.class).modifyPlan(planDto) == 1;
	}

	@Override
	@Transactional
	public boolean deletePlan(int planId) throws Exception {
//		sqlSession.getMapper(PlanMapper.class).deletePlan(planId);
		return sqlSession.getMapper(PlanMapper.class).deletePlan(planId) == 1;
	}

	@Override
	public List<PlanDto> listMyPlan(String userid) throws SQLException {
		return sqlSession.getMapper(PlanMapper.class).listMyPlan(userid);
	}

	@Override
	public boolean writePlace(PlaceDto placeDto) throws Exception {
		if(placeDto == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(PlanMapper.class).writePlace(placeDto) == 1;
	}
	
}
