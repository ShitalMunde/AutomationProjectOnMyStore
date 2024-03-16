package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentOption {

	@FindBy(xpath = ".//a[@class='bankwire']")
	WebElement option1;
	
	public PaymentOption(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void paymentOption1() {
		option1.click();
	}
	
}
