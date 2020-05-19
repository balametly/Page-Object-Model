package com.crm.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest()
	{
	super();	
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		loginpage = new LoginPage();
		
	}
	
	@Test
	public void LoginPageTitleTest()
	{
		String loginpagetitle = loginpage.ValidateLoginPageTitle();
		AssertJUnit.assertEquals(loginpagetitle, "Cogmento CRM");
	}
	
	@Test
	public void ForgotLinkTest()
	{
		AssertJUnit.assertTrue(loginpage.ValidateForgotPasswordLinkAvailability());
	}
	
	@Test
	public void LoginBtnTest()
	{
		homepage = loginpage.ValidateLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
