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
	private int tipViewCnt;
	
	@ApiModelProperty(value = "추천수")
	private int tipLikeCnt;
	
	@ApiModelProperty(value = "작성일")
	private String tipCreateAt;
	
	@ApiModelProperty(value = "삭제일")
	private String tipDeleteAt;

	public TipDto(int tipId, String userId, String tipTitle, String tipContents, int tipViewCnt, int tipLikeCnt,
			String tipCreateAt, String tipDeleteAt) {
		super();
		this.tipId = tipId;
		this.userId = userId;
		this.tipTitle = tipTitle;
		this.tipContents = tipContents;
		this.tipViewCnt = tipViewCnt;
		this.tipLikeCnt = tipLikeCnt;
		this.tipCreateAt = tipCreateAt;
		this.tipDeleteAt = tipDeleteAt;
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

	public int getTipViewCnt() {
		return tipViewCnt;
	}

	public void setTipViewCnt(int tipViewCnt) {
		this.tipViewCnt = tipViewCnt;
	}

	public int getTipLikeCnt() {
		return tipLikeCnt;
	}

	public void setTipLikeCnt(int tipLikeCnt) {
		this.tipLikeCnt = tipLikeCnt;
	}

	public String getTipCreateAt() {
		return tipCreateAt;
	}

	public void setTipCreateAt(String tipCreateAt) {
		this.tipCreateAt = tipCreateAt;
	}

	public String getTipDeleteAt() {
		return tipDeleteAt;
	}

	public void setTipDeleteAt(String tipDeleteAt) {
		this.tipDeleteAt = tipDeleteAt;
	}

	@Override
	public String toString() {
		return "TipDto [tipId=" + tipId + ", userId=" + userId + ", tipTitle=" + tipTitle + ", tipContents="
				+ tipContents + ", tipViewCnt=" + tipViewCnt + ", tipLikeCnt=" + tipLikeCnt
				+ ", tipCreateAt=" + tipCreateAt + ", tipDeleteAt=" + tipDeleteAt + "]";
	}
}
