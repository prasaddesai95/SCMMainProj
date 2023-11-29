package com.SCM.ObjectPom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.SCM.GenericUtils.WebDriverUtils;

public class AddProductPage extends WebDriverUtils {

	@FindBy(name = "txtProductName")
	private WebElement productName_Tf;
	
	@FindBy(name = "txtProductPrice")
	private WebElement productPrice_Tf;
	
	@FindBy(xpath = "//select[@name='cmbProductUnit']")
	private WebElement unitType_DD;
	
	@FindBy(xpath = "//select[@name='cmbProductCategory']")
	private WebElement category_DD;
	
	@FindBy(xpath = "//input[@name='rdbStock' and @value='2']")
	private WebElement StockMang_Radio;
	
	@FindBy(xpath = "//input[@value='Add Product']")
	private WebElement addProduct_btn;
	
	public AddProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductName_Tf() {
		return productName_Tf;
	}

	public WebElement getProductPrice_Tf() {
		return productPrice_Tf;
	}

	public WebElement getUnitType_DD() {
		return unitType_DD;
	}

	public WebElement getCategory_DD() {
		return category_DD;
	}

	public WebElement getStockMang_Radio() {
		return StockMang_Radio;
	}

	public WebElement getAddProduct_btn() {
		return addProduct_btn;
	}
	
	//business logic
	
	public void productDetailsData(HashMap<String, String>map, WebDriver driver, String uValue, String cValue)
	{
		for(Entry<String, String> set:map.entrySet())
		{
			WebElement editText = driver.findElement(By.name(set.getKey()));
			editText.clear();
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
		}
		dropdown(unitType_DD, uValue);
		dropdown(category_DD, cValue);
		
		StockMang_Radio.click();
		addProduct_btn.click();
	}
	
	public void prouctValidate(WebDriver driver, String actData)
	{
       String expData = driver.findElement(By.xpath("//td[.=' "+actData+" ']")).getText();
		Assert.assertEquals(actData, expData);
		System.out.println("Right Product added");
		
	}
	
}
