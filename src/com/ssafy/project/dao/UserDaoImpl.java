package com.ssafy.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.project.dto.User;
import com.ssafy.project.exception.DuplicateUserException;
import com.ssafy.project.exception.IDNotFoundException;
import com.ssafy.project.util.DBUtil;

public class UserDaoImpl implements IUserDao {
//	
//	public static void main(String[] args) {
//		System.out.println();
//	}
	
	private static IUserDao instance = new UserDaoImpl();
	private DBUtil db;
	private UserDaoImpl() {
		db = DBUtil.getInstance();
	}
	public static IUserDao getInstance() {
		return instance;
	}
	
	@Override
	public void insert(User user) throws DuplicateUserException {
		if (isExist(user.getId())) throw new DuplicateUserException(user.getId());
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into user(name, id, password, email, sido, gugun) values (?, ?, ?, ?, ?, ?)"; 
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getId());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getSido());
			pstmt.setString(6, user.getGugun());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, conn);
		}
		
	}

	@Override
	public void delete(String id) throws IDNotFoundException {
		if (!isExist(id)) throw new IDNotFoundException(id);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from user where id = ?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, conn);
		}
	}

	
	// id 변경은 불가능하게 함
	@Override
	public void update(User user) throws IDNotFoundException {
		if (!isExist(user.getId())) throw new IDNotFoundException();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update user "
					+ "set name=?, password=?, email=?, sido=?, gugun=? "
					+ "where id=?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getSido());
			pstmt.setString(5, user.getGugun());
			
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, conn);
		}
	}
	
	@Override
	public User select(String id) {
		String sql = "select name, id, password, email, sido, gugun "
					+ "from user "
					+ "where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		User user = null;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			
			if (result.next()) {
				user = new User(result.getString("name"),
								result.getString("id"),
								result.getString("password"),
								result.getString("email"),
								result.getString("sido"),
								result.getString("gugun")
								);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(result, pstmt, conn);
		}
			
		return user;
	}
	
	private boolean isExist(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select id from user where id = ?";
		boolean exist = false;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			exist= result.next();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(result, pstmt, conn);
		}
		
		return exist;
	}
	
}
