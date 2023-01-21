package com.login.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageActions 
{
	@FindBy(xpath="//input[@id='username']")
	private WebElement userNameTxt;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordTxt;
	
	@FindBy(xpath="//button[@id='log-in']")
	private WebElement logInbtn;
	
	@FindBy(xpath="//label[@class='form-check-label']")
	private WebElement remembermechkbox;
	
	public LoginPageActions(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//login to application
	public void loginAction(String username,String password) throws Throwable
	{
		userNameTxt.sendKeys(username);
		Thread.sleep(1000);
		passwordTxt.sendKeys(password);
		Thread.sleep(1000);
	}
	
	public void clickloginbutton() throws Throwable
	{
		Thread.sleep(1000);
		logInbtn.click();
	}
	
	public void clickOnRememberMeCheckbox()
	{
		  remembermechkbox.click();//click on Remembercheckbox
	
    }
	
	public void checkRememberMeCheckbox()
	{
		 System.out.println(remembermechkbox.isSelected());//click on Remembercheckbox
	
    }
}