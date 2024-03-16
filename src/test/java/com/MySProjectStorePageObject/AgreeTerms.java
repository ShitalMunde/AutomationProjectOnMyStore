package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgreeTerms {

	@FindBy(id = "uniform-cgv")
	WebElement agreebtn;
	
	@FindBy(name = "processCarrier")
	WebElement checkOut;
	
	public AgreeTerms(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	public void agreeTerms() {
		agreebtn.click();
	}
	public void checkOutbtn() {
		checkOut.click();
	}
}
