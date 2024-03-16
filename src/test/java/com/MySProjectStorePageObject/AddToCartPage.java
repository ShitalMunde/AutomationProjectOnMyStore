package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	@FindBy(xpath = ".//img[@title='Printed Summer Dress'][1]")
	private WebElement selectPro;
	
	@FindBy(xpath = ".//span[text()='Add to cart']")
	private WebElement addTo;
	
	@FindBy(xpath = ".//a[@title='Proceed to checkout']")
	private WebElement checkout;
	
	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void  selectProduct() {
		selectPro.click();
	}
	public void addTocart() {
		addTo.click();
	}
	public void productCheckOut() {
		checkout.click();
	}
	
	
	
}
