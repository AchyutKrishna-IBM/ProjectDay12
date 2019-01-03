package com.ibm.test;



import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.initialization.WebDriverLaunch;
import com.ibm.pages.AdminPage;
import com.ibm.pages.LoginPage;
import com.ibm.pages.UserPage;

public class BaseTest extends WebDriverLaunch {
	@Test
	public void adminCredentials()
	{
		String url=p.getProperty("url");
		driver.get(url);
		String username=p.getProperty("user");
		String password=p.getProperty("password");
		LoginPage lp=new LoginPage(driver,wait);
		lp.inputEmail(username);
		lp.inputPassword(password);
		lp.clickOnLogin();
	}
	@Test
	public void modifyCategoryAndVerify() throws InterruptedException, SQLException
	{
		String catname=p.getProperty("categoryname");
		String modcatname=p.getProperty("modifiedCategoryName");
		String msg=p.getProperty("mesaage");
		String smsg=p.getProperty("successmessage");
		String table=p.getProperty("table");
		String colomn=p.getProperty("coloumn");
		AdminPage ap=new AdminPage(driver,wait);
		ap.clickOnCatalog();
		ap.clickOnCategories();
		Thread.sleep(3000);
		ap.searchCategoryToBeModified(modcatname);
		ap.verifyBeforeModifying(msg);
	String act=ap.databaseValidation(table,colomn,modcatname);
	Assert.assertEquals(null,act);
	Thread.sleep(3000);
	ap.clearSearchField();
		ap.searchCategoryToBeModified(catname);
		ap.clickOnAction();
		ap.clickOnEdit();
		Thread.sleep(3000);
		ap.inputModifiedCategoryName(modcatname);
		Thread.sleep(3000);
		ap.clickOnSave();
		ap.searchCategoryToBeModified(modcatname);
		ap.succesMessageVerification(smsg);
		ap.verfificationOnAdminPage(modcatname);
		String actual=ap.databaseValidation(table,colomn,modcatname);
		Assert.assertEquals(modcatname,actual);
		String userurl=p.getProperty("urluser");
		driver.get(userurl);
		UserPage up=new UserPage(driver,wait);
		up.clickOnCategory();
		up.verificationOfModifiedCategory(modcatname);
		
		
		
		
	}

}
