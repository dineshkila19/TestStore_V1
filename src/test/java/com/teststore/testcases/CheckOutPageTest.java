package com.teststore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.teststore.base.BaseClass;
import com.teststore.pageobjects.AddToCartPage;
import com.teststore.pageobjects.CheckOutPage;
import com.teststore.pageobjects.HomePage;
import com.teststore.pageobjects.IndexPage;
import com.teststore.pageobjects.LoginPage;
import com.teststore.pageobjects.SearchProductPage;
import com.teststore.utility.Log;

public class CheckOutPageTest extends BaseClass{
	
	IndexPage indexPage;
	HomePage homePage;
	LoginPage loginPage;
	SearchProductPage searchProductPage;
	AddToCartPage addToCartPage;
	CheckOutPage checkOutPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Sanity")
	public void checkOutTest() {
		Log.startTestCase("checkOutTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		homePage=loginPage.login(prop.getProperty("loginname"), prop.getProperty("password"));
		searchProductPage=homePage.searchProduct("Armani");
		addToCartPage=searchProductPage.clickOnArmaniFemmi();
		addToCartPage.selectSize();
		addToCartPage.enterQuantity("2");
		checkOutPage=addToCartPage.clickOnAddToCart();
		checkOutPage.selectCountry();
		checkOutPage.selectState("Andhra Pradesh");
		checkOutPage.enterZipCode("500072");
		checkOutPage.clickOnCheckOut();
		Log.info("checkOutTest testcase is passed");
		Log.endTestCase("checkOutTest");
	}
}
