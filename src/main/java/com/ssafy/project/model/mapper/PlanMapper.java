package com.ssafy.project.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.PlaceDto;
import com.ssafy.project.model.PlanDto;

public interface PlanMapper {
	public int writePlan(PlanDto planDto) throws SQLException;
	public int writePlace(PlaceDto placeDto) throws SQLException;
	/*
	 * public List<PlanDto> listPlan(BoardParameterDto boardParameterDto) throws
	 * SQLException; public int getTotalCount(BoardParameterDto boardParameterDto)
	 * throws SQLException; public PlanDto getPlan(int planno) throws SQLException;
	 * public int updateHit(int planno) throws SQLException; public int
	 * updateLike(int planno) throws SQLException; public int modifyPlan(PlanDto
	 * planDto) throws SQLException; // public void deleteMemo(int planno) throws
	 * SQLException; public int deletePlan(int planno) throws SQLException;
	 * 
	 * public List<PlanDto> listMyPlan(String userid) throws SQLException;
	 */
}
