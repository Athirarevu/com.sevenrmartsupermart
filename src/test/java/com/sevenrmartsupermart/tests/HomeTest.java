package com.sevenrmartsupermart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermart.base.Base;
import com.sevenrmartsupermart.pages.HomePage;
import com.sevenrmartsupermart.pages.LoginPage;
import com.sevenrmartsupermart.pages.SubCategoryPage;

public class HomeTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	SubCategoryPage subcategorypage;

	@Test(priority=1)
	public void verifyAdminUserLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login("admin", "admin");
		String titleOfHomePage = homepage.getHeadingOfHomePage();
		Assert.assertEquals(titleOfHomePage, "7rmart supermarket");
	}

	@Test(priority=3)
	public void verifySubCategoryPage() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		subcategorypage.clickOnSubCategorySearchIcon();
		String text = subcategorypage.getHeadingOfSubCategoryPage();
		String expectedText = "List Sub Categories";
		Assert.assertEquals(text, expectedText);
	}

	@Test(priority=2)
	public void verifyLogOutFunctionality() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		homepage.getLogoutFromApplication();
		boolean statusOfLoginPage = homepage.getNewLoginPageDetails();
		Assert.assertTrue(statusOfLoginPage);
	}

	@Test
	public void verifyAdminProfileIsDisplayed() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		boolean imageDisplayedStatus = homepage.getProfilePictureDetails();
		Assert.assertTrue(imageDisplayedStatus);
	}

	@Test
	public void verifyChangePasswordFunctionality() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		boolean changePasswordStatus = homepage.changePasswordOfApplication("admin", "admin123", "admin123");
		Assert.assertTrue(changePasswordStatus);
	}
}
