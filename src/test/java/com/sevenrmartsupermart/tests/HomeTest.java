package com.sevenrmartsupermart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermart.base.Base;
import com.sevenrmartsupermart.pages.HomePage;
import com.sevenrmartsupermart.pages.LoginPage;
import com.sevenrmartsupermart.pages.SubCategoryPage;

public class HomeTest extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	SubCategoryPage subcategorypage;
	
	@Test
	public void verifyAdminUserLogin()
	{
		loginpage= new LoginPage(driver);
		homepage =new HomePage(driver);
		loginpage.login("admin","admin");
	}
	@Test
	public void verifysubCategory()
	{
		loginpage= new LoginPage(driver);
		homepage =new HomePage(driver);
		subcategorypage=new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		subcategorypage.clickOnSubCategorySearchIcon();	
		String text=subcategorypage.getHeadingOfSubCategoryPage();
		String expectedText = "List Sub Categories";
		Assert.assertEquals(text, expectedText);
	}
	

}
