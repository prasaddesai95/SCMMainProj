package com.SCM.ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	@FindBy(linkText = "Add Products")
	private WebElement add_product;
	
	@FindBy(linkText = "Add Retailers")
	private WebElement add_retailer;
	
	@FindBy(linkText = "Add Manufacturer")
	private WebElement add_manufacturer;
	
	@FindBy(linkText = "Add Distributor")
	private WebElement add_distributor;
	
	@FindBy(linkText = "Retailers")
	private WebElement retailers;
	
	@FindBy(linkText = "Manufacturers")
	private WebElement manufacturer;
	
	@FindBy(linkText = "Invoice")
	private WebElement invoice;
	
	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement AdLogout;
	
	
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getAdd_product() {
		return add_product;
	}


	public WebElement getAdd_retailer() {
		return add_retailer;
	}


	public WebElement getAdd_manufacturer() {
		return add_manufacturer;
	}


	public WebElement getAdd_distributor() {
		return add_distributor;
	}


	public WebElement getRetailers() {
		return retailers;
	}


	public WebElement getManufacturer() {
		return manufacturer;
	}


	public WebElement getInvoice() {
		return invoice;
	}


	public WebElement getAdLogout() {
		return AdLogout;
	}
	
	//business logic
	public void addRetailer()
	{
		add_retailer.click();
	}
	
	public void addManufacturer()
	{
		add_manufacturer.click();
	}
	
	public void RetailerMod()
	{
		retailers.click();
	}
	
	public void ManufactureMod()
	{
		manufacturer.click();
	}
	
	public void InvoiceMod()
	{
		invoice.click();
	}
	public void Logout()
	{
		AdLogout.click();
	}
	
}
