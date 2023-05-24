package com.ssafy.project.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.project.model.LikeInfoDto;

public interface RegionService {
	public boolean like(LikeInfoDto likeInfoDto) throws SQLException;
	public boolean cancelLike(LikeInfoDto likeInfoDto) throws SQLException;
	public List<Integer> listLike(String userid) throws SQLException;
}
