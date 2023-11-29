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

public class AddRetailerPage extends WebDriverUtils {

	@FindBy(name = "txtRetailerUname")
	private WebElement username_text;
	
	@FindBy(name = "txtRetailerPassword")
	private WebElement password_text;
	
	@FindBy(name = "cmbAreaCode")
	private WebElement area_DD;
	
//	@FindBy(name = "txtRetailerPhone")
//	private WebElement phone_text;
	
	@FindBy(name = "txtRetailerEmail")
	private WebElement email_text;
	
	@FindBy(name = "txtRetailerAddress")
	private WebElement address_text;
	
	@FindBy(xpath = "//input[@value='Add Retailer']")
	private WebElement addRetailer_button;
	
	public AddRetailerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername_text() {
		return username_text;
	}

	public WebElement getPassword_text() {
		return password_text;
	}

	public WebElement getArea_DD() {
		return area_DD;
	}

//	public WebElement getPhone_text() {
//		return phone_text;
//	}

	public WebElement getEmail_text() {
		return email_text;
	}

	public WebElement getAddress_text() {
		return address_text;
	}

	public WebElement getAddRetail_button() {
		return addRetailer_button;
	}
	
	
	//business logic
//	public void AddRetailers(String user, String pwd, String areaDD, String phone, String email, String address)
//	{
//		username_text.sendKeys(user);
//		password_text.sendKeys(pwd);
//		dropdown(areaDD, area_DD);
//		phone_text.sendKeys(phone);
//		email_text.sendKeys(email);
//		address_text.sendKeys(address);
//		addRetailer_button.click();
//	}
	public void passTheData(HashMap<String, String>map, WebDriver driver, String area) throws InterruptedException
	{
		for(Entry<String, String> set:map.entrySet())
		{
			WebElement editText = driver.findElement(By.name(set.getKey()));
			editText.clear();
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
			//Thread.sleep(3000);
		}
		
		dropdown(area, area_DD);
		addRetailer_button.click();
	}
	
	public void retailerValidate(WebDriver driver, String expRet)
	{
		String actRet = driver.findElement(By.xpath("//td[@id]//td[contains(.,' "+expRet+" ')]")).getText();  ///gettext to 
		Assert.assertEquals(expRet, actRet);
		System.out.println("Retailer Created");
		
	}
	
	
	

}
