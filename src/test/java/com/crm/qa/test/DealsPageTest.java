package com.crm.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {

	DealsPage dealspage;
	LoginPage loginpage;
	HomePage homepage;
	
	public DealsPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.ValidateLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
		dealspage = homepage.ValidateclickOnDealslink();
	}
	
	@Test(priority = 1)
	public void ValidateDealsLogotest()
	{
		AssertJUnit.assertTrue(dealspage.validateDealslogo());
	}
	
	@DataProvider
	public Object[] getDealsTestData()
	{
		Object dealsdata[] = TestUtil.DealsData();
		return dealsdata;
		
	}
	
	@Test(priority = 2, dataProvider = "getDealsTestData")
	public void ValidateAddNewDealstest(String Title) throws InterruptedException
	{
		dealspage.validateAddNewDeal(Title);
		Thread.sleep(10000);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
