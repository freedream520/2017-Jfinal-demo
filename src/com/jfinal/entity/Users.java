package com.jfinal.entity;

import com.jfinal.plugin.activerecord.Model;

public class Users extends Model<Users>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Users dao=new Users();
	
	private String id ;
	private String name;
	private String username;
	private String pwd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return get("username");
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return get("pwd");
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
