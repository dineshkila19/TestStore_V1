package com.teststore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.teststore.base.BaseClass;
import com.teststore.pageobjects.AddToCartPage;
import com.teststore.pageobjects.HomePage;
import com.teststore.pageobjects.IndexPage;
import com.teststore.pageobjects.LoginPage;
import com.teststore.pageobjects.SearchProductPage;
import com.teststore.utility.Log;

public class AddToCartPageTest extends BaseClass{
	IndexPage indexPage;
	HomePage homePage;
	LoginPage loginPage;
	SearchProductPage searchProductPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups= {"Sanity","Regression"})
	public void addToCartPageTest() {
		Log.startTestCase("addToCartPageTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		homePage=loginPage.login(prop.getProperty("loginname"), prop.getProperty("password"));
		searchProductPage=homePage.searchProduct("Armani");
		addToCartPage=searchProductPage.clickOnArmaniFemmi();
		addToCartPage.selectSize();
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCart();
		Log.info("addToCartPageTest testcase is passed");
		Log.endTestCase("addToCartPageTest");
	}

}
