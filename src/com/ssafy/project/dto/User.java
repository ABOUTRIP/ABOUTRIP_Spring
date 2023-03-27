package com.ssafy.project.dto;

public class User {
	private String name;
	private String id;
	private String password;
	private String email;
	private String sido;
	private String gugun;
	
	public User() {
		super();
	}
	
	public User(String name, String id, String password, String email, String sido, String gugun) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.email = email;
		this.sido = sido;
		this.gugun = gugun;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", password=" + password + ", email=" + email + ", sido=" + sido
				+ ", gugun=" + gugun + "]";
	}
	
	
	
}
