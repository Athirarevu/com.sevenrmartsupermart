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

	@Test(priority=3)
	public void verifySubCategoryPageWithTitleDisplayed() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		subcategorypage.clickOnSubCategorySearchIcon();
		String title = subcategorypage.getHeadingOfSubCategoryPage();
		String expectedTitle = "List Sub Categories";
		Assert.assertEquals(title, expectedTitle);
	}

	@Test(priority=2)
	public void verifyLogOutFunctionalityWithStatusOfNewLoginPage() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		homepage.getLogoutFromApplication();
		boolean statusOfLoginPage = homepage.getNewLoginPageDetails();
		Assert.assertTrue(statusOfLoginPage);
	}

	@Test(priority=1)
	public void verifyAdminProfileIsDisplayed() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		boolean imageDisplayedStatus = homepage.getProfilePictureDetails();
		Assert.assertTrue(imageDisplayedStatus);
	}

	@Test(priority=4)
	public void verifyChangePasswordFunctionality() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		boolean changePasswordStatus = homepage.changePasswordOfApplication("admin", "admin123", "admin123");
		Assert.assertTrue(changePasswordStatus);
	}
}
