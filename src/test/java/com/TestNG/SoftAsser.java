package com.TestNG;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SoftAsser {

	@Test
	public void softa()
	{
		String exp ="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		
		SoftAssert sc = new SoftAssert();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String title = driver.getTitle();
		//System.out.println(title);
		
		sc.assertEquals(title, exp);
        	
		System.out.println(title);
		//it will work without failing the test -->passes:1
		
		//if the act is not matching with exp the script will run but
		//if we use assertAll() it will failed the test --> Faliures:1
		sc.assertAll();
		
		
		
		
	}
}
