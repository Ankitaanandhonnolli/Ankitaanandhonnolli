package com.app.LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateLoginPageTest 
{
	@Test(dataProvider = "logindata")
	public void testLoginPage(String scenario,String username,String password) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://sakshingp.github.io/assignment/login.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("log-in")).click();


		if(scenario.equals("validusername_password"))
		{
			WebElement compareExpense = driver.findElement(By.id("showExpensesChart"));
			Assert.assertTrue(compareExpense.isDisplayed(), "login success");
		}

		else if(scenario.equals("InvalidUserName"))
		{
			String errormessage = driver.findElement(By.xpath("//div [@class='alert alert-warning']")).getText();
			Assert.assertEquals(errormessage, "Username must be present");
		}

		else if(scenario.equals("InvalidUnPwd"))
		{
			String errormsg = driver.findElement(By.xpath("//div [@class='alert alert-warning']")).getText();
			Assert.assertEquals(errormsg, "Both Username and Password must be present");
		}

		else if(scenario.equals("Invalidpassword"))

		{
			String errormsg1 = driver.findElement(By.xpath("//div [@class='alert alert-warning']")).getText();
			Assert.assertEquals(errormsg1, "Password must be present");
		}
	



	driver.quit();
}
@DataProvider(name="logindata")
public Object[][] loginData()
{
	return new Object[][] 
		{
		{"validusername_password","ankitha","hello"},
		{"InvalidUserName","",".ggj"},
		{"InvalidUnPwd","",""},
		{"Invalidpassword","hello",""},
		};
}


}

