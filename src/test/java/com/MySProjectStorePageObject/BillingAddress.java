package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingAddress {

	@FindBy(name = "processAddress")
	WebElement shipChe;
	
	public BillingAddress(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void shipingCheckout() {
		shipChe.click();
	}
	
}
