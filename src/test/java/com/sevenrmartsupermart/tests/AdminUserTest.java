package com.sevenrmartsupermart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermart.base.Base;
import com.sevenrmartsupermart.pages.AdminUserPage;
import com.sevenrmartsupermart.pages.HomePage;
import com.sevenrmartsupermart.pages.LoginPage;
import com.sevenrmartsupermart.pages.SubCategoryPage;
import com.sevenrmartsupermart.utilities.ExcelReader;

public class AdminUserTest extends Base {
	ExcelReader excelreader = new ExcelReader();
	LoginPage loginpage;
	HomePage homepage;
	SubCategoryPage subcategorypage;
	AdminUserPage adminuserpage;

	@Test
	public void verifyAdminUserPage() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminuserpage = homepage.clickOnAdminUserMenu();
		String title = adminuserpage.getHeadingOfAdminUserPage();
		String expectedTitle = "Admin Users";
		Assert.assertEquals(title, expectedTitle);
	}

	@Test
	public void verifyNewButtonFunctionality() {
		excelreader.setExcelFile("AdminUserData", "data");
		String newUserNameData = excelreader.getCellData(0, 0);
		String newPasswordData = excelreader.getCellData(0, 1);
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminuserpage = homepage.clickOnAdminUserMenu();
		adminuserpage.createNewAdminUser(newUserNameData, newPasswordData, "Staff");
		String backgroundColor = adminuserpage.getBackgroundColorOfAlertForNewAdminUser();
		Assert.assertEquals(backgroundColor, "rgba(40, 167, 69, 1)");
	}

	@Test
	public void verifyPossibilityOfRepetionOfSameAdminUser() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminuserpage = homepage.clickOnAdminUserMenu();
		adminuserpage.createNewAdminUser("Athira", "athira123", "Admin");
		String backgroundColor = adminuserpage.getBackgroundColorOfAlertForNewAdminUser();
		Assert.assertEquals(backgroundColor, "rgba(0, 0, 0, 0)");
	}

	@Test
	public void verifydeleteButtonFunctionality() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminuserpage = homepage.clickOnAdminUserMenu();
		adminuserpage.getAdminUserDeleted("shefeena");
		boolean deletedStatus = adminuserpage.checkAdminUserIsDeletedOrNot("admin8569");
		Assert.assertTrue(deletedStatus, "The admin user is still available in the list");
	}

	@Test
	public void verifyFunctionalityOfUpdateButton() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		adminuserpage = homepage.clickOnAdminUserMenu();
		adminuserpage.getAdminUserUpdated("Farha", "Farhas","Naseeb", "Admin");
		boolean updatedStatus=adminuserpage.checkAdminUserIsUpdatedOrNot("Farhas");
		Assert.assertTrue(updatedStatus, "The admin user is still not updated in the list");
	}
}
