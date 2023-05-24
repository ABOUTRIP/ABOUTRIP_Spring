package com.ssafy.project.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.project.model.LikeInfoDto;

public interface RegionMapper {
	public int like(LikeInfoDto likeInfoDto) throws SQLException;
	public int cancelLike(LikeInfoDto likeInfoDto) throws SQLException;
	public List<Integer> listLike(String userid) throws SQLException;
}
