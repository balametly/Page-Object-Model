package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory
	
	@FindBy(xpath = "//span[@Class = 'user-display']")
	WebElement usernameLabel;
	
	@FindBy(xpath = "//a[@Class = 'item']/child::span[text()='Contacts']")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//a[@Class = 'item']/child::span[text()='Calendar']")
	WebElement CalendarLink;
	
	@FindBy(xpath = "//a[@Class = 'item']/child::span[text()='Deals']")
	WebElement DealsLink;
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean validateUserNameDisplay()
	{
		return usernameLabel.isDisplayed();
	}
	
	public ContactsPage ValidateclickOnContactslink()
	{
		ContactsLink.click();
		return new ContactsPage();
	}
	public CalendarPage ValidateclickOnCalendarlink()
	{
		CalendarLink.click();
		return new CalendarPage();
	}
	public DealsPage ValidateclickOnDealslink()
	{
		DealsLink.click();
		return new DealsPage();
	}	
}
