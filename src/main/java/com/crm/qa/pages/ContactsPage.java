package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement we_contactsHeader;
	
	@FindBy(name="title")
	WebElement we_title;
	
	@FindBy(id="first_name")
	WebElement we_firstname;
	
	@FindBy(id="surname")
	WebElement we_lastname;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement we_savebtn;
	
	
	public ContactsPage() {
	PageFactory.initElements(driver, this);
	
	}
	
	public boolean verifyContactsLabel() {
		return we_contactsHeader.isDisplayed();
	}

	public void createNewContact(String title,String fname,String lname) {
				Select select=new Select(driver.findElement(By.name("title")));
	//	Select select=new Select(we_title);
	//	select.selectByValue(titleval);
		select.selectByVisibleText(title);
	//	select.selectByIndex(2);
		we_firstname.sendKeys(fname);
		we_lastname.sendKeys(lname);
		we_savebtn.click();
		
		}
}
