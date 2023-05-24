package com.ssafy.project.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.model.LikeInfoDto;
import com.ssafy.project.model.mapper.RegionMapper;

@Service
public class RegionServiceImpl implements RegionService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean like(LikeInfoDto likeInfoDto) throws SQLException {
		return sqlSession.getMapper(RegionMapper.class).like(likeInfoDto) == 1;
	}

	@Override
	public boolean cancelLike(LikeInfoDto likeInfoDto) throws SQLException {
		return sqlSession.getMapper(RegionMapper.class).cancelLike(likeInfoDto) == 1;
	}

	@Override
	public List<Integer> listLike(String userid) throws SQLException {
		return sqlSession.getMapper(RegionMapper.class).listLike(userid);
	}
}
