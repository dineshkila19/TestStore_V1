package com.teststore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.teststore.actiondriver.Action;
import com.teststore.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//*[@class='btn-group search-bar']/input")
	WebElement searchBox;
	
	@FindBy(xpath="//*[@class='button-in-search']/i")
	WebElement searchBoxBtn;
	
	@FindBy(xpath="//*[@id='main_menu_top']/li[2]/a")
	WebElement myAccountBtn;
	
	@FindBy(xpath="//*[@class='side_account_list']/li[10]/a")
	WebElement clickOnLogOut;
	
	@FindBy(xpath="//*[contains(text(),'Welcome back dinesh')]")
	WebElement wellcomWish;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMSG() {
		return Action.isDisplayed(getDriver(), wellcomWish);
	}
	
	public void clickOnAccount() {
		Action.click(getDriver(), myAccountBtn);
		Action.click(getDriver(), clickOnLogOut);
		
	}
	
	public SearchProductPage searchProduct(String myproduct) {
		Action.type(searchBox, myproduct);
		Action.click(getDriver(), searchBoxBtn);
		return new SearchProductPage();
	}
	

}
