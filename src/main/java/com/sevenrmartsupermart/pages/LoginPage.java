package com.sevenrmartsupermart.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermart.constants.Constants;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@CacheLookup
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signINButton;
	@FindBy(xpath = "//input[@name='remember_me']")
	private WebElement rememberButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//h5[contains(text(),' Alert!')]")
	private WebElement AlertMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signINButton.click();
	}

	public HomePage login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
		return new HomePage(driver);
	}

	public HomePage login() {
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(username);
		enterPassword(password);
		clickOnSignInButton();
		return new HomePage(driver);
	}

	public boolean checkRememberCheckBoxEnabled() {
		return rememberButton.isEnabled();
	}

	public String checkLoginWithWrongInputs(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
		return AlertMessage.getText();
	}

	public boolean checkSignInButtonEnabled() {
		return signINButton.isEnabled();
	}

}
