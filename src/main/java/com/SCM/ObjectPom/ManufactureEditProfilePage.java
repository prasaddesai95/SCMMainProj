package com.SCM.ObjectPom;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.lang.model.type.PrimitiveType;
import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufactureEditProfilePage {

	@FindBy(name = "txtManufacturerName")
	private WebElement editName_Tf;
	
	@FindBy(name = "txtManufacturerEmail")
	private WebElement editEmail_Tf;
	
	@FindBy(name = "txtManufacturerPhone")
	private WebElement editPhone_Tf;
	
	@FindBy(xpath = "//input[@value='Change Password']")
	private WebElement changePass_Btn;
	
	@FindBy(xpath = "//input[@value='Update Profile']")
	private WebElement updateProfile_btn;
	
	public ManufactureEditProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEditName_Tf() {
		return editName_Tf;
	}

	public WebElement getEditEmail_Tf() {
		return editEmail_Tf;
	}

	public WebElement getEditPhone_Tf() {
		return editPhone_Tf;
	}

	public WebElement getChangePass_Btn() {
		return changePass_Btn;
	}

	public WebElement getUpdateProfile_btn() {
		return updateProfile_btn;
	}
	
	//business logic
	public void clickOnChangePassBtn()
	{
		changePass_Btn.click();
	}
	
	public void updateManuProfileData(HashMap<String, String>map, WebDriver driver)
	{
		for(Entry<String, String> set:map.entrySet())
		{
			WebElement editText = driver.findElement(By.name(set.getKey()));
			editText.clear();
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
		}
		
		updateProfile_btn.click();
	}
}
