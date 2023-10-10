package com.teststore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.teststore.base.BaseClass;
import com.teststore.pageobjects.HomePage;
import com.teststore.pageobjects.IndexPage;
import com.teststore.pageobjects.LoginPage;
import com.teststore.pageobjects.SearchProductPage;
import com.teststore.utility.Log;

public class SearchProductPageTest extends BaseClass{
	IndexPage indexPage;
	HomePage homePage;
	LoginPage loginPage;
	SearchProductPage searchProductPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups= {"Smoke","Sanity"})
	public void searchArmaniProduct() {
		Log.startTestCase("searchArmaniProduct");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		homePage=loginPage.login(prop.getProperty("loginname"), prop.getProperty("password"));
		searchProductPage=homePage.searchProduct("Armani");
		searchProductPage.clickOnArmaniFemmi();
		Log.info("searchArmaniProduct testcase is passed");
		Log.endTestCase("searchArmaniProduct");
	}

}
