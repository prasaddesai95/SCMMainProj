package com.SCM.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class baseClassTestNg {

	public DatabaseUtils dLib = new DatabaseUtils();
	public FileUtils fLib = new FileUtils();
	public ExcelUtils eLib= new ExcelUtils();
	public WebDriverUtils wLib = new WebDriverUtils();
	public WebDriver driver;
	
	@BeforeSuite
	public void config_BS() throws Throwable
	{
		dLib.connectDB();
		System.out.println("-- connect to DB --");
	}
	
	@Parameters("BROWSER")
	@BeforeClass
	public void config_BC(String BROWSER) throws Throwable
	{
		//String BROWSER = fLib.readDataFromPropertyFile("browser");
		
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
			
		} 
		else if(BROWSER.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();

		}
		else
		{
			System.out.println("-- Invalid Browser --");
		}
		wLib.maximizeWindow(driver);
		
	}
	@BeforeMethod
	public void config_BM()
	{
		driver.get("https://www.flipkart.com/");
		System.out.println("-- Logged in to application --");
	}
	
	@AfterMethod
	public void config_AM()
	{
		System.out.println("-- Logged Out from appln --");
	}
	@AfterClass
	public void config_AC()
	{
		driver.quit();
		System.out.println("-- Browser closed --");
	}
	
	@AfterSuite
	public void config_AS() throws Throwable
	{
		dLib.disconnectDB();
		System.out.println("-- Disconnected from DB --");
	}
	
}
