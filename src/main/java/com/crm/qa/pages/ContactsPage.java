package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BasePage;

public class ContactsPage extends BasePage {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement conatctsLabel;
	
    @FindBy(id = "first_name")
    WebElement firstName;
    
    @FindBy(id = "surname")
    WebElement lastName;
    
    @FindBy(name="client_lookup")
    WebElement company;
    
    @FindBy(css ="input[value='Load From Company']+input[value='Save']")
    WebElement save;
	
	public ContactsPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean contactsLabel() {

		return conatctsLabel.isDisplayed();
	}

	public void selectContact(String name) {

		WebElement selectContact = driver.findElement(By.xpath(
				"//a[text()='"+name+"']//parent::td" + "//preceding-sibling::td//input[@type='checkbox']"));
		selectContact.click();

	}

	public boolean contactisSelected() {

		WebElement selectContact = driver.findElement(By.xpath(
				"//a[text()='Soumya Dodamani']//parent::td" + "//preceding-sibling::td//input[@type='checkbox']"));

		return selectContact.isSelected();

	}
	
	public void createContact(String title,String fn, String ln , String comp) {
		
		WebElement selectTitle = driver.findElement(By.cssSelector("select[name='title']"));
	    Select titlename = new Select(selectTitle);
	    titlename.selectByVisibleText(title);
	    firstName.sendKeys(fn);
	    lastName.sendKeys(ln);
	    company.sendKeys(comp);
	    save.click();
	    
	}
	
	
	
	

}
