package sampletest;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GooglTest {

	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium - Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.logfile", "C:\\Selenium - Drivers\\chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	/*@Test(priority = 2)
	public void titleTest()
	{
		System.out.println(driver.getTitle());
	}
	@Test(priority = 3)
	public void maillinkTest()
	{
		boolean lnk = driver.findElement(By.linkText("Mail")).isDisplayed();
	}*/
	@Test(priority = 1)
	public void logoTest()
	{
		boolean logo = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		System.out.println(logo);
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
