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
import com.teststore.pageobjects.OrderConfirmPage;
import com.teststore.pageobjects.SearchProductPage;
import com.teststore.utility.Log;

import junit.framework.Assert;

public class OrderConfirmPageTest extends BaseClass{
	
	IndexPage indexPage;
	HomePage homePage;
	LoginPage loginPage;
	SearchProductPage searchProductPage;
	AddToCartPage addToCartPage;
	CheckOutPage checkOutPage;
	OrderConfirmPage orderConfirmPage;
	
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
	public void confirmOrderTest() {
		Log.startTestCase("confirmOrderTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		homePage=loginPage.login(prop.getProperty("loginname"), prop.getProperty("password"));
		searchProductPage=homePage.searchProduct("Armani");
		addToCartPage=searchProductPage.clickOnArmaniFemmi();
		addToCartPage.selectSize();
		addToCartPage.enterQuantity("3");
		checkOutPage=addToCartPage.clickOnAddToCart();
		checkOutPage.selectCountry();
		checkOutPage.selectState("Andhra Pradesh");
		checkOutPage.enterZipCode("500072");
		orderConfirmPage=checkOutPage.clickOnCheckOut();
		orderConfirmPage.clickOnConfirmOrder();
		boolean reasult=orderConfirmPage.validateSuccessMsg();
		Assert.assertTrue(reasult);
		orderConfirmPage.clickOnContinue();
		Log.info("confirmOrderTest testcase is passed");
		Log.endTestCase("confirmOrderTest");
	
		
		
	}
	
	

}
