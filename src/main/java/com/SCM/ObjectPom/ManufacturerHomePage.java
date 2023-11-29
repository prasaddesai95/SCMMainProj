package com.SCM.ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomePage {

	@FindBy(xpath = "//img[@alt='edit']")
	private WebElement edit_LuIcon;
	
	@FindBy(linkText = "Add Products")
	private WebElement addProductLink;
	
	@FindBy(linkText = "Manage Stock")
	private WebElement manageStockLink;
	
	@FindBy(linkText = "Manage Unit")
	private WebElement manageUnitLink;
	
	@FindBy(linkText = "Manage Category")
	private WebElement manageCatLink;
	
	@FindBy(linkText = "Products")
	private WebElement ProductMo;
	
	public ManufacturerHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEdit_LuIcon() {
		return edit_LuIcon;
	}

	public WebElement getAddProductLink() {
		return addProductLink;
	}

	public WebElement getManageStockLink() {
		return manageStockLink;
	}

	public WebElement getManageUnitLink() {
		return manageUnitLink;
	}

	public WebElement getManageCatLink() {
		return manageCatLink;
	}

	public WebElement getProductMo() {
		return ProductMo;
	}
	
	//business logic
	public void clickOnEditIcon()
	{
		edit_LuIcon.click();
	}
	
	public void clickOnAddProduct()
	{
		addProductLink.click();
	}
	
	public void clickOnManageStock()
	{
		manageStockLink.click();
	}
	
	public void clickOnManageUnit()
	{
		manageUnitLink.click();
	}
	
	public void clickOnManageCatgory()
	{
		manageCatLink.click();
	}
	
	public void clickOnProductModule()
	{
		ProductMo.click();
	}
	
}
