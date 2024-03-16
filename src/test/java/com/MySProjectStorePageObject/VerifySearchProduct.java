package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifySearchProduct {

	@FindBy(id = "search_query_top")
	private WebElement srchbtn;
	
	@FindBy(name = "submit_search")
	private WebElement search;
	
	@FindBy(xpath =".//a[contains(text(),'Printed Summer Dress')]")
	private WebElement product;
	
	public VerifySearchProduct(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void search() {
		srchbtn.sendKeys("Printed Summer Dress");
		search.click();
	}
	public String Product() {
		String verifyProduct =  product.getText();
		return verifyProduct;
	}
	
}
