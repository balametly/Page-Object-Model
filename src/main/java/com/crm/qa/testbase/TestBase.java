package com.crm.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ip;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener listener;

	public TestBase() {
		prop = new Properties();
		try {
			ip = new FileInputStream(
					"C:\\Users\\ADMIN\\workspace\\CRM_POM_Project\\src\\main\\java\\crm.config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("Config File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
		String Browser = prop.getProperty("browser");
		
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium - Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.logfile", "C:\\Selenium - Drivers\\chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium - Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Incorrect Browser Name");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		listener = new WebEventListener();
		e_driver.register(listener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}

