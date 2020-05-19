package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class DealsPage extends TestBase{

	//PageFactory
	@FindBy(xpath = "//div[@Class = 'ui header item mb5 light-black' and text() = 'Deals']")
	WebElement DealsLogo;
	
	@FindBy(xpath = "//button[@Class = 'ui linkedin button' and text()= 'New']")
	WebElement NewDeal;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean validateDealslogo()
	{
		return DealsLogo.isDisplayed();
	}
	
	public void validateAddNewDeal(String title) throws InterruptedException
	{
			//label[text() = 'Assigned To' ]//parent::div[@class = 'ui field']//child::div[@Class = 'ui fluid selection dropdown' and @role = 'listbox']
		////div[text() = 'Balamurugan Balasubramaniam']
		NewDeal.click();
		Thread.sleep(5000);
		driver.findElement(By.name("title")).sendKeys(title);
		driver.findElement(By.xpath("//label[text() = 'Assigned To' ]//parent::div[@class = 'ui field']//child::div[@Class = 'ui fluid selection dropdown' and @role = 'listbox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text() = 'Balamurugan Balasubramaniam']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@Class = 'save icon']")).click();
	}
}
