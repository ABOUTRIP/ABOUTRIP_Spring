package com.ssafy.project.model.service;

import java.util.List;

import com.ssafy.project.model.BoardParameterDto;
import com.ssafy.project.model.NoticeDto;
import com.ssafy.project.util.PageNavigation;

public interface NoticeService {
	
	public boolean writeNotice(NoticeDto noticeDto) throws Exception;
	public List<NoticeDto> listNotice(BoardParameterDto noticeParameterDto) throws Exception;
	public PageNavigation makePageNavigation(BoardParameterDto noticeParameterDto) throws Exception;
	
	public NoticeDto getNotice(int noticeno) throws Exception;
//	public void updateHit(int noticeno) throws Exception;
	public boolean modifyNotice(NoticeDto noticeDto) throws Exception;
	public boolean deleteNotice(int noticeno) throws Exception;
}
