package org.cn.kkl.sb.entity;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * network transmit and version control
	 */
	private static final long serialVersionUID = -1957843456346989509L;
	
	private String username;

    private String password;

    private Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
    
    


}
