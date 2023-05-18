package com.ssafy.project.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.project.model.SidoDto;

@Mapper
public interface SidoMapper {
	List<SidoDto> sidoList() throws SQLException;
	SidoDto getSido(int sidoCode) throws SQLException;
}
