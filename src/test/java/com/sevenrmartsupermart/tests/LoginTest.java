package com.sevenrmartsupermart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermart.base.Base;
import com.sevenrmartsupermart.pages.HomePage;
import com.sevenrmartsupermart.pages.LoginPage;
import com.sevenrmartsupermart.pages.SubCategoryPage;
import com.sevenrmartsupermart.utilities.ExcelReader;

public class LoginTest extends Base {
	ExcelReader excelreader = new ExcelReader();
	LoginPage loginpage;
	HomePage homepage;
	SubCategoryPage subcategorypage;

	@Test(groups = "regression")
	public void verifyAdminUserLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login("admin", "admin");
		String titleOfHomePage = homepage.getHeadingOfHomePage();
		Assert.assertEquals(titleOfHomePage, "7rmart supermarket");
	}
	
	@Test(groups = "smoke")
	public void verifyAdminUserLoginByExcelData() {
		excelreader.setExcelFile("LoginData", "Result");
		String usernameData = excelreader.getCellData(1, 0);
		String passwordData = excelreader.getCellData(1, 1);
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login(usernameData, passwordData);
		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

	@Test(groups = "sanity")
	public void verifyLoginWithoutParameter() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();

	}

	@Test(groups = "sanity")
	public void checkStatusOfRememberCheckbox() {
		loginpage = new LoginPage(driver);
		boolean state = loginpage.checkRememberCheckBoxEnabled();
		Assert.assertTrue(state);
	}

	@Test(groups = { "smoke", "regression" })
	public void loginWithWrongData() {
		loginpage = new LoginPage(driver);
		String actualStatus = loginpage.checkLoginWithWrongInputs("admin", "new");
		System.out.println(actualStatus);
		String expectedStatus = "Alert!";
		Assert.assertEquals(actualStatus, expectedStatus);
	}

	@Test(retryAnalyzer = com.sevenrmartsupermart.listeners.RetryAnalyzer.class)
	public void checkStatusOfSignInButton() {
		loginpage = new LoginPage(driver);
		boolean Status = loginpage.checkSignInButtonEnabled();
		Assert.assertFalse(Status);
	}
}
