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
	
//	@ApiModelProperty(value = "조회수")
//	private int noticeViewCnt;
	
	@ApiModelProperty(value = "작성일")
	private String noticeCreateAt;
	
	@ApiModelProperty(value = "삭제일")
	private String noticeDeleteAt;

	public NoticeDto(int noticeId, String userId, String noticeTitle, String noticeContents, String noticeCreateAt,
			String noticeDeleteAt) {
		super();
		this.noticeId = noticeId;
		this.userId = userId;
		this.noticeTitle = noticeTitle;
		this.noticeContents = noticeContents;
		this.noticeCreateAt = noticeCreateAt;
		this.noticeDeleteAt = noticeDeleteAt;
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

	public String getNoticeCreateAt() {
		return noticeCreateAt;
	}

	public void setNoticeCreateAt(String noticeCreateAt) {
		this.noticeCreateAt = noticeCreateAt;
	}

	public String getNoticeDeleteAt() {
		return noticeDeleteAt;
	}

	public void setNoticeDeleteAt(String noticeDeleteAt) {
		this.noticeDeleteAt = noticeDeleteAt;
	}

	@Override
	public String toString() {
		return "NoticeDto [noticeId=" + noticeId + ", userId=" + userId + ", noticeTitle=" + noticeTitle
				+ ", noticeContents=" + noticeContents + ", noticeCreateAt=" + noticeCreateAt + ", noticeDeleteAt="
				+ noticeDeleteAt + "]";
	}
	
}
