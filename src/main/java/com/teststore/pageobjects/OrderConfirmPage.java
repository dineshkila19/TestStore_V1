package com.teststore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.teststore.actiondriver.Action;
import com.teststore.base.BaseClass;

public class OrderConfirmPage extends BaseClass{

	@FindBy(xpath="//*[@class='btn btn-orange pull-right lock-on-click']")
	WebElement confirmOrder;
	
	@FindBy(xpath="//*[contains(text(),' Your Order Has Been Processed!')]")
	WebElement successMsg;
	
	@FindBy(xpath="//*[@class='btn btn-default mr10']")
	WebElement continueBtn;
	
	public OrderConfirmPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnConfirmOrder() {
		Action.click(getDriver(), confirmOrder);
	}
	public boolean validateSuccessMsg() {
		return Action.isDisplayed(getDriver(), successMsg);
	}
	public void clickOnContinue() {
		Action.click(getDriver(), continueBtn);
	}
	
	
}
