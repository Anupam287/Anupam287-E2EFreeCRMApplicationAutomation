package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BasePage;

import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends BasePage{
	
	LoginPage loginPage;
	
	
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initialisation();
		loginPage = new LoginPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	
	
	@Test(priority=1)
	public void verifyLoginpPageTitle() {
		
		String title = loginPage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void successfulLogin() {
		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

}
