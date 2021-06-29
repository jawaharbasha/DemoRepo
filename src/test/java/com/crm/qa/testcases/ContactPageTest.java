package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage; 
	TestUtil testUtil;
	
	String sheetName="contacts";
	
	public  ContactPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame("mainpanel");
		contactsPage=homePage.clickContactLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactPageTest() {
		
		boolean contactlbl=contactsPage.verifyContactsLabel();
		Assert.assertEquals(true, contactlbl);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	
		
	@Test(priority=2,dataProvider="getCRMTestData")  //3rows of data so 3 times will execute
	public void fillContactsPage(String title,String fname,String lname)   {
		homePage.clickOnNewContact();
		//contactsPage.createNewContact("Mr.", "jb", "bas");
		contactsPage.createNewContact(title, fname, lname);
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
