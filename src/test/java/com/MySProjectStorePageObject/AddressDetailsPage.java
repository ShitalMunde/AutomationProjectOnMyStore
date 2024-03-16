package com.MySProjectStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressDetailsPage {

	@FindBy(xpath = ".//span[text()='Add a new address']")
	private WebElement addaddr;
	
	@FindBy(id = "address1")
	private WebElement addr;
	
	@FindBy(id = "city")
	private WebElement cityNa;
	
	@FindBy(id ="id_state")
	private WebElement state;
	
	@FindBy(id = "postcode")
	private WebElement postalCod;
	
	@FindBy(id = "id_country")
	private WebElement country;
	
	@FindBy(id = "phone")
	private WebElement Homeph;
	
	@FindBy(id = "phone_mobile")
	private WebElement mobPh;
	
	@FindBy(name = "alias")
	private WebElement addinfo;
	
	@FindBy(id = "submitAddress")
	private WebElement savebtn;
	
	public AddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void addAddres() {
		addaddr.click();
	}
	public void addresBtn() {
		addr.sendKeys("Hadpsar ");
	}
	public void cityName() {
		cityNa.sendKeys("Pune");
	}
	public void stateName() {
		Select s = new Select(state);
		s.selectByIndex(2);
		//s.selectByValue("Hawaii");
	}
	public void countryName() {
		country.click();
	}
	public void postalCode() {
		postalCod.sendKeys("41128");
	}
	public void HomePhone() {
		Homeph.sendKeys("8788622119");
	}
	public void MobilePhone() {
		mobPh.sendKeys("9860205300");
	}
	public void AddtionalInfo() {
		addinfo.sendKeys("adminertdn");
	}
	public void saveInfo() {
		savebtn.click();
	}
}
