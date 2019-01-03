package com.ibm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//*[@id='categories-menu']/ul/li/span")
	WebElement categoryEle;
	@FindBy(xpath="//a[text()='Chocolates_modify']")
	WebElement verify;
	public UserPage(WebDriver driver,WebDriverWait wait)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait=wait;
	}
	public void clickOnCategory()
	{
		categoryEle.click();
	}
public void verificationOfModifiedCategory(String modcat)
{
List<WebElement>verify=driver.findElements(By.xpath("//a[text()='"+modcat+"']"));
	
	Assert.assertTrue(verify.size()!=0);
}
}
