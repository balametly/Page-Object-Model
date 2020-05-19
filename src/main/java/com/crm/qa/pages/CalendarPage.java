package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class CalendarPage extends TestBase {
	
	//PageFactory
	
	@FindBy(xpath = "//button[@Class = 'ui button' and text() = 'Sync now']")
	WebElement SyncNowBtn;
	
	@FindBy(xpath = "//button[@Class = 'ui linkedin button' and text()= 'New']")
	WebElement NewDeal;
	
	public CalendarPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions
	
	public boolean validateSyncNowBtnavailability()
	{
		return SyncNowBtn.isDisplayed();
	}
	
	public void validateAddNewCalendarItem(String title, String date, String timeslot) throws InterruptedException
	{
		//String date = "32-August-2020";
		driver.findElement(By.name("title")).sendKeys(title);
		driver.findElement(By.xpath("//label[text() = 'Start Date']//parent::div[@Class = 'ui field']//child::div[@Class = 'react-datepicker__input-container']")).click();
		String[] dateArr = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		String MMYY = String.join(" ", month, year);
			String MonthXpath = "//div[@Class = 'react-datepicker__current-month' and text() = 'June 2020']"; 
			String beforeXpath = "//div[@Class = 'react-datepicker__current-month' and text() = '";
			String afterXpath = "']";
			String dayXpath = "//div[contains(@aria-label, 'July') and text() = '1']";
			String dayBeforeXpath = "//div[contains(@aria-label, '";
			String daymidxpath = "') and text() = '";
			String dayAfterXpath = "']";
			boolean MonthDisplayed = false;
			List<WebElement> list;
		while(MonthDisplayed == false)
		{
			list = driver.findElements(By.xpath(beforeXpath+MMYY+afterXpath));
			
			if(list.size() > 0)
			{
			MonthDisplayed = true;
			}
			else
			{
				//moving to next month
				driver.findElement(By.xpath("//button[text() ='Next Month']")).click();
				Thread.sleep(5000);
			}
		}
		
		try{
		driver.findElement(By.xpath(dayBeforeXpath+month+daymidxpath+day+dayAfterXpath)).click();
		} catch (NoSuchElementException e){
			System.out.println("Selected Date is invalid");
		}
		List<WebElement> TimeSlotlist = driver.findElements(By.xpath("//ul[@Class = 'react-datepicker__time-list']//child::li"));
		for (int i =0; i<TimeSlotlist.size(); i++)
		{
			if(TimeSlotlist.get(i).toString().equalsIgnoreCase(timeslot))
			{
				TimeSlotlist.get(i).click();
				break;
			}
		}
	}
	
	

}
