package com.app.LoginTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.login.genericUtility.Baseclass;
import com.login.pomRepository.LoginPageActions;

public class Validate_HomePageTest extends Baseclass
{
	public LoginPageActions loginActions;

	@Test
	public void validateHomePage() throws Throwable
	{
		loginActions = new LoginPageActions(driver);
		loginActions.clickloginbutton();
		Assert.assertEquals(driver.getCurrentUrl().contains("home"),"Home page is displayed successfully");
	}

}
