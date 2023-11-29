package com.SCM.ObjectPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.SCM.GenericUtils.WebDriverUtils;

public class ViewInvoicePage extends WebDriverUtils {

	@FindBy(xpath = "//select[@name='cmbFilter']")
	private WebElement searchBy_DD;
	
	@FindBy(xpath = "//input[@name='txtInvoiceId']")
	private WebElement invoiceId_Tf;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement search_Btn;
	
	public ViewInvoicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBy_DD() {
		return searchBy_DD;
	}

	public WebElement getInvoiceId_Tf() {
		return invoiceId_Tf;
	}

	public WebElement getSearch_Btn() {
		return search_Btn;
	}
	
	//business logic
	
	public void enterDetails(String invoiceID, String serchvalue)
	{
		dropdown(searchBy_DD, serchvalue);
		invoiceId_Tf.sendKeys(invoiceID);
		search_Btn.click();
	}
	
	public void invoiceValidation(WebDriver driver, String invIDNum)
	{
        String expData = driver.findElement(By.xpath("//tr/following-sibling::tr//td[text()=' "+invIDNum+" ']")).getText();
		Assert.assertEquals(invIDNum, expData);
		System.out.println("Searched invoice is displayed");
	}
	
	
	
}
