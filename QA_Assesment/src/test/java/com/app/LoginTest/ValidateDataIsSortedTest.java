package com.app.LoginTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.login.genericUtility.Baseclass;
import com.login.pomRepository.Homepage;
import com.login.pomRepository.LoginPageActions;

public class ValidateDataIsSortedTest extends Baseclass
{
	public LoginPageActions loginActions;
	public Homepage homePageActions;
@Test
public void amountData() throws Throwable 
{
	loginActions = new LoginPageActions(driver);
	homePageActions=new Homepage(driver);
	loginActions.clickloginbutton();
	homePageActions.getAllDataBeforeSorted();
	homePageActions.clickOnlinkInHeader();
	homePageActions.getAllDataAeforeSorted();
	Assert.assertTrue(homePageActions.beforesort.equals(homePageActions.aftersort));
	driver.quit();
}
}
