package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(name ="username")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(css ="input[type='submit']")
	WebElement LoginBtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
	}
	
	

}
