package com.SCM.ObjectPom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeManuPasswordPage {

	@FindBy(name = "txtOldPassword")
	private WebElement oldPass_Tf;
	
	@FindBy(name = "txtNewPassword")
	private WebElement newPass_Tf;
	
	@FindBy(name = "txtConfirmPassword")
	private WebElement confirmPass_Tf;
	
	@FindBy(xpath = "//input[@value='Change Password']")
	private WebElement changePass_Btn;
	
	public ChangeManuPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOldPass_Tf() {
		return oldPass_Tf;
	}

	public WebElement getNewPass_Tf() {
		return newPass_Tf;
	}

	public WebElement getConfirmPass_Tf() {
		return confirmPass_Tf;
	}

	public WebElement getChangePass_Btn() {
		return changePass_Btn;
	}
	
	//business logic
	
	public void changePassBtn()
	{
		changePass_Btn.click();
	}
	public void changePassData(HashMap<String, String>map, WebDriver driver)
	{
		for(Entry<String, String> set:map.entrySet())
		{
			WebElement editText = driver.findElement(By.name(set.getKey()));
			editText.clear();
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
		}
		changePass_Btn.click();
		
	}
 }
