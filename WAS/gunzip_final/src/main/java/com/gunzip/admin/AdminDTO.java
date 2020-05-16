package com.gunzip.admin;

public class AdminDTO {
	private String userID;
    private String password;
    private String token;
    
    public AdminDTO() {
    	
    }
    
	public AdminDTO(String userID) {
		super();
		this.userID = userID;
	}

	public AdminDTO(String userID, String password) {
		super();
		this.userID = userID;
		this.password = password;
	}

	public AdminDTO(String userID, String password, String token) {
		super();
		this.userID = userID;
		this.password = password;
		this.token = token;
	}
		
	@Override
	public String toString() {
		return "AdminDTO [userID=" + userID + ", password=" + password + ", token=" + token + "]";
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}   
}