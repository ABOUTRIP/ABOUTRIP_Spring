package com.ssafy.project.model.service;

import java.util.List;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.TipDto;
import com.ssafy.project.util.PageNavigation;

public interface TipService {
	public boolean writeTip(TipDto tipDto) throws Exception;
	public List<TipDto> listTip(BoardParameterDto tipParameterDto) throws Exception;
	public PageNavigation makePageNavigation(BoardParameterDto tipParameterDto) throws Exception;
	
	public TipDto getTip(int tipno) throws Exception;
	public boolean updateHit(int tipno) throws Exception;
	public boolean updateLike(int tipno) throws Exception;
	public boolean modifyTip(TipDto tipDto) throws Exception;
	public boolean deleteTip(int tipno) throws Exception;
}
