package com.SCM.AdminModule;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SCM.GenericUtils.BaseClass;
import com.SCM.ObjectPom.AdminHomePage;
import com.SCM.ObjectPom.ViewInvoicePage;

//@Listeners(com.SCM.GenericUtils.ListImplClass.class)
public class SearchByInvoieIdTest extends BaseClass {

	@Test
	public void searchByInvoieIdTest() throws Throwable {
		
		AdminHomePage ahp= new AdminHomePage(driver);
		
		ahp.InvoiceMod();
		
		String searchData = eLib.readDataFromExcel("invData", 0, 4);
		String invIDNum = eLib.readDataFromExcel("invData", 0, 7);
		Assert.fail();
		ViewInvoicePage vip = new ViewInvoicePage(driver);
		vip.enterDetails(invIDNum, searchData);
		
		vip.invoiceValidation(driver, invIDNum);
		
	}
}
