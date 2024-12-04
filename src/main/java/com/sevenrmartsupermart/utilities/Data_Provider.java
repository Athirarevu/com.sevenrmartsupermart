package com.sevenrmartsupermart.utilities;

import org.testng.annotations.DataProvider;

public class Data_Provider {
	ExcelReader excelreader = new ExcelReader();

	@DataProvider(name = "subCategory")
	public Object[][] product_searching() {
		excelreader.setExcelFile("SubcategoryData", "SearchData");
		return excelreader.getMultidimentionalData(2, 2);
	}
}
