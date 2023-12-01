package com.SCM.RetailerModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SCM.GenericUtils.ExcelUtils;
import com.SCM.GenericUtils.FileUtils;
import com.SCM.GenericUtils.WebDriverUtils;
import com.SCM.ObjectPom.AddRetailerPage;
import com.SCM.ObjectPom.AdminHomePage;
import com.SCM.ObjectPom.LoginPage;
import com.SCM.ObjectPom.NewOrderItemPage;
import com.SCM.ObjectPom.RetailerHomePage;

public class AddRetailerPostOrderPTest{

	@Test
	public void addRetailerPostOrderPTest() throws Throwable {
		FileUtils fLib = new FileUtils();
		//JavaUtils jLib = new JavaUtils();
		ExcelUtils eLib= new ExcelUtils();
		WebDriverUtils wLib= new WebDriverUtils();
		
		//fetchingGu
		// BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		String LOGTYPE = fLib.readDataFromPropertyFile("admin3");
		
		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		
		driver.get(URL);
		wLib.waitforPageLoad(driver, 10);
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD, LOGTYPE);
		
		AdminHomePage ahp= new AdminHomePage(driver);
		ahp.addRetailer();

		String areaDD = eLib.readDataFromExcel("Sheet2", 0, 4);
		
		AddRetailerPage arp= new AddRetailerPage(driver);
		arp.passTheData(eLib.writeMultipleData("Sheet2"), driver, areaDD);
		
		wLib.acceptAlert(driver);
		
		ahp.RetailerMod();
		
		String expRet = eLib.readDataFromExcel("Sheet1", 0, 1);
		String pwdRet = eLib.readDataFromExcel("Sheet1", 1, 1);
		
		arp.retailerValidate(driver, expRet);

		ahp.Logout();
		
		//login again as retailer
		String rValue = eLib.readDataFromExcel("Sheet2", 0, 10);
		lp.loginValue(expRet, pwdRet, rValue);
		
		//click on new order
		RetailerHomePage rhp = new RetailerHomePage(driver);
		rhp.clickOnNewOrder();
		
		String Product = eLib.readDataFromExcel("Sheet2", 0, 7);
		String qty = eLib.readDataFromExcel("Sheet2", 1, 7);
		//add product qty
		NewOrderItemPage noip= new NewOrderItemPage(driver);
		noip.AddQuantity(driver, Product, qty);
		
		ahp.Logout();

	}
}
