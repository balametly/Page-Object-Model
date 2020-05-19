package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class LoginPage extends TestBase {

	
	
	//Page Factory - OR
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement ForgotPwdlink;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement Signuplink;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//actions of Login page
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public HomePage ValidateLoginBtn(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
	
	public boolean ValidateForgotPasswordLinkAvailability()
	{
		return ForgotPwdlink.isDisplayed();
	}
}
		