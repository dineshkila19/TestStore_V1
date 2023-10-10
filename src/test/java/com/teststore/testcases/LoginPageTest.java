package com.teststore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.teststore.base.BaseClass;
import com.teststore.dataprovider.DataProviders;
import com.teststore.pageobjects.HomePage;
import com.teststore.pageobjects.IndexPage;
import com.teststore.pageobjects.LoginPage;
import com.teststore.utility.Log;

public class LoginPageTest extends BaseClass{
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
	
	@Test(dataProvider="TestStoreLoginData", dataProviderClass=DataProviders.class, groups= {"Smoke","Sanity"})
	public void loginTest(String lname, String lpwd) {
		Log.startTestCase("getMyStoreTitleTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		//loginPage.login(prop.getProperty("loginname"), prop.getProperty("password"));
		loginPage.login(lname, lpwd);
		Log.info("getMyStoreTitleTest testcase is passed");
		Log.endTestCase("getMyStoreTitleTest");
	}
	
	@Test(groups= {"Smoke","Sanity"})
	public void gettingCuurentURLtest() throws Throwable {
		Log.startTestCase("gettingCuurentURLtest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		loginPage.login(prop.getProperty("loginname"), prop.getProperty("password"));
		String actURL=loginPage.getCurrentUrl();
		String expURL="https://automationteststore.com/index.php?rt=account/account";
		Assert.assertEquals(actURL, expURL);
		Log.info("gettingCuurentURLtest testcase is passed");
		Log.endTestCase("gettingCuurentURLtest");
		
	}

}
