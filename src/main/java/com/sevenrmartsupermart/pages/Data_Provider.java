package com.sevenrmartsupermart.pages;

import org.testng.annotations.DataProvider;
import com.sevenrmartsupermart.utilities.ExcelReader;

public class Data_Provider {
	ExcelReader excelreader = new ExcelReader();

	@DataProvider(name = "subCategory")
	public Object[][] product_searching() {
		excelreader.setExcelFile("SubcategoryData", "SearchData");
		return excelreader.getMultidimentionalData(2, 2);
	}
}
