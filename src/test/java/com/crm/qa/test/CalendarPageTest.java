package com.crm.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;
import com.crm.qa.util.TestUtil;

public class CalendarPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	CalendarPage calendarpage;
	
	
	public CalendarPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.ValidateLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(15000);
		calendarpage = homepage.ValidateclickOnCalendarlink();
		Thread.sleep(15000);
	}

	@Test
	public void ValidateSyncNowBtnavailabilitytest()
	{
		AssertJUnit.assertTrue(calendarpage.validateSyncNowBtnavailability());
	}
	
	/*@Test(priority = 1)
	public void ValidateSelectContactTest()
	{
		String Nametobeselected = "bala B";
		//String Name2tobeselected = "Dilip kumar";
		contactspage.ValidateSelectContact(Nametobeselected);
		Assert.assertTrue(driver.findElement(By.xpath("//td[text() = '"+Nametobeselected+"']//preceding-sibling::td")).isSelected());
	}*/
	
	/*@Test(priority =2)
	public void ValidateSelectMultipleContactTest()
	{
		String Nametobeselected = "bala B";
		String Name2tobeselected = "Dilip kumar";
		contactspage.ValidateSelectContact(Nametobeselected);
		contactspage.ValidateSelectContact(Name2tobeselected);
		Assert.assertTrue(driver.findElement(By.xpath("//td[text() = '"+Nametobeselected+"']//preceding-sibling::td//input[@type='checkbox']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//td[text() = '"+Name2tobeselected+"']//preceding-sibling::td//input[@type='checkbox']")).isSelected());
	}*/
	
	/*@DataProvider
	public Object[][] GetCrmTestData()
	{
		Object data[][] = TestUtil.GetTestData();
		return data;
	}
	
	@Test(dataProvider = "GetCrmTestData")
	public void ValidateCreateNewContactTest(String FirstName, String LastName) throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@Class = 'ui linkedin button' and text() = 'New']")).click();
		Thread.sleep(15000);
		contactspage.ValidateCreateNewContact(FirstName, LastName);
		Thread.sleep(10000);
	}*/
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
