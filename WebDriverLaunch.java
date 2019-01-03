package com.ibm.initialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
public class WebDriverLaunch {
	public WebDriver driver;
	public WebDriverWait wait;
	public Properties p;
	
	@BeforeSuite
	public void preSetForTest() throws FileNotFoundException, IOException
 {
	 p=new Properties();
	 p.load(new FileInputStream("./TestData/data.properties"));
	 
 }
	@BeforeTest
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	@AfterSuite
	public void closeBrowser()
	{
		driver.quit();
	}

}
