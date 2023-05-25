package com.ssafy.project.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.PlaceDto;
import com.ssafy.project.model.PlanDto;
import com.ssafy.project.util.PageNavigation;

public interface PlanService {
	public boolean writePlan(PlanDto planDto) throws Exception;
	public boolean writePlace(PlaceDto placeDto) throws Exception;
	/*
	 * public List<PlanDto> listPlan(BoardParameterDto planParameterDto) throws
	 * Exception; public PageNavigation makePageNavigation(BoardParameterDto
	 * planParameterDto) throws Exception;
	 * 
	 * public PlanDto getPlan(int planno) throws Exception; public boolean
	 * updateHit(int planno) throws Exception; public boolean updateLike(int planno)
	 * throws Exception; public boolean modifyPlan(PlanDto planDto) throws
	 * Exception; public boolean deletePlan(int planno) throws Exception;
	 * 
	 * public List<PlanDto> listMyPlan(String userid) throws SQLException;
	 */
}
