package com.SCM.ObjectPom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditManufacturerPage {

	public EditManufacturerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "txtManufacturerName")
	private WebElement edit_NameTf;
	
	@FindBy(name = "txtManufacturerEmail")
	private WebElement edit_emailTf;
	
	@FindBy(name = "txtManufacturerPhone")
	private WebElement edit_phoneTf;
	
	@FindBy(name = "txtManufacturerUname")
	private WebElement edit_UnameTf;
	
	@FindBy(xpath = "//input[@value='Update Manufacturer']")
	private WebElement update_Manu;

	public WebElement getEdit_NameTf() {
		return edit_NameTf;
	}

	public WebElement getEdit_emailTf() {
		return edit_emailTf;
	}

	public WebElement getEdit_phoneTf() {
		return edit_phoneTf;
	}

	public WebElement getEdit_UnameTf() {
		return edit_UnameTf;
	}

	public WebElement getUpdate_Manu() {
		return update_Manu;
	}
	
	
	//business logic
	public void editTheData(HashMap<String, String>map,WebDriver driver)
	{
		for(Entry<String, String> set:map.entrySet())
		{
			WebElement editText = driver.findElement(By.name(set.getKey()));
			editText.clear();
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
		}
		
		update_Manu.click();
	}
	
	
}
