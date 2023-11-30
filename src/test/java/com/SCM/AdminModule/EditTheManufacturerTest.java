package com.SCM.AdminModule;

import org.testng.annotations.Test;

import com.SCM.GenericUtils.BaseClass;
import com.SCM.ObjectPom.AdminHomePage;
import com.SCM.ObjectPom.EditManufacturerPage;
import com.SCM.ObjectPom.ManufacturerHomePage;

//@Listeners(com.SCM.GenericUtils.ListImplClass.class)
public class EditTheManufacturerTest extends BaseClass{

	@Test
	public void editTheManufacturerTest() throws Throwable {
		
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.ManufactureMod();
		
		wLib.scrollbBarAction(driver);
		
		EditManufacturerPage emp = new EditManufacturerPage(driver);
		
		ManufacturerHomePage mhp = new ManufacturerHomePage(driver);
		mhp.clickOnEditIcon();
		//Assert.fail();
		emp.editTheData(eLib.writeMultipleData("manuData"), driver);
		
		System.out.println(wLib.getAlertText(driver));
		wLib.acceptAlert(driver);

	}
}
