package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
	
	//Page object factory
	
//	@FindBy(xpath="//a[@title='Log in to your customer account']")
//	WebElement singinLink;
//	
//	@FindBy(id="email")
//	WebElement we_username;
//	
//	@FindBy(id="passwd")
//	WebElement we_password;
//	
//	@FindBy(id="SubmitLogin")
//	WebElement we_loginbtn;
//	
//	@FindBy(xpath="//a[contains(text(),'Sign in')]")
//	WebElement we_singinlink;
//	
//	@FindBy(xpath="//img[@alt='My Store']")
//	//@FindBy(xpath="//img[contains(@alt,'My Store']")
//	WebElement we_loginPageImg;
	
	
	@FindBy(name="username")
	WebElement we_username;
	
	@FindBy(name="password")
	WebElement we_password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement we_loginbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement we_loginPageImg;
	
		
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLoginPageImage()
	{
		return we_loginPageImg.isDisplayed();
	}
	
	public HomePage login(String uname,String pswd ) {
		//we_singinlink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		we_username.sendKeys(uname);
		we_password.sendKeys(pswd);
		we_loginbtn.click();
		
		return new HomePage();
	}
	
}
