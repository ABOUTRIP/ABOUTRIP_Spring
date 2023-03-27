package com.ssafy.project.service;

import com.ssafy.project.dto.User;
import com.ssafy.project.exception.AuthenticationException;
import com.ssafy.project.exception.DuplicateUserException;
import com.ssafy.project.exception.IDNotFoundException;

public interface IUserService {
	User login(String id, String password) throws AuthenticationException;
	
	public abstract void add(User user) throws DuplicateUserException;
	public abstract void remove(String id) throws IDNotFoundException;
	public abstract void update(User user) throws IDNotFoundException;
	public abstract User SearchById(String id) throws IDNotFoundException;
	
}
