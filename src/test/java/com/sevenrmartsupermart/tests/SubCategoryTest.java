package com.sevenrmartsupermart.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenrmartsupermart.base.Base;
import com.sevenrmartsupermart.constants.Constants;
import com.sevenrmartsupermart.constants.Data_Provider;
import com.sevenrmartsupermart.pages.HomePage;
import com.sevenrmartsupermart.pages.LoginPage;
import com.sevenrmartsupermart.pages.SubCategoryPage;
import com.sevenrmartsupermart.utilities.GeneralUtility;
import com.sevenrmartsupermart.utilities.ScreenShotCapture;

public class SubCategoryTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	SubCategoryPage subcategorypage;
	SoftAssert softassert = new SoftAssert();

	@Test
	public void subCategoryPageVerification() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		String text = subcategorypage.clickOnSubCategorySearchIcon();
		System.out.println(text);
		String expectedText = "List Sub Categories";
		Assert.assertEquals(text, expectedText);
	}

	@Test
	public void verificationOfSearchButton() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		subcategorypage.clickOnSubCategorySearchIcon();
		subcategorypage.SearchForSubcategory("Appliances", "phone");
		List<String> actualResult = new ArrayList<String>();
		actualResult = subcategorypage.getSearchResult("Appliances");
		List<String> subList = actualResult.subList(1, 2);
		System.out.println(subList);
		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("Appliances");
		AssertJUnit.assertEquals(subList, expectedResult);

	}

	@Test
	public void VerifySearchResult() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		subcategorypage.clickOnSubCategorySearchIcon();
		subcategorypage.SearchForSubcategory("Electronics", "phone");
		List<String> actualResult = new ArrayList<String>();
		actualResult = subcategorypage.getSearchResult("Electronics");
		List<String> subList = actualResult.subList(1, 2);
		System.out.println(subList);
		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("Electronics");
		Assert.assertEquals(subList, expectedResult);
	}

	@Test(dataProvider = "subCategory", dataProviderClass = Data_Provider.class)
	public void verifySearchResultByDataProvider(String category, String subCategory) {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		subcategorypage.clickOnSubCategorySearchIcon();
		String page = subcategorypage.SearchForSubcategoryByDataProvider(category, subCategory);
		System.out.println("page navigation " + page);
	}

	@Test
	public void verifySearchWithInvalidData() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		subcategorypage.clickOnSubCategorySearchIcon();
		String message = subcategorypage.getNoResultOutput("Electronics", "xxxyy");
		Assert.assertEquals(message, ".........RESULT NOT FOUND.......");
	}

	@Test
	public void verifySearchResultMessage() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		subcategorypage.clickOnSubCategorySearchIcon();
		String message = subcategorypage.getInvalidSearchEntry("Electronics", "xxxyy");
		System.out.println("Message Displayed is " + message);
		Assert.assertEquals(message, ".........RESULT NOT FOUND.......");
		
		String newlist = GeneralUtility.getRandomName();
		System.out.println(newlist);
	}

	@Test
	public void checkResetIconStatus() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		boolean status = subcategorypage.CheckResetIconIsEnabled();
		// System.out.println("The status of Reset Icon is "+status);
		Assert.assertTrue(status);

	}

	@Test
	public void verifySearchButtonStatus() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		boolean status = subcategorypage.statusOfSearchButton();
		Assert.assertTrue(status);
	}

	@Test
	public void verifyCSSPropertyOfNewIcon() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		String backgroudcolor = subcategorypage.getBackgroundColorOfNewIcon();
		// System.out.println(backgroudcolor);
		String expectedbgcolor = "rgba(220, 53, 69, 1)";
		String color = subcategorypage.toCheckColorOfNewButton();
		// System.out.println(color);
		String expectedcolor = "rgba(255, 255, 255, 1)";
		String fontStyle = subcategorypage.getFontStyleOfNewIcon();
		// System.out.println(fontStyle);
		String expectedfontStyle = "normal";
		String fontSize = subcategorypage.getFontSizeOfNewButton();
		// System.out.println(fontSize);
		String expectedFontSize = "16px";

		softassert.assertEquals(backgroudcolor, expectedbgcolor);
		softassert.assertEquals(color, expectedcolor);
		softassert.assertEquals(fontSize, expectedFontSize);
		softassert.assertEquals(fontStyle, expectedfontStyle);
		softassert.assertAll();
	}

	@Test
	public void verifyCSSPropertyOfSearchButton() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		String backgroudcolor = subcategorypage.getBackgroundColorOfSearchIcon();
		// System.out.println(backgroudcolor);
		String expectedbgcolor = "rgba(220, 53, 69, 1)";
		String color = subcategorypage.toCheckColorOfSearchButton();
		// System.out.println(color);
		String expectedcolor = "rgba(255, 255, 255, 1)";
		String fontStyle = subcategorypage.getFontStyleOfSearchIcon();
		// System.out.println(fontStyle);
		String expectedfontStyle = "normal";
		String fontSize = subcategorypage.getFontSizeOfSearchButton();
		// System.out.println(fontSize);
		String expectedFontSize = "16px";

		softassert.assertEquals(backgroudcolor, expectedbgcolor);
		softassert.assertEquals(color, expectedcolor);
		softassert.assertEquals(fontSize, expectedFontSize);
		softassert.assertEquals(fontStyle, expectedfontStyle);
		softassert.assertAll();
	}

	@Test
	public void verifyCSSPropertyOfResetButton() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategorypage = new SubCategoryPage(driver);
		loginpage.login();
		homepage.clickOnSubCategory();
		String backgroudcolor = subcategorypage.getBackgroundColorOfResetIcon();
		// System.out.println(backgroudcolor);
		String expectedbgcolor = "rgba(255, 193, 7, 1)";
		String color = subcategorypage.toCheckColorOfResetButton();
		// System.out.println(color);
		String expectedcolor = "rgba(31, 45, 61, 1)";
		String fontStyle = subcategorypage.getFontStyleOfResetIcon();
		// System.out.println(fontStyle);
		String expectedfontStyle = "normal";
		String fontSize = subcategorypage.getFontSizeOfResetButton();
		// System.out.println(fontSize);
		String expectedFontSize = "16px";

		softassert.assertEquals(backgroudcolor, expectedbgcolor);
		softassert.assertEquals(color, expectedcolor);
		softassert.assertEquals(fontSize, expectedFontSize);
		softassert.assertEquals(fontStyle, expectedfontStyle);
		softassert.assertAll();
	}

}
