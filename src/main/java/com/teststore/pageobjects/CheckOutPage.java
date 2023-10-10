package com.teststore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.teststore.actiondriver.Action;
import com.teststore.base.BaseClass;

public class CheckOutPage extends BaseClass{
	
	@FindBy(xpath="//*[@id='estimate_country']")
	WebElement country;
	
	@FindBy(xpath="//*[@id='estimate_country_zones']")
	WebElement state;
	
	@FindBy(xpath="//*[@id='estimate_postcode']")
	WebElement zipCode;
	
	@FindBy(xpath="//*[contains(text(),'Flat Shipping Rate - $2.00')]")
	WebElement shipmentFee;
	
	@FindBy(xpath="//*[@class='contentpanel']/div[3]/div/a[2]")
	WebElement checkOutBtn;
	
	public CheckOutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectCountry() {
		Action.selectByValue(country, "99");
	}
	public void selectState(String state1) {
		Action.selectByVisibleText(state, state1);
	}
	public void enterZipCode(String zipcd) {
		Action.type(zipCode, zipcd);
	}
	public void selectShipmentFee() {
		Action.click(getDriver(), shipmentFee);
	}
	public OrderConfirmPage clickOnCheckOut() {
		Action.click(getDriver(), checkOutBtn);
		return new OrderConfirmPage();
	}
	

}
