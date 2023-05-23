package com.ssafy.project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import lombok.Builder;

// 글 제목이 없고, 관광지 이름이 title이 되도록

@ApiModel(value = "HotplaceDto (핫플자랑하기)", description = "핫플자랑하기 게시판")
public class HotplaceDto {
	
	@ApiModelProperty(value = "글 번호")
	private int hotplaceId;
	
	@ApiModelProperty(value = "회원아이디")
	private String userId;
	
	@ApiModelProperty(value = "핫플 이름(글 제목)")
	private String hotplaceName;
	
	@ApiModelProperty(value = "핫플 설명(글 내용)")
	private String hotplaceDescription;
	
	@ApiModelProperty(value = "승인 상태")
	private int hotplaceStatus;
	
	@ApiModelProperty(value = "추천수")
	private int hotplaceLikeCnt;
	
	// hotplace_create_at은 DB상에도 남겨두지만 쓸 일은 없을 듯.
	@ApiModelProperty(value = "작성일")
	private String hotplaceCreateAt;
	
	@ApiModelProperty(value = "삭제일")
	private String hotplaceDeleteAt;
	
	@ApiModelProperty(value = "이미지")
	private byte[] img;

	public HotplaceDto(int hotplaceId, String userId, String hotplaceName, String hotplaceDescription,
			int hotplaceStatus, int hotplaceLikeCnt, String hotplaceCreateAt, String hotplaceDeleteAt, byte[] img) {
		super();
		this.hotplaceId = hotplaceId;
		this.userId = userId;
		this.hotplaceName = hotplaceName;
		this.hotplaceDescription = hotplaceDescription;
		this.hotplaceStatus = hotplaceStatus;
		this.hotplaceLikeCnt = hotplaceLikeCnt;
		this.hotplaceCreateAt = hotplaceCreateAt;
		this.hotplaceDeleteAt = hotplaceDeleteAt;
		this.img = img;
	}

	public int getHotplaceId() {
		return hotplaceId;
	}

	public void setHotplaceId(int hotplaceId) {
		this.hotplaceId = hotplaceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHotplaceName() {
		return hotplaceName;
	}

	public void setHotplaceName(String hotplaceName) {
		this.hotplaceName = hotplaceName;
	}

	public String getHotplaceDescription() {
		return hotplaceDescription;
	}

	public void setHotplaceDescription(String hotplaceDescription) {
		this.hotplaceDescription = hotplaceDescription;
	}

	public int getHotplaceStatus() {
		return hotplaceStatus;
	}

	public void setHotplaceStatus(int hotplaceStatus) {
		this.hotplaceStatus = hotplaceStatus;
	}

	public int getHotplaceLikeCnt() {
		return hotplaceLikeCnt;
	}

	public void setHotplaceLikeCnt(int hotplaceLikeCnt) {
		this.hotplaceLikeCnt = hotplaceLikeCnt;
	}

	public String getHotplaceCreateAt() {
		return hotplaceCreateAt;
	}

	public void setHotplaceCreateAt(String hotplaceCreateAt) {
		this.hotplaceCreateAt = hotplaceCreateAt;
	}

	public String getHotplaceDeleteAt() {
		return hotplaceDeleteAt;
	}

	public void setHotplaceDeleteAt(String hotplaceDeleteAt) {
		this.hotplaceDeleteAt = hotplaceDeleteAt;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "HotplaceDto [hotplaceId=" + hotplaceId + ", userId=" + userId + ", hotplaceName=" + hotplaceName
				+ ", hotplaceDescription=" + hotplaceDescription + ", hotplaceStatus=" + hotplaceStatus
				+ ", hotplaceLikeCnt=" + hotplaceLikeCnt + ", hotplaceCreateAt=" + hotplaceCreateAt
				+ ", hotplaceDeleteAt=" + hotplaceDeleteAt + ", img=" + img + "]";
	}

}
