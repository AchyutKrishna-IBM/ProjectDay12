package com.ibm.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//*[@id='side-menu']/li[2]/a")
	WebElement catalogEle;
	@FindBy(xpath="//*[@id='side-menu']/li[2]/ul/li[3]/a")
	WebElement categoriesEle;
	@FindBy(xpath="//*[@id='dataTableExample2_filter']/label/input")
	WebElement searchCategoryEle;
	@FindBy(xpath="//*[@id='dataTableExample2']/tbody/tr/td[6]/div/button")
	WebElement actionEle;
	@FindBy(xpath="//a[@title='Edit']")
	WebElement EditCategoryEle;
	@FindBy(xpath="//input[@placeholder='Category Name']")
	WebElement categoryNameEle;
	@FindBy(xpath="//*[@id='page-wrapper']/div/form/div[1]/button/i")
	WebElement saveEle;
	@FindBy(xpath="//table[@id='dataTableExample2']/tbody/tr/td")
	WebElement norecordFound;
	@FindBy(xpath="//*[@id='page-wrapper']/div/div[2]")
	WebElement successMessage;
	@FindBy(xpath="//table[@id='dataTableExample2']/tbody/tr/td[2]")
	WebElement modVerify;
	public AdminPage(WebDriver driver,WebDriverWait wait)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait=wait;
	}
	public void clickOnCatalog()
	{
		catalogEle.click();
	}
public void clickOnCategories()
{
	categoriesEle.click();
}
public void verifyBeforeModifying(String act)
{
	Assert.assertEquals(act,norecordFound.getText().trim());
}
public String databaseValidation(String tab_name,String col_name,String col_val) throws SQLException
{
	 String text=null;
	Connection c=DriverManager.getConnection("jdbc:mysql://foodsonfinger.com:3306/foodsonfinger_atozgroceries", "foodsonfinger_atoz", "welcome@123");
   Statement s=c.createStatement();
   ResultSet rs=s.executeQuery("SELECT * FROM "+tab_name+" WHERE "+col_name+"='"+col_val+"'");
   if(rs.next())
   {
	text=rs.getString(col_name);
   }
   return text;
    }
public void searchCategoryToBeModified(String ctgr)
{
	searchCategoryEle.sendKeys(ctgr);
}
public void clearSearchField()
{
	searchCategoryEle.clear();
}
public void clickOnAction()
{
	actionEle.click();
}
public void clickOnEdit()
{
	EditCategoryEle.click();
}
public void inputModifiedCategoryName(String mctgr)
{
	categoryNameEle.clear();
	categoryNameEle.sendKeys(mctgr);
}
public void clickOnSave()
{
	saveEle.click();
}
public void succesMessageVerification(String sm)
{
	Assert.assertTrue(successMessage.getText().contains(sm));
}
public void verfificationOnAdminPage(String expected)
{
Assert.assertEquals(expected, modVerify.getText().trim());	
}
}
