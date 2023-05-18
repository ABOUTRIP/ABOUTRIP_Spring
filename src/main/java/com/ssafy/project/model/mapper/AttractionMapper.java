package com.ssafy.project.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.project.model.AttractionDto;

@Mapper
public interface AttractionMapper {

	List<AttractionDto> attractionList(Map<String, Object> param) throws SQLException;

	int getTotalAttractionCount(Map<String, Object> param) throws SQLException;

	AttractionDto getAttraction(int articleNo) throws SQLException;


}