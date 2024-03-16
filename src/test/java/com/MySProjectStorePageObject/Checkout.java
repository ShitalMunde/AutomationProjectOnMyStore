package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

	@FindBy(xpath = ".//a[@class='button btn btn-default standard-checkout button-medium']")
	private WebElement checkout;
	
	public Checkout(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void finalCheckOut() {
		checkout.click();
	}
	
	
}
