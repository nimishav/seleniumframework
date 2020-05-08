package com.training.regression.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	private WebDriver driver; 
	
	public Login(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys("admin");
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys("admin@123"); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
}
