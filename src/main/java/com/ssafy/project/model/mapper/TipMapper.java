package com.ssafy.project.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.TipDto;

public interface TipMapper {
	public int writeTip(TipDto tipDto) throws SQLException;
	public List<TipDto> listTip(BoardParameterDto boardParameterDto) throws SQLException;
	public int getTotalCount(BoardParameterDto boardParameterDto) throws SQLException;
	public TipDto getTip(int tipno) throws SQLException;
	public void updateHit(int tipno) throws SQLException;
	public int modifyTip(TipDto tipDto) throws SQLException;
//	public void deleteMemo(int tipno) throws SQLException;
	public int deleteTip(int tipno) throws SQLException;
}
