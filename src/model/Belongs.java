package model;

import java.io.Serializable;

public class Belongs implements Serializable {
	private String groupid;
	private String userId;
	
	public Belongs () {
		super();
	}
		
	public String getGroupid() {
		return groupid;
	}
	
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
