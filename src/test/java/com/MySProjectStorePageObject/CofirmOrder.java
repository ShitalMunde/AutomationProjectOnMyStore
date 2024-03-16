package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CofirmOrder {

	@FindBy(xpath = ".//button[@class='button btn btn-default button-medium']")
	WebElement confirmorderbtn;
	
	public CofirmOrder(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	public void cofirmBtn() {
		confirmorderbtn.click();
	}
}
