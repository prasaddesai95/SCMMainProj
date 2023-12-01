package com.SCM.ManufacturerModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SCM.GenericUtils.ExcelUtils;
import com.SCM.GenericUtils.FileUtils;
import com.SCM.GenericUtils.WebDriverUtils;
import com.SCM.ObjectPom.AdminHomePage;
import com.SCM.ObjectPom.ChangeManuPasswordPage;
import com.SCM.ObjectPom.LoginPage;
import com.SCM.ObjectPom.ManufacturerHomePage;

public class ManuChangePasswordPTest {

	@Test
	public void manuChangePasswordPTest() throws Throwable {
		FileUtils fLib = new FileUtils();
		// JavaUtils jLib = new JavaUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();

		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("user");
		String PASSWORD = fLib.readDataFromPropertyFile("pass");
		String LOGTYPE = fLib.readDataFromPropertyFile("admin2");

		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		driver.get(URL);
		wLib.waitforPageLoad(driver, 10);

		String newPass = eLib.readDataFromExcel("maFactData", 1, 1);

		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD, LOGTYPE);

		// click on edit icon
		ManufacturerHomePage mhp = new ManufacturerHomePage(driver);
		mhp.clickOnEditIcon();

		ChangeManuPasswordPage cmpp = new ChangeManuPasswordPage(driver);
		cmpp.changePassBtn();

		cmpp.changePassData(eLib.writeMultipleData("maFactData"), driver);

		System.out.println(wLib.getAlertText(driver));
		wLib.acceptAlert(driver);

		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.Logout();

		lp.login(USERNAME, newPass, LOGTYPE);

		driver.quit();

	}
}
