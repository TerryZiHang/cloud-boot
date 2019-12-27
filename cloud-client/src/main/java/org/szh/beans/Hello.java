package org.szh.beans;

import java.io.Serializable;

public class Hello implements Serializable{

	private static final long serialVersionUID = 4111124426778190204L;
	
	private String name;
	
	private String greets;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreets() {
		return greets;
	}

	public void setGreets(String greets) {
		this.greets = greets;
	}
	
	
	
}
