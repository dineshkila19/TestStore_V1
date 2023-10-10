package com.teststore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.teststore.actiondriver.Action;
import com.teststore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//*[@name='loginname']")
	WebElement txtLoginName;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@id='loginFrm']/fieldset/button")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname,String pwd) {
		Action.type(txtLoginName, uname);
		Action.type(txtPassword, pwd);
		Action.click(getDriver(), loginBtn);
		return new HomePage();
	}
	
	public String getCurrentUrl() throws Throwable {
		String currentUrl=Action.getCurrentURL(getDriver());
		return currentUrl;
		
	}
	
	

}
