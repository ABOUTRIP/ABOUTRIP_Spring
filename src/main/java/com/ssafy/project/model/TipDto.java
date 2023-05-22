package com.ssafy.project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import lombok.Builder;

@ApiModel(value = "TipDto (여행정보공유)", description = "여행정보공유 게시판")
public class TipDto {
	
	@ApiModelProperty(value = "글 번호")
	private int tipId;
	
	@ApiModelProperty(value = "회원아이디")
	private String userId;
	
	@ApiModelProperty(value = "글 제목")
	private String tipTitle;
	
	@ApiModelProperty(value = "글 내용")
	private String tipContents;
	
	@ApiModelProperty(value = "조회수")
	private int noticeViewCnt;
	
	@ApiModelProperty(value = "작성일")
	private String noticeCreateAt;
	
	@ApiModelProperty(value = "삭제일")
	private String noticeDeleteAt;

	public TipDto(int tipId, String userId, String tipTitle, String tipContents, int noticeViewCnt,
			String noticeCreateAt, String noticeDeleteAt) {
		super();
		this.tipId = tipId;
		this.userId = userId;
		this.tipTitle = tipTitle;
		this.tipContents = tipContents;
		this.noticeViewCnt = noticeViewCnt;
		this.noticeCreateAt = noticeCreateAt;
		this.noticeDeleteAt = noticeDeleteAt;
	}

	public int getTipId() {
		return tipId;
	}

	public void setTipId(int tipId) {
		this.tipId = tipId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTipTitle() {
		return tipTitle;
	}

	public void setTipTitle(String tipTitle) {
		this.tipTitle = tipTitle;
	}

	public String getTipContents() {
		return tipContents;
	}

	public void setTipContents(String tipContents) {
		this.tipContents = tipContents;
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

	public String getNoticeDeleteAt() {
		return noticeDeleteAt;
	}

	public void setNoticeDeleteAt(String noticeDeleteAt) {
		this.noticeDeleteAt = noticeDeleteAt;
	}

	@Override
	public String toString() {
		return "TipsDto [tipId=" + tipId + ", userId=" + userId + ", tipTitle=" + tipTitle + ", tipContents="
				+ tipContents + ", noticeViewCnt=" + noticeViewCnt + ", noticeCreateAt=" + noticeCreateAt
				+ ", noticeDeleteAt=" + noticeDeleteAt + "]";
	}
	
	

}
