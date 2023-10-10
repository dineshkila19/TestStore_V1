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

public class EndToEndTest extends BaseClass{
	
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
	
	@Test(groups="Regression")
	public void endToEndTest() {
		Log.startTestCase("endToEndTest");
		IndexPage indexPage=new IndexPage();
		Log.info("user is going to click on the login");
		loginPage=indexPage.clickOnLogin();
		homePage=loginPage.login(prop.getProperty("loginname"), prop.getProperty("password"));
		Log.info("user successfully entered login credentials");
		searchProductPage=homePage.searchProduct("Armani");
		Log.info("user entered product by name");
		addToCartPage=searchProductPage.clickOnArmaniFemmi();
		addToCartPage.selectSize();
		Log.info("user successfully select size");
		addToCartPage.enterQuantity("3");
		Log.info("user entered quantity");
		checkOutPage=addToCartPage.clickOnAddToCart();
		checkOutPage.selectCountry();
		Log.info("user select the country");
		checkOutPage.selectState("Andhra Pradesh");
		Log.info("user is successfully selected state");
		checkOutPage.enterZipCode("500072");
		Log.info("zip code is entered");
		orderConfirmPage=checkOutPage.clickOnCheckOut();
		Log.info("user successfully click on  the checkout");
		orderConfirmPage.clickOnConfirmOrder();
		boolean reasult=orderConfirmPage.validateSuccessMsg();
		Assert.assertTrue(reasult);
		Log.info("user successfully getting success message");
		orderConfirmPage.clickOnContinue();
		Log.info("endToEndTest testcase is passed");
		Log.endTestCase("endToEndTest");
	
		
		
	}
	
	

}
