package com.ssafy.project.model;

public class LikeInfoDto {
	
	private String userId;
	private int contentId;
	
	public LikeInfoDto(String userId, int contentId) {
		super();
		this.userId = userId;
		this.contentId = contentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
}
