package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

	@FindBy(id = "email_create")
	private WebElement email;
	
	@FindBy(id ="SubmitCreate")
	private WebElement createbtn;
	
	public MyAccount(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public void email() {
		email.sendKeys("adamscom2922@gmail.com");
	}
	public void submitbtn() {
		createbtn.click();
	}
	
}
