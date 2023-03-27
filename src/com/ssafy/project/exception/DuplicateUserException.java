package com.ssafy.project.exception;

public class DuplicateUserException extends Exception {
	
	public DuplicateUserException() {
		super("이미 존재하는 ID입니다.");
	}
	
	public DuplicateUserException(String id) {
		super(id + "는 이미 존재하는 ID입니다.");
	}
}
