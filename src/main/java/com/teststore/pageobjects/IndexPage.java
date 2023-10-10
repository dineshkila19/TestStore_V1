package com.teststore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.teststore.actiondriver.Action;
import com.teststore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='navbar-header header-logo']/a/img")
	WebElement myStoreLogo;
	
	@FindBy(xpath="//*[contains(text(),\"Login or register\")]")
	WebElement loginLink;
	
	@FindBy(xpath="//*[@id='main_menu_top']/li[2]/a/span")
	WebElement accountLink;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyStoreLogo() {
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() throws Throwable {
		String myStoreTitle=Action.getTitle(getDriver());
		return myStoreTitle;
	}
	
	public LoginPage clickOnLogin() {
		Action.click(getDriver(), loginLink);
		return new LoginPage();
	}
	

	
	
	

}
