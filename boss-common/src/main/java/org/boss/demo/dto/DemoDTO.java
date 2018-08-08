package org.boss.demo.dto;

import org.boss.common.dto.EntityDTO;

public class DemoDTO extends EntityDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1439597477198072177L;
	
	private Integer userId;
	private String userName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
