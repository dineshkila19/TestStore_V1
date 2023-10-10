package com.teststore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.teststore.base.BaseClass;
import com.teststore.pageobjects.HomePage;
import com.teststore.pageobjects.IndexPage;
import com.teststore.pageobjects.LoginPage;
import com.teststore.utility.Log;

public class HomePageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Smoke")
	public void validateWellcomeMSG() {
		Log.startTestCase("validateWellcomeMSG");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		homePage=loginPage.login(prop.getProperty("loginname"), prop.getProperty("password"));
		boolean reasult=homePage.validateMSG();
		Assert.assertTrue(reasult);
		Log.info("validateWellcomeMSG testcase is passed");
		Log.endTestCase("validateWellcomeMSG");
	}

}
