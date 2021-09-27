package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Testutil.TestUtil;
import com.crm.qa.base.BasePage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends BasePage {
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
	
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialisation();
		testUtil = new TestUtil();
		loginPage= new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		
		String title = homePage.returnHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
		
	}
	@Test(priority=2)
	public void verifyUserNameLabel() {
		
		testUtil.switchtoFrame();
		System.out.println(homePage.getUsernameLabel());
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	

}
