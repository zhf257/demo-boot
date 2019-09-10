package com.siukee.demo.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class JsonRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6141797910450662661L;

	@NotEmpty
	@Email
	private String email;

	@Pattern(regexp = "[a-zA-Z0-9_]{6,30}")
	private String name;

	@Min(5)
	@Max(199)
	private int age;
}
