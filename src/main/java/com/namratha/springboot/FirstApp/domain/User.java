package com.namratha.springboot.FirstApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserDetails")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	private Long userId;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Email")
	private String email;
	
	@Column(name = "MobileNumber")
	private Integer mobileNumber;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "OTP")
	private Integer otp;
	
	@Column(name = "ValidEmail")
	private boolean validEmail;
	
	@Column(name = "valid_OTP")
	private boolean validOtp;
	
	@Column(name = "ValidUser")
	private boolean validUser;
	

	public User() {

	}

	public User(Long userId, String firstName, String lastName, String email, Integer mobileNumber, String password,
			Integer otp, boolean validEmail, boolean validOtp, boolean validUser) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.otp = otp;
		this.validEmail = validEmail;
		this.validOtp = validOtp;
		this.validUser = validUser;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public boolean isValidEmail() {
		return validEmail;
	}

	public void setValidEmail(boolean validEmail) {
		this.validEmail = validEmail;
	}

	public boolean isValidOtp() {
		return validOtp;
	}

	public void setValidOtp(boolean validOtp) {
		this.validOtp = validOtp;
	}

	public boolean isValidUser() {
		return validUser;
	}

	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}
	
}
