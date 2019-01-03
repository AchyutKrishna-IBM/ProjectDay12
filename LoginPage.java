package com.ibm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
WebDriver driver;
WebDriverWait wait;
	@FindBy(xpath="//input[@name='email']")
	WebElement emailEle;
	@FindBy(xpath="//input[@name='pword']")
	WebElement passEle;
	@FindBy(xpath="/html/body/div/div/div/div[2]/form/button")
	WebElement loginEle;
	
	public LoginPage(WebDriver driver,WebDriverWait wait)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait=wait;
	}
	public void inputEmail(String user)
	{
		emailEle.sendKeys(user);
		
	}
	public void inputPassword(String pass)
	{
		passEle.sendKeys(pass);
	}
	public void clickOnLogin()
	{
		loginEle.click();
	}
}
