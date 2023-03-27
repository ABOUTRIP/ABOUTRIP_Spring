package com.ssafy.project.service;

import com.ssafy.project.dao.IUserDao;
import com.ssafy.project.dao.UserDaoImpl;
import com.ssafy.project.dto.User;
import com.ssafy.project.exception.AuthenticationException;
import com.ssafy.project.exception.DuplicateUserException;
import com.ssafy.project.exception.IDNotFoundException;

public class UserServiceImpl implements IUserService {
	private static IUserService instance = new UserServiceImpl();
	private IUserDao dao;
	
	private UserServiceImpl() {
		dao = UserDaoImpl.getInstance();
	}
	
	public static IUserService getInstance() {
		return instance;
	}
	
	@Override
	public User login(String id, String password) throws AuthenticationException{
		User user = dao.select(id);
		if(user != null  && user.getPassword().equals(password)) {
			return user;
		}
		throw new AuthenticationException();
	}


	@Override
	public void add(User user) throws DuplicateUserException {
		dao.insert(user);
	}

	@Override
	public void remove(String id) throws IDNotFoundException {
		dao.delete(id);
	}

	@Override
	public void update(User user) throws IDNotFoundException {
		dao.update(user);
	}

	@Override
	public User SearchById(String id) throws IDNotFoundException {
		return dao.select(id);
	}
	
}
