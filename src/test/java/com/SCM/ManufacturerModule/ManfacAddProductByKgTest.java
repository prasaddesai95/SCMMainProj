package com.SCM.ManufacturerModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SCM.GenericUtils.ExcelUtils;
import com.SCM.GenericUtils.FileUtils;
import com.SCM.GenericUtils.WebDriverUtils;
import com.SCM.ObjectPom.AddProductPage;
import com.SCM.ObjectPom.AdminHomePage;
import com.SCM.ObjectPom.LoginPage;
import com.SCM.ObjectPom.ManufacturerHomePage;

public class ManfacAddProductByKgTest {

	@Test
	public void manfacAddProductByKgTest() throws Throwable {
		FileUtils fLib = new FileUtils();
		//JavaUtils jLib = new JavaUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();
			
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("user1");
		String PASSWORD = fLib.readDataFromPropertyFile("pass1");
		String LOGTYPE = fLib.readDataFromPropertyFile("admin2");
		
		WebDriver driver = new ChromeDriver();
		WebDriver sdriver= driver;
		
		wLib.maximizeWindow(driver);
		driver.get(URL);
		wLib.waitforPageLoad(driver, 10);
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD, LOGTYPE);
		
		ManufacturerHomePage mhp = new ManufacturerHomePage(driver);
		mhp.clickOnAddProduct();
		
		String DDkg = eLib.readDataFromExcel("kgManData", 0, 4);
		String DDCat = eLib.readDataFromExcel("kgManData", 1, 4);
		
		AddProductPage app = new AddProductPage(driver);
		app.productDetailsData(eLib.writeMultipleData("kgManData"), driver, DDkg, DDCat);
	
		System.out.println(wLib.getAlertText(driver));
		wLib.acceptAlert(driver);
		
		mhp.clickOnProductModule();
		
		wLib.scrollbBarAction(driver);
		
		String actData = eLib.readDataFromExcel("kgManData", 0, 1);
		
		app.prouctValidate(driver, actData);
		
		
		AdminHomePage ahp = new AdminHomePage(driver);
		
		ahp.Logout();
		
		driver.quit();
	}
}
