package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		testUtil= new TestUtil();
		contactPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));			
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String homePageTitle=homePage.verifyHomepageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","HomePage Title didn't matched");
	}
	
	@Test(priority=2)
	public void verifyUserName()  {
		testUtil.switchToFrame("mainpanel");
		Assert.assertEquals(true, homePage.verifyUserNameLabel());
	}
	
	@Test(priority=3)
	public void verifyContactLink() {
		testUtil.switchToFrame("mainpanel");
		contactPage=homePage.clickContactLink();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
