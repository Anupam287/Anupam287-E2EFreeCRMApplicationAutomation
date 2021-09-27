package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Testutil.TestUtil;
import com.crm.qa.base.BasePage;

public class HomePage extends BasePage {

	TestUtil testUtil = new TestUtil();

	@FindBy(xpath = "//td[contains(text(),'User: group automation')]")
	@CacheLookup
	// The cache look up is a powerful tool to tore the elements in the cache memory
	// So instead of going and attacking the browser 100 times and look up for webElements 
	// it will look up in the cache memory
	//It improves the performance of the application , as time to retrive the web elemnts will be lesser
	// But if the page gets refreshed and the HTML DOM of the page changes , then this will not work
	WebElement usernameLabel;

	@FindBy(css = "a[title='Contacts']")
	public
	WebElement contactsLink;
	
	@FindBy(xpath ="//a[text()='New Contact']")
    WebElement newContactLink;

	@FindBy(css = "a[title='Deals']")
	WebElement dealsLink;

	@FindBy(css = "a[title='Tasks']")
	WebElement tasksLink;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public String returnHomePageTitle() {

		return driver.getTitle();
	}

	public String getUsernameLabel() {

		return usernameLabel.getText();
	}

	public ContactsPage clickContacts() {
		testUtil.switchtoFrame();
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickDeals() {
		testUtil.switchtoFrame();
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickTasks() {
		testUtil.switchtoFrame();
		tasksLink.click();
		return new TasksPage();
	}

	public void clickOnNewContact() {
		
		
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		testUtil.elementClickByJS(newContactLink, driver);
		
		

	}

}
