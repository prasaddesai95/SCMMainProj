package com.SCM.ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage {

	@FindBy(linkText = "New Order")
	private WebElement new_Order;
	
	@FindBy(linkText = "Products")
	private WebElement ProductMo;
	
	public RetailerHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNew_Order() {
		return new_Order;
	}

	public WebElement getProductMo() {
		return ProductMo;
	}
	
	//business logic
	
	public void clickOnNewOrder()
	{
		new_Order.click();
	}
	
	public void clickOnProductMo()
	{
		ProductMo.click();
	}
}
