package com.ssafy.project.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.NoticeDto;
import com.ssafy.project.model.mapper.NoticeMapper;
import com.ssafy.project.util.PageNavigation;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean writeNotice(NoticeDto noticeDto) throws Exception {
		if(noticeDto.getNoticeTitle() == null || noticeDto.getNoticeContents() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(NoticeMapper.class).writeNotice(noticeDto) == 1;
	}

	@Override
	public List<NoticeDto> listNotice(BoardParameterDto boardParameterDto) throws Exception {
		int start = boardParameterDto.getPg() == 0 ? 0 : (boardParameterDto.getPg() - 1) * boardParameterDto.getSpp();
		boardParameterDto.setStart(start);
		return sqlSession.getMapper(NoticeMapper.class).listNotice(boardParameterDto);
	}

	@Override
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(boardParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(NoticeMapper.class).getTotalCount(boardParameterDto);//총글갯수  269
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
	public NoticeDto getNotice(int noticeno) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).getNotice(noticeno);
	}
	
//	@Override
//	public void updateHit(int noticeno) throws Exception {
//		sqlSession.getMapper(NoticeMapper.class).updateHit(noticeno);
//	}

	@Override
	@Transactional
	public boolean modifyNotice(NoticeDto noticeDto) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).modifyNotice(noticeDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteNotice(int noticeId) throws Exception {
		sqlSession.getMapper(NoticeMapper.class).deleteNotice(noticeId);
		return sqlSession.getMapper(NoticeMapper.class).deleteNotice(noticeId) == 1;
	}
	
	

}
