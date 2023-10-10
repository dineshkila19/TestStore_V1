package com.teststore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.teststore.actiondriver.Action;
import com.teststore.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(xpath="//*[@id='option322']")
	WebElement size;
	
	@FindBy(xpath="//*[@name='quantity']")
	WebElement qunatity;
	
	@FindBy(xpath="//*[@class='productpagecart']/li/a")
	WebElement addToCartBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectSize() {
		Action.selectByValue(size, "667");
	}
	
	public void enterQuantity(String qnty) {
		Action.type(qunatity, qnty);
	}
	public CheckOutPage clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
		return new CheckOutPage();
	}
}
