package com.ssafy.project.model.mapper;

import java.sql.SQLException;

import com.ssafy.project.model.NoticeDto;

public interface NoticeMapper {
	public int writeNotice(NoticeDto noticeDto) throws SQLException;
//	public List<NoticeDto> listNotice(NoticeParameterDto noticeParameterDto) throws SQLException;
//	public int getTotalCount(NoticeParameterDto noticeParameterDto) throws SQLException;
	public NoticeDto getNotice(int noticeno) throws SQLException;
//	public void updateHit(int noticeno) throws SQLException;
	public int modifyNotice(NoticeDto noticeDto) throws SQLException;
//	public void deleteMemo(int noticeno) throws SQLException;
	public int deleteNotice(int noticeno) throws SQLException;
//	void writeNotice(NoticeDto noticeDto) throws SQLException;
////	List<NoticeDto> listNotice(NoticeParameterDto noticeParameterDto) throws SQLException;
////	int getTotalCount(NoticeParameterDto noticeParameterDto) throws SQLException;
//	NoticeDto getNotice(int noticeId) throws SQLException;
//	int modifyNotice(NoticeDto noticeDto) throws SQLException;
////	public void deleteMemo(int noticeno) throws SQLException;
//	void deleteNotice(int noticeId) throws SQLException;
	
}
