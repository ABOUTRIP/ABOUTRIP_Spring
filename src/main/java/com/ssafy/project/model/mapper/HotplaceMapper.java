package com.ssafy.project.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.HotplaceDto;
import com.ssafy.project.model.service.BoardProperty;

public interface HotplaceMapper {
	public int writeHotplace(HotplaceDto hotplaceDto) throws SQLException;
	public List<HotplaceDto> listHotplace(BoardParameterDto boardParameterDto) throws SQLException;
	public int getTotalCount(BoardParameterDto boardParameterDto) throws SQLException;
	public HotplaceDto getHotplace(int hotplaceno) throws SQLException;
	public void updateHit(int hotplaceno) throws SQLException;
	public int modifyHotplace(HotplaceDto hotplaceDto) throws SQLException;
//	public void deleteMemo(int hotplaceno) throws SQLException;
	public int deleteHotplace(int hotplaceno) throws SQLException;
}