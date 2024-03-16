package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	@FindBy (xpath = ".//a[@class='login']")
	private WebElement signInbtn;
	
	public IndexPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	public void signIn() {
		signInbtn.click();
	}
	
}
