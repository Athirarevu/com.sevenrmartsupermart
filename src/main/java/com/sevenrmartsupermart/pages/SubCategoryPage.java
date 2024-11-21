package com.sevenrmartsupermart.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermart.utilities.GeneralUtility;
import com.sevenrmartsupermart.utilities.PageUtility;
import com.sevenrmartsupermart.utilities.WaitUtility;

public class SubCategoryPage {
	WebDriver driver;
	WaitUtility waitutility= new WaitUtility(driver);
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement subCategorySearchField;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement CategoryField;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement subCategoryField;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement SearchField;
	@FindBy(xpath = "//span[@id='res']")
	private WebElement resultField;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetIcon;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td")
	private List<WebElement> searchTable;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement NewIcon;
	@FindBy(xpath= "//h1[@class='m-0 text-dark']")
	private WebElement headingField;
	@FindBy(xpath="//nav[@aria-label='Page navigation']")
	WebElement pageNavigationField;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectCategory(String category) {
		PageUtility pageutility = new PageUtility(driver);
		pageutility.select_ByVisibleText(CategoryField, category);
		CategoryField.sendKeys(category);
	}

	public void selectSubCategory(String subCategory) {
		subCategoryField.click();
		subCategoryField.sendKeys(subCategory);
	}

	public String clickOnSubCategorySearchIcon() {
		subCategorySearchField.click();
		return headingField.getText();
	}

	public void SearchForSubcategory(String category, String subCategory) {
		clickOnSubCategorySearchIcon();
		CategoryField.sendKeys(category);
		subCategoryField.sendKeys(subCategory);
		SearchField.click();		
	}
	
	public String SearchForSubcategoryByDataProvider(String category, String subCategory) {
		clickOnSubCategorySearchIcon();
		CategoryField.sendKeys(category);
		subCategoryField.sendKeys(subCategory);
		SearchField.click();
		return pageNavigationField.getText();
	}
		
	public String getNoResultOutput(String category, String subCategory)
	{
		clickOnSubCategorySearchIcon();
		CategoryField.sendKeys(category);
		subCategoryField.sendKeys(subCategory);
		SearchField.click();
		waitutility.waitForElementToBeVisible(resultField, 20);
		return resultField.getText();
	}

	public List<String> getSearchResult(String subCategory) {
		GeneralUtility generalutility = new GeneralUtility();

		List<String> result = new ArrayList<String>();
		result = generalutility.getTextOfElements(searchTable);

		int index = 0;
		for (index = 0; index < result.size(); index++) {
			if (subCategory.equals(result.get(index))) {
				index++;
				break;
			}
		}
		return result;
	}

	public String getInvalidSearchEntry(String category, String subCategory) {
		clickOnSubCategorySearchIcon();
		CategoryField.sendKeys(category);
		subCategoryField.sendKeys(subCategory);
		SearchField.click();
		return resultField.getText();
	}

	public boolean CheckResetIconIsEnabled() {
		return resetIcon.isEnabled();
	}

	public boolean statusOfSearchButton() {
		return SearchField.isEnabled();
	}

	public String getBackgroundColorOfSearchIcon() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(SearchField, "background-color");
		return result;
	}

	public String toCheckColorOfSearchButton() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(SearchField, "color");
		return result;
	}

	public String getFontStyleOfSearchIcon() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(SearchField, "font-style");
		return result;
	}

	public String getFontSizeOfSearchButton() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(SearchField, "font-size");
		return result;
	}
	public String getBackgroundColorOfNewIcon() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(NewIcon, "background-color");
		return result;
	}

	public String toCheckColorOfNewButton() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(NewIcon, "color");
		return result;
	}

	public String getFontStyleOfNewIcon() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(NewIcon, "font-style");
		return result;
	}

	public String getFontSizeOfNewButton() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(NewIcon, "font-size");
		return result;
	}
	
	public String getBackgroundColorOfResetIcon() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(resetIcon, "background-color");
		return result;
	}

	public String toCheckColorOfResetButton() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(resetIcon, "color");
		return result;
	}

	public String getFontStyleOfResetIcon() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(resetIcon, "font-style");
		return result;
	}

	public String getFontSizeOfResetButton() {
		GeneralUtility generalutility = new GeneralUtility();
		String result = generalutility.getCssValue(resetIcon, "font-size");
		return result;
	}

}