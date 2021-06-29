package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	Logger log=  Logger.getLogger(LoginPageTest.class);  //logger log4j
	
	public LoginPageTest() {
				super();
	}
	
	@BeforeMethod
	public  void setup()
	{
		initialization();
		log.info("INITIALIZATION HAPPENED");

		loginPage=new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		System.out.println("Original Title : " +title);
		//Assert.assertEquals(title, "My Store"); 
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");  
		
		
	}
	//@Test(priority=2)
	public void loginPageLogoTest() {
		boolean flag=loginPage.validateLoginPageImage();
		Assert.assertTrue(flag);
	}
	
	//@Test(priority=3)
	public void loginTest()
	{
		homepage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
