package com.atlassian.plugins.tutorial.rest;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleUser {

	@XmlElement
    private String email;
    
	@XmlElement
    private String fullName;
    
	@XmlElement
    private String name;

    public SimpleUser() {
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}