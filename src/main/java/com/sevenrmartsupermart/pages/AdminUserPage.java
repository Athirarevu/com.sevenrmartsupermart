package com.sevenrmartsupermart.pages;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermart.utilities.GeneralUtility;
import com.sevenrmartsupermart.utilities.PageUtility;
import com.sevenrmartsupermart.utilities.WaitUtility;

public class AdminUserPage {
	WebDriver driver;
	Properties properties = new Properties();
	WaitUtility waitutility = new WaitUtility(driver);

	@FindBy(xpath = "//h1[contains(text(),'Admin Users')]")
	private WebElement titleOfAdminPage;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newElement;
	@FindBy(xpath = "//h3[@class='card-title']")
	private WebElement pageTitle;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameElement;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordElement;
	@FindBy(xpath = "//select[@name='user_type']")
	private WebElement userTypeElement;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveField;
	@FindBy(xpath = "//h5[contains(text(),'Alert!')]")
	private WebElement alertElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	private List<WebElement> userDetailsField;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]//a[3]")
	private WebElement deleteField;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement failureAlertField;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]//a[2]")
	private WebElement updateField;
	@FindBy(xpath="//input[@name='username']")
	WebElement newUserNameField;
	@FindBy(xpath="//input[@type='password']")
	WebElement newPasswordField;
	@FindBy(xpath="//select[@id='user_type']")
	WebElement newUserTypeField;
	@FindBy(xpath="//button[@name='Update']")
	WebElement submitField;
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getHeadingOfAdminUserPage() {
		return titleOfAdminPage.getText();
	}

	public void createNewAdminUser(String newUsername, String newPassword, String userType) {
		newElement.click();
		waitutility.waitForElementToBeVisible(pageTitle, 20);
		userNameElement.sendKeys(newUsername);
		passwordElement.sendKeys(newPassword);
		PageUtility pageutility = new PageUtility(driver);
		pageutility.select_ByVisibleText(userTypeElement, userType);
		userTypeElement.sendKeys(userType);
		saveField.click();
	}

	public String getBackgroundColorOfAlertForNewAdminUser() {
		waitutility.waitForElementToBeVisible(alertElement, 20);
		GeneralUtility generalutility = new GeneralUtility();
		String backgroundColor = generalutility.getCssValue(alertElement, "background-color");
		return backgroundColor;
	}

	public void getAdminUserDeleted(String userName) {
		for (WebElement row : userDetailsField) {
			if (row.getText().contains(userName)) {
				deleteField.click();
				break;
			}
		}
		driver.switchTo().alert().accept();
	}

	public boolean checkAdminUserIsDeletedOrNot(String userName) {
		boolean status = true;
		for (WebElement row : userDetailsField) {
			if (row.getText().contains(userName)) {
				status = false;
				break;
			}
		}
		return status;
	}
	
	public void getAdminUserUpdated(String userName, String newuserName,String password, String userType) {
		for (WebElement row : userDetailsField) {
			if (row.getText().contains(userName)) {
				updateField.click();
				newUserNameField.sendKeys(newuserName);
				newPasswordField.sendKeys(password);
				PageUtility pageutility = new PageUtility(driver);
				pageutility.select_ByVisibleText(userTypeElement, userType);
				newUserTypeField.sendKeys(userType);
				submitField.click();
				break;
			}
		}
	}
	
	public boolean checkAdminUserIsUpdatedOrNot(String newuserName) {
		boolean status = true;
		for (WebElement row : userDetailsField) {
			if (row.getText().contains(newuserName)) {
				status = false;
				break;
			}
		}
		return status;
	}

}
