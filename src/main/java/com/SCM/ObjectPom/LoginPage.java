package com.SCM.ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SCM.GenericUtils.WebDriverUtils;

public class LoginPage extends WebDriverUtils {

	//declaration
	@FindBy(name="txtUsername")
	private WebElement Username_txt;
	
	@FindBy(name="txtPassword")
	private WebElement Password_txt;
	
	@FindBy(xpath = "//select[@name='login_type']")
	private WebElement LoginTypeDD;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement LoginButton;
	
	//intializeation
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getUsername_txt() {
		return Username_txt;
	}

	public WebElement getPassword_txt() {
		return Password_txt;
	}

	public WebElement getLoginTypeDD() {
		return LoginTypeDD;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//business logic
	
	public void login(String un, String pwd, String loginDD)
	{
		Username_txt.sendKeys(un);
		Password_txt.sendKeys(pwd);
		dropdown(loginDD, LoginTypeDD);
		LoginButton.click();	
	}
	public void loginValue(String un, String pwd, String loginVD)
	{
		Username_txt.sendKeys(un);
		Password_txt.sendKeys(pwd);
		dropdown(LoginTypeDD, loginVD);
		LoginButton.click();
	}
	
	
}
