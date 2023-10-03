package com.candela.auth.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LogReg { //no es una entidad, lo usamos para validar a los usuarios ya registrados
	
	@NotBlank(message="Enter an e-mail address")
    @Email(message="The e-mail address is incorrect")
    private String email;
    
    @NotBlank(message="Enter a password")
    @Size(min=8, max=64, message="Password must be 8-64 characters long")
    private String password;
    
    public LogReg() {
    	
    }
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
