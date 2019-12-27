package org.szh.beans;

import java.io.Serializable;

import lombok.Data;

@Data
public class Hello implements Serializable{

	private static final long serialVersionUID = 4111124426778190204L;
	
	private String name;
	
	private String greets;
	
}
