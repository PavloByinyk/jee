package ua.training.objects;

import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

public class User {
	
	@Size(min = 6, message = "Login is too short")
	private String name;
	
	@Size(min = 5, max = 10, message = "Password is incorrect")
	private String password;
	private boolean admin;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getAdmin() {
		System.out.println("getAdmin = " + admin );
		return admin;
	}

	public void setAdmin(boolean admin) {
		System.out.println("setAdmin = " + admin );
		this.admin = admin;
	}
	
	

}
