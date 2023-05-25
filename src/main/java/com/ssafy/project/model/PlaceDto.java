package com.ssafy.project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PlaceDto (장소 긁은 것 정보)", description = "장소 긁은 것 정보")
public class PlaceDto {
	
	@ApiModelProperty(value = "글 번호")
	private String id;
	 
	@ApiModelProperty(value = "주소")
	private String address_name;
	
	@ApiModelProperty(value = "category_group_code")
	private String category_group_code;
	
	@ApiModelProperty(value = "category_group_name")
	private String category_group_name;
	
	@ApiModelProperty(value = "category_name")
	private String category_name;
	
	@ApiModelProperty(value = "거리")
	private String distance;
	
	@ApiModelProperty(value = "전화번호")
	private String phone;
	
	@ApiModelProperty(value = "장소 이름")
	private String place_name;
	
	@ApiModelProperty(value = "url")
	private String place_url;
	
	@ApiModelProperty(value = "도로명주소")
	private String road_address_name;
	
	@ApiModelProperty(value = "x 좌표")
	private String x;
	
	@ApiModelProperty(value = "y 좌표")
	private String y;
	
	@ApiModelProperty(value = "day")
	private int day;
	
	@ApiModelProperty(value = "order")
	private int order;
	
	@ApiModelProperty(value = "plan_id")
	private String plan_id;
	
	@ApiModelProperty(value = "user_id")
	private String user_id;

	public PlaceDto(String id, String address_name, String category_group_code, String category_group_name,
			String category_name, String distance, String phone, String place_name, String place_url,
			String road_address_name, String x, String y, int day, int order, String plan_id, String user_id) {
		super();
		this.id = id;
		this.address_name = address_name;
		this.category_group_code = category_group_code;
		this.category_group_name = category_group_name;
		this.category_name = category_name;
		this.distance = distance;
		this.phone = phone;
		this.place_name = place_name;
		this.place_url = place_url;
		this.road_address_name = road_address_name;
		this.x = x;
		this.y = y;
		this.day = day;
		this.order = order;
		this.plan_id = plan_id;
		this.user_id = user_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

	public String getCategory_group_code() {
		return category_group_code;
	}

	public void setCategory_group_code(String category_group_code) {
		this.category_group_code = category_group_code;
	}

	public String getCategory_group_name() {
		return category_group_name;
	}

	public void setCategory_group_name(String category_group_name) {
		this.category_group_name = category_group_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public String getPlace_url() {
		return place_url;
	}

	public void setPlace_url(String place_url) {
		this.place_url = place_url;
	}

	public String getRoad_address_name() {
		return road_address_name;
	}

	public void setRoad_address_name(String road_address_name) {
		this.road_address_name = road_address_name;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "PlaceDto [id=" + id + ", address_name=" + address_name + ", category_group_code=" + category_group_code
				+ ", category_group_name=" + category_group_name + ", category_name=" + category_name + ", distance="
				+ distance + ", phone=" + phone + ", place_name=" + place_name + ", place_url=" + place_url
				+ ", road_address_name=" + road_address_name + ", x=" + x + ", y=" + y + ", day=" + day + ", order="
				+ order + ", plan_id=" + plan_id + ", user_id=" + user_id + "]";
	}

}
