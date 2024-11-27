package com.sevenrmartsupermart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminUserPage {
	
	@FindBy(xpath = "((//p[contains(text(),'Admin Users')]//following::a[1])[2]")
	WebElement adminUsers;
}
