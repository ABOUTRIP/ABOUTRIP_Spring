package com.ssafy.project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

@ApiModel(value = "NoticeDto (공지사항)", description = "공지사항 게시판")
public class NoticeDto {
	
	@ApiModelProperty(value = "글 번호")
	private int noticeId;
	
	@ApiModelProperty(value = "회원아이디")
	private String userId;
	
	@ApiModelProperty(value = "글 제목")
	private String noticeTitle;
	
	@ApiModelProperty(value = "글 내용")
	private String noticeContents;
	
	@ApiModelProperty(value = "조회수")
	private int noticeViewCnt;
	
	@ApiModelProperty(value = "작성일")
	private String noticeCreateAt;
	

	@Builder
	public NoticeDto(int noticeId, String userId, String noticeTitle, String noticeContents, int noticeViewCnt,
			String noticeCreateAt) {
		super();
		this.noticeId = noticeId;
		this.userId = userId;
		this.noticeTitle = noticeTitle;
		this.noticeContents = noticeContents;
		this.noticeViewCnt = noticeViewCnt;
		this.noticeCreateAt = noticeCreateAt;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContents() {
		return noticeContents;
	}

	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}

	public int getNoticeViewCnt() {
		return noticeViewCnt;
	}

	public void setNoticeViewCnt(int noticeViewCnt) {
		this.noticeViewCnt = noticeViewCnt;
	}

	public String getNoticeCreateAt() {
		return noticeCreateAt;
	}

	public void setNoticeCreateAt(String noticeCreateAt) {
		this.noticeCreateAt = noticeCreateAt;
	}

	@Override
	public String toString() {
		return "NoticeDto [noticeId=" + noticeId + ", userId=" + userId + ", noticeTitle=" + noticeTitle
				+ ", noticeContents=" + noticeContents + ", noticeViewCnt=" + noticeViewCnt + ", noticeCreateAt="
				+ noticeCreateAt + "]";
	}



}
