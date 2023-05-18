package com.ssafy.project.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.project.model.SidoDto;
import com.ssafy.project.model.mapper.SidoMapper;

@Service
public class SidoServiceImpl implements SidoService {
	private SidoMapper sidoMapper;

	@Override
	public List<SidoDto> sidoList() throws SQLException {
		return sidoMapper.sidoList();
	}

	@Override
	public SidoDto getSido(int sidoCode) throws SQLException {
		return sidoMapper.getSido(sidoCode);
	}

}
