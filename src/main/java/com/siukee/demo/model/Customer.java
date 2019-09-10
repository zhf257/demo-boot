package com.siukee.demo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3127331736502087841L;

	public Customer(String name) {
		this.name = name;
	}

	private String name;
}
