package com.ssafy.project.exception;

public class IDNotFoundException extends Exception {
	
	private String id;
	
	public IDNotFoundException() {
		super("해당 ID가 존재하지 않습니다.");
	}
	
	public IDNotFoundException(String id) {
		super(id + " ID가 존재하지 않습니다.");
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
