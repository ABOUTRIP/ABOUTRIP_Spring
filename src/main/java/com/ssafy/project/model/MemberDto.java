package com.ssafy.project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

@ApiModel(value = "MemberDto (회원정보)", description = "아이디, 비번, 이름.을 가진   Domain Class")
public class MemberDto {

	@ApiModelProperty(value = "회원아이디")
	private String userId;
	@ApiModelProperty(value = "회원이름")
	private String userName;
	@ApiModelProperty(value = "회원비밀번호")
	private String userPwd;
	@ApiModelProperty(value = "이메일")
	private String email;
	@ApiModelProperty(value = "어드민 여부")
	private char isAdmin;
	@ApiModelProperty(value = "시/도 코드")
	private int sidoCode;
	@ApiModelProperty(value = "구/군 코드")
	private int gugunCode;
	@ApiModelProperty(value = "가입일")
	private String joinDate;
	@ApiModelProperty(value = "탈퇴일")
	private String deleteAt;
	
	@Builder
	public MemberDto(String userId, String userName, String userPwd, String email, char isAdmin, int sidoCode,
			int gugunCode, String joinDate, String deleteAt) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.email = email;
		this.isAdmin = isAdmin;
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.joinDate = joinDate;
		this.deleteAt = deleteAt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(char isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}

	public int getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getDeleteAt() {
		return deleteAt;
	}

	public void setDeleteAt(String deleteAt) {
		this.deleteAt = deleteAt;
	}

	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", email=" + email
				+ ", isAdmin=" + isAdmin + ", sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + ", joinDate="
				+ joinDate + ", deleteAt=" + deleteAt + "]";
	}
	
}
