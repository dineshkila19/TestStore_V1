package com.teststore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.teststore.base.BaseClass;
import com.teststore.pageobjects.IndexPage;
import com.teststore.utility.Log;

public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
	// Adding the commit for understating the code
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(groups= "Smoke")
	public void verifyingMyStoreLogo() {
		Log.startTestCase("verifyingMyStoreLogo");
		IndexPage indexPage=new IndexPage();
		boolean reasult =indexPage.validateMyStoreLogo();
		Assert.assertTrue(reasult);
		Log.info("verifyingMyStoreLogo testcase is passed");
		Log.endTestCase("verifyingMyStoreLogo");
	}
	
	@Test(groups="Smoke")
	public void getMyStoreTitleTest() throws Throwable {
		Log.startTestCase("getMyStoreTitleTest");
		IndexPage indexPage=new IndexPage();
		String actTitle=indexPage.getMyStoreTitle();
		String expTitle="A place to practice your automation skills!";
		Assert.assertEquals(actTitle, expTitle);
		Log.info("getMyStoreTitleTest testcase is passed");
		Log.endTestCase("getMyStoreTitleTest");
	}
	

}
