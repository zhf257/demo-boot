package com.siukee.demo.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.siukee.demo.annotation.PasswordEquals;

import lombok.Data;

@PasswordEquals
@Data
public class RegisterDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4977841740940736861L;

	
	@NotEmpty
    @Length(min=5,max=30)
    private String username;
    
    @NotEmpty
    private String password;
    
    @NotEmpty
    private String passwordConfirm;
}
