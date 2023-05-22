package com.ssafy.project.model.service;

import com.ssafy.project.model.BoardParameterDto;

public class BoardProperty {

	BoardParameterDto boardParameterDto;
	String token;

	public BoardProperty(BoardParameterDto boardParameterDto, String token) {
		super();
		this.boardParameterDto = boardParameterDto;
		this.token = token;
	}

	public BoardParameterDto getBoardParameterDto() {
		return boardParameterDto;
	}

	public void setBoardParameterDto(BoardParameterDto boardParameterDto) {
		this.boardParameterDto = boardParameterDto;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "BoardProperty [boardParameterDto=" + boardParameterDto + ", token=" + token + "]";
	}
}