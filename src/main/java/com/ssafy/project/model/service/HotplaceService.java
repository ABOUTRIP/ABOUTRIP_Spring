package com.ssafy.project.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.HotplaceDto;
import com.ssafy.project.model.TipDto;
import com.ssafy.project.util.PageNavigation;

public interface HotplaceService {
	public boolean writeHotplace(HotplaceDto hotplaceDto) throws Exception;
	public List<HotplaceDto> listHotplace(BoardParameterDto boardParameterDto) throws Exception;
	public PageNavigation makePageNavigation(BoardParameterDto hotplaceParameterDto) throws Exception;
	
	public HotplaceDto getHotplace(int hotplaceno) throws Exception;
	public void updateHit(int hotplaceno) throws Exception;
	public boolean modifyHotplace(HotplaceDto hotplaceDto) throws Exception;
	public boolean deleteHotplace(int hotplaceno) throws Exception;
	
	public List<HotplaceDto> listMyHotplace(String userid) throws SQLException;
}
