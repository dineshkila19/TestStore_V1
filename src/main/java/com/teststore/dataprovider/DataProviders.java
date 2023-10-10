package com.teststore.dataprovider;

import org.testng.annotations.DataProvider;

import com.teststore.utility.NewExcelLibrary;

public class DataProviders {
	
	NewExcelLibrary obj=new NewExcelLibrary();
	
	@DataProvider(name="TestStoreLoginData")
	public Object[][] getTestStoreData() {
		int rows=obj.getRowCount("Sheet1");
		int columns=obj.getColumnCount("Sheet1");
		int actualrow=rows-1;
		Object[][] data=new Object[actualrow][columns];
		for(int i=0; i<actualrow; i++) {
			for(int j=0; j<columns; j++) {
				data[i][j]=obj.getCellData("Sheet1", j, i+2);
			}
		}
		return data;
	}
	
	
	

}
