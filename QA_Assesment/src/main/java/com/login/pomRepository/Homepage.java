package com.login.pomRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class Homepage
{
	@FindBy(xpath="//table[@id='transactionsTable']/tbody/tr[*]/td[5]")
	private List<WebElement> columnlist;
	
	@FindBy(xpath="//th[@id='amount']")
	private WebElement amountLink;

	public String[] aftersort;

	public String[] beforesort;
	
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnlinkInHeader()
	{
		amountLink.click();
	}
	
	
	public void getAllDataBeforeSorted()
	{
		beforesort = new String[columnlist.size()];
		for(int i=0;i < columnlist.size();i++)
		{
			beforesort[i]=columnlist.get(i).getText().trim();
			System.out.println(beforesort[i]);
		}
	}
	
	public void getAllDataAeforeSorted()
	{
		
		 aftersort= new String[columnlist.size()];
		System.out.println("sorted values in the application after clicking Amount Link");
		for(int i=0;i < columnlist.size();i++)
		{
			aftersort[i]=columnlist.get(i).getText().trim();

			System.out.println(aftersort[i]);
		}
	
	}
	
}
