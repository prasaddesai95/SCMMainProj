package com.SCM.AdminModule;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SCM.GenericUtils.BaseClass;
import com.SCM.ObjectPom.AddRetailerPage;
import com.SCM.ObjectPom.AdminHomePage;

@Listeners(com.SCM.GenericUtils.ListImplClass.class)
public class AddRetailerWithMandtoryFieldTest extends BaseClass {

	@Test(groups = "smoke")
	public void addRetailerWithMandtoryFieldTest() throws Throwable {
		
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.addRetailer();
	
		String areaDD = eLib.readDataFromExcel("Sheet4", 0, 4);
		
		AddRetailerPage arp = new AddRetailerPage(driver);
		arp.passTheData(eLib.writeMultipleData("Sheet4"), driver, areaDD);
		
		//arp.retailerValidate(driver, areaDD);
		System.out.println(wLib.getAlertText(driver));
		wLib.acceptAlert(driver);
		arp.retailerValidate(driver, areaDD);
		ahp.RetailerMod();
		
		
	}
}
