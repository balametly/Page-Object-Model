package com.crm.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	CalendarPage calendarpage;
	DealsPage dealspage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUP()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.ValidateLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void ValidateHomePageUserNameDisplayTest()
	{
		AssertJUnit.assertTrue(homepage.validateUserNameDisplay());
	}
	
	@Test
	public void ValidateClickOnContactsLinkTest()
	{
		homepage.ValidateclickOnContactslink();
	}
	
	@Test
	public void ValidateClickOnCCalendarLinkTest()
	{
		homepage.ValidateclickOnCalendarlink();
	}
	
	@Test
	public void ValidateClickOnDealssLinkTest()
	{
		homepage.ValidateclickOnDealslink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
