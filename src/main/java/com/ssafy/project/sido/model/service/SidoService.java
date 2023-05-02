package com.ssafy.project.sido.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.project.sido.model.SidoDto;

public interface SidoService {
	List<SidoDto> sidoList() throws SQLException;

	SidoDto getSido(int sidoCode) throws SQLException;

}
