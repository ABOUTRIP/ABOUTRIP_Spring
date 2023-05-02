package com.ssafy.project.member.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.project.member.model.MemberDto;

@Mapper
public interface MemberMapper {

	int idCheck(String userId) throws SQLException;
	void joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(Map<String, String> map) throws SQLException;
	
	/* Admin */
	List<MemberDto> listMember(Map<String, Object> map) throws SQLException;
	MemberDto getMember(String userId) throws SQLException;
	void updateMember(MemberDto memberDto) throws SQLException;
	void deleteMember(String userId) throws SQLException;
	
}
