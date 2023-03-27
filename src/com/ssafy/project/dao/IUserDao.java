package com.ssafy.project.dao;

import com.ssafy.project.dto.User;
import com.ssafy.project.exception.DuplicateUserException;
import com.ssafy.project.exception.IDNotFoundException;

public interface IUserDao {
	void insert(User user) throws DuplicateUserException; // 가입
	void delete(String id) throws IDNotFoundException; // 탈퇴
	void update(User user) throws IDNotFoundException; // 수정
	User select(String id); // 조회
}
