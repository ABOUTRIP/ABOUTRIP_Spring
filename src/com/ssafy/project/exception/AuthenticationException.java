package com.ssafy.project.exception;

public class AuthenticationException extends Exception {

	public AuthenticationException() {
		super("아이디와 비밀번호를 확인하세요");
	}

	public AuthenticationException(String message) {
		super(message+ "아이디와 비밀번호를 확인하세요");
	}

}
