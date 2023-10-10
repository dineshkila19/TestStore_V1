package com.teststore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.teststore.actiondriver.Action;
import com.teststore.base.BaseClass;

public class SearchProductPage extends BaseClass{
	
	
	
	@FindBy(xpath="//*[@class='thumbnails grid row list-inline']/div[2]/div[1]/div/a")
	WebElement armaniFemme;
	
	public SearchProductPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	public AddToCartPage clickOnArmaniFemmi() {
		Action.click(getDriver(), armaniFemme);
		return new AddToCartPage();
	}
	
	
	
	
	
	
	

}
