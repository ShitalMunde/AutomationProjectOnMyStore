package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyLogin {

	
	@FindBy(id = "email")
	private WebElement loginmailbtn;
	
	@FindBy(id = "passwd")
	WebElement loginpwdbtn;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitbtn;
	
	public VerifyLogin(WebDriver driver) {
		
		PageFactory.initElements( driver,this);
	}
	
	public void mailBtn(String mail) {
		loginmailbtn.sendKeys(mail);
	}
	
	public void pwdbtn(String pw) {
		loginpwdbtn.sendKeys(pw);
	}
	public void submitClick() {
		submitbtn.click();
	}
	
	
}
