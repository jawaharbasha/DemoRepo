package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'group automation')]") //use only if element will not change
	@CacheLookup  											//speed of framework will increase store webelement in cache memory
	WebElement we_userNameLabel;       //if page refreshed cache memory object will be disturbed /throws staled element exception
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement we_contacts;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement we_deals;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement we_newContact;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickContactLink() {
		we_contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDealsLink() {
		we_deals.click();
		return new DealsPage();
	}
	
	public boolean verifyUserNameLabel() {
	
	return we_userNameLabel.isDisplayed();
	}
	
	public void clickOnNewContact()  {
		Actions action=new Actions(driver);
		action.moveToElement(we_contacts).build().perform();
		
	
		we_newContact.click();		
		
	}
	
}
