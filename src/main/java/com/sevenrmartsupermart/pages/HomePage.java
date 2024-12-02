package com.sevenrmartsupermart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermart.utilities.WaitUtility;

public class HomePage {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility(driver);

	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath = "(//p[contains(text(),'Sub Category')]//following::a[1])[2]")
	private WebElement subCategory;
	@FindBy(xpath = "(//p[contains(text(),'Admin Users')]//following::a[1])[2]")
	private WebElement adminUsers;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement adminHomeElement;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement logoutField;
	@FindBy(xpath = "//body[@class='login-page']")
	private WebElement newLoginPage;
	@FindBy(xpath = "//img[@class='img-circle elevation-2']")
	private WebElement profileImage;
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	private WebElement titleOfHomePage;
	@FindBy(xpath = "//p[contains(text(),'Settings')]")
	private WebElement settingsField;
	@FindBy(xpath = "//p[contains(text(),'Change Password')]")
	private WebElement changePasswordField;
	@FindBy(xpath = "//input[@placeholder='Old Password']")
	private WebElement oldPasswordField;
	@FindBy(xpath = "//input[@placeholder='New Password']")
	private WebElement newPasswordField;
	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	private WebElement confirmPasswordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement changeField;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	private WebElement successAlertField;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return profileName.getText();
	}

	public SubCategoryPage clickOnSubCategory() {
		subCategory.click();
		return new SubCategoryPage(driver);
	}

	public AdminUserPage clickOnAdminUserMenu() {
		adminUsers.click();
		return new AdminUserPage(driver);
	}

	public void getLogoutFromApplication() {
		adminHomeElement.click();
		waitutility.waitForElementToBeVisible(logoutField, 20);
		logoutField.click();
		waitutility.waitForElementToBeVisible(newLoginPage, 20);
	}

	public boolean getNewLoginPageDetails() {
		return newLoginPage.isDisplayed();
	}

	public boolean getProfilePictureDetails() {
		return profileImage.isDisplayed();
	}

	public String getHeadingOfHomePage() {
		return titleOfHomePage.getText();
	}

	public boolean changePasswordOfApplication(String oldpassword, String newPassword, String confirmPassword) {
		settingsField.click();
		changePasswordField.click();
		waitutility.waitForElementToBeClickable(oldPasswordField, 20);
		oldPasswordField.sendKeys(oldpassword);
		newPasswordField.sendKeys(newPassword);
		confirmPasswordField.sendKeys(confirmPassword);
		changeField.click();
		return successAlertField.isDisplayed();
	}
}
