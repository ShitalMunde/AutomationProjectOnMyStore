package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyRegisterUserName {

	@FindBy(xpath = ".//a[@class ='account']")
	private WebElement user;
	
	public VerifyRegisterUserName(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	public String getUser() {
		String res = user.getText();
		return res;
	}
	
}
