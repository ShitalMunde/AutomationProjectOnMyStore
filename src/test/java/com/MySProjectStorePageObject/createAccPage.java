package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createAccPage {

	@FindBy(id = "id_gender2")
	private WebElement gender;
	
	@FindBy(id = "customer_firstname")
	private WebElement fn;
	
	@FindBy(id = "customer_lastname")
	private WebElement ln;
	
	@FindBy(id = "passwd")
	private WebElement pw;
	
	@FindBy(id = "submitAccount")
	private WebElement createbtn;
	
	public createAccPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void genderSelect() {
		gender.click();
	}
	public void EnterFN() {
		fn.sendKeys("Adams");
	}
	public void EnterLN() {
		ln.sendKeys("com");
	}
	public void EnterPw() {
		pw.sendKeys("admascom");
	}
	public void submit() {
		createbtn.click();
	}

	
}
