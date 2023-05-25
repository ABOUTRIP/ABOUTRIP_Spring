package com.ssafy.project.model;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PlanDto (여행플랜)", description = "여행플랜 게시판")
public class PlanDto {
	
	@ApiModelProperty(value = "글 번호")
	private int planId;
	
	@ApiModelProperty(value = "회원아이디")
	private String userId;
	
	@ApiModelProperty(value = "여행 시작일")
	private String planStartDate;
	
	@ApiModelProperty(value = "여행 종료일")
	private String planEndDate;
	
	@ApiModelProperty(value = "글 제목")
	private String planTitle;
	
	@ApiModelProperty(value = "글 내용")
	private String planContents;
	
	@ApiModelProperty(value = "여행경로") // type 뭘로?
	private List<PlaceDto> planPath;
	
	@ApiModelProperty(value = "시/도 코드")
	private int planSidoCode;
	
	@ApiModelProperty(value = "구/군 코드")
	private int planGugunCode;
	
	@ApiModelProperty(value = "조회수")
	private int planViewCnt;
	
	@ApiModelProperty(value = "추천수")
	private int planLikeCnt;
	
	@ApiModelProperty(value = "작성일")
	private String planCreateAt;
	
	@ApiModelProperty(value = "삭제일")
	private String planDeleteAt;

	public PlanDto(int planId, String userId, String planStartDate, String planEndDate, String planTitle,
			String planContents, List<PlaceDto> planPath, int planSidoCode, int planGugunCode, int planViewCnt,
			int planLikeCnt, String planCreateAt, String planDeleteAt) {
		super();
		this.planId = planId;
		this.userId = userId;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.planTitle = planTitle;
		this.planContents = planContents;
		this.planPath = planPath;
		this.planSidoCode = planSidoCode;
		this.planGugunCode = planGugunCode;
		this.planViewCnt = planViewCnt;
		this.planLikeCnt = planLikeCnt;
		this.planCreateAt = planCreateAt;
		this.planDeleteAt = planDeleteAt;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getPlanTitle() {
		return planTitle;
	}

	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}

	public String getPlanContents() {
		return planContents;
	}

	public void setPlanContents(String planContents) {
		this.planContents = planContents;
	}

	public List<PlaceDto> getPlanPath() {
		return planPath;
	}

	public void setPlanPath(List<PlaceDto> planPath) {
		this.planPath = planPath;
	}

	public int getPlanSidoCode() {
		return planSidoCode;
	}

	public void setPlanSidoCode(int planSidoCode) {
		this.planSidoCode = planSidoCode;
	}

	public int getPlanGugunCode() {
		return planGugunCode;
	}

	public void setPlanGugunCode(int planGugunCode) {
		this.planGugunCode = planGugunCode;
	}

	public int getPlanViewCnt() {
		return planViewCnt;
	}

	public void setPlanViewCnt(int planViewCnt) {
		this.planViewCnt = planViewCnt;
	}

	public int getPlanLikeCnt() {
		return planLikeCnt;
	}

	public void setPlanLikeCnt(int planLikeCnt) {
		this.planLikeCnt = planLikeCnt;
	}

	public String getPlanCreateAt() {
		return planCreateAt;
	}

	public void setPlanCreateAt(String planCreateAt) {
		this.planCreateAt = planCreateAt;
	}

	public String getPlanDeleteAt() {
		return planDeleteAt;
	}

	public void setPlanDeleteAt(String planDeleteAt) {
		this.planDeleteAt = planDeleteAt;
	}

	@Override
	public String toString() {
		return "PlanDto [planId=" + planId + ", userId=" + userId + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", planTitle=" + planTitle + ", planContents=" + planContents
				+ ", planPath=" + planPath + ", planSidoCode=" + planSidoCode + ", planGugunCode=" + planGugunCode
				+ ", planViewCnt=" + planViewCnt + ", planLikeCnt=" + planLikeCnt + ", planCreateAt=" + planCreateAt
				+ ", planDeleteAt=" + planDeleteAt + "]";
	}

}
