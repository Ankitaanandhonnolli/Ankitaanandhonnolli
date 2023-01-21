package com.login.genericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.login.pomRepository.LoginPageActions;

import io.github.bonigarcia.wdm.WebDriverManager;

 public class Baseclass
{
	public  WebDriver driver;
	public String url;
	public String username;
	public String password;
	public  String timeout;
	public LoginPageActions loginpage;


	/*
	 * This method use to open propertyfile
	 * @throws Throwable
	 */
	 
	@BeforeSuite
	public void beforeSuite() throws Throwable
	{
	Fileutility.openpropertyFile(IconstantPath.PROPERTYFILE_PATH);

	}

	@BeforeTest
	public void beforeTest() 
	{

	}

	@BeforeClass
	public void beforClass() throws IOException 
	{

		url=Fileutility.getDataFromPropertyFile("url");
		username=Fileutility.getDataFromPropertyFile("username");
		password=Fileutility.getDataFromPropertyFile("password");
		timeout=Fileutility.getDataFromPropertyFile("timeout");
		String browsername = Fileutility.getDataFromPropertyFile("browsername");

		switch (browsername) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			System.out.println("please specify proper browser key");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

          }
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage=new LoginPageActions(driver);

	}
	
	/*
	 * This method use to login the application
	 * @throws Throwable 
 */
	@BeforeMethod
	public void beforMethod() throws Throwable
	{

		loginpage.loginAction(username, password);

	}

	/**
	 * This method use to logout the application
	 */
	@AfterMethod
	public void afterMethpd() 
	{

	}

	/**
	 * This method use to quit the browser
	 */
	
	
	
	
	@AfterClass
	public void afterClass() 
	{
		driver.quit();
	}
}
