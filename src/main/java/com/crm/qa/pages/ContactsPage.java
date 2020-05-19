package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.testbase.TestBase;

public class ContactsPage extends TestBase {

	//Page Factory
	
	@FindBy(xpath = "//div[@Class = 'ui header item mb5 light-black' and text() = 'Contacts']")
	@CacheLookup
	WebElement ContactsLabel;
	
	//@FindBy(xpath = "//td[text() = 'Dilip kumar']//preceding-sibling::td//div[@Class ='ui fitted read-only checkbox']")
	//WebElement SelectContact;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean ValidateContactsLabel()
	{
		return ContactsLabel.isDisplayed();
	}
	
	public void ValidateSelectContact(String name)
	{
		driver.findElement(By.xpath("//td[text() = '"+name+"']//preceding-sibling::td//div[@Class ='ui fitted read-only checkbox']")).click();
	}
	
	public void ValidateCreateNewContact(String Fname, String Lname) throws InterruptedException
	{
		
		driver.findElement(By.name("first_name")).sendKeys(Fname);
		driver.findElement(By.name("last_name")).sendKeys(Lname);
		//Select select = new Select(driver.findElement(By.xpath("//div[@name = 'category']")));
		//select.selectByVisibleText(Ctgry);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@Class = 'ui linkedin button' and text() = 'Save']/child::i[@Class = 'save icon']")).click();
		
	}
}
