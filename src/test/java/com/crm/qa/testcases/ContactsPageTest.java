/*
 * Author is Anupam Banerjee
 * 
 */



package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Testutil.TestUtil;
import com.crm.qa.base.BasePage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends BasePage{
	
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	
	public ContactsPageTest() {
	
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialisation();
		testUtil = new TestUtil();
		loginPage= new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage= homePage.clickContacts();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		
	boolean	contactsPageLabel = contactsPage.contactsLabel();
	Assert.assertTrue(contactsPageLabel);
	}
	
	@Test(priority=2)
	public void verifyContactsSelectAction() {
		
		contactsPage.selectContact("Soumya Dodamani");
	}
	@Test(priority=3)
	public void verifyMultipleSelectActions() {
		
		contactsPage.selectContact("Soumya Dodamani");
		contactsPage.selectContact("Srihaan Kolla");
	}
	
	@Test(priority = 4)
	public void verifyContactisSelected() {
		contactsPage.selectContact("Soumya Dodamani");
		boolean var = contactsPage.contactisSelected();
		Assert.assertTrue(var);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		int a =1;
		System.out.println(a);
		Object data[][]=TestUtil.getTestData();
		return data;
	}
	
	@Test(priority=5,dataProvider = "getCRMTestData")
	public void validateCreateOnNewContact(String title,String firstName,String lastName, String Company) {
		

		homePage.clickOnNewContact();
		contactsPage.createContact(title,firstName,lastName,Company);
		
		
		
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	

}
