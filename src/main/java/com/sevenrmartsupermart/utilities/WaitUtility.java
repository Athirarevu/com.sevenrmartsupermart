package com.sevenrmartsupermart.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	WebDriverWait wait;
	
	public WaitUtility(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void waitForElementToBeClickable(WebElement element, long duration) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeVisible(WebElement element, long duration) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeInvisible(WebElement element, long duration) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForAlertToBePresent(long duration) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitUntilDesabledState(WebElement element, long duration) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
	}
	
	public void wait(WebElement element, String attribute, String value, long duration) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
}
