package com.SCM.ObjectPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SCM.GenericUtils.WebDriverUtils;

public class NewOrderItemPage extends WebDriverUtils {

	public NewOrderItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	@FindBy(xpath = "//td[contains(.,'\"+Product+\"')]/../td/input")
//	private WebElement add_Quantity;
	
	@FindBy(xpath = "//input[@value='Post Order']")
	private WebElement post_OrderButton;
	
	public WebElement getPost_OrderButton() {
		return post_OrderButton;
	}
	
	//bussiness logic
	
	public void AddQuantity(WebDriver driver, String Product, String qty)
	{
		driver.findElement(By.xpath("//td[contains(.,'"+Product+"')]/../td/input")).sendKeys(qty);
		scrollbBarAction(driver);
		//scrollAction(driver, post_OrderButton);
		post_OrderButton.click();
	}
	
	
}
