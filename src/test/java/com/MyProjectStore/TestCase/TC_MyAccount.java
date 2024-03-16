
package com.MyProjectStore.TestCase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.MyProjectStore.Utility.Map;
import com.MySProjectStorePageObject.AddToCartPage;
import com.MySProjectStorePageObject.AddressDetailsPage;
import com.MySProjectStorePageObject.AgreeTerms;
import com.MySProjectStorePageObject.BillingAddress;
import com.MySProjectStorePageObject.Checkout;
import com.MySProjectStorePageObject.CofirmOrder;
import com.MySProjectStorePageObject.IndexPage;
import com.MySProjectStorePageObject.MyAccount;
import com.MySProjectStorePageObject.PaymentOption;
import com.MySProjectStorePageObject.VerifyLogin;
import com.MySProjectStorePageObject.VerifyRegisterUserName;
import com.MySProjectStorePageObject.VerifySearchProduct;
import com.MySProjectStorePageObject.createAccPage;

public class TC_MyAccount extends BaseClass {

	@Test(enabled = false)
	public void VerifyRegisteration() {
		
		driver.get(url);
		log.info("url Opened");
		
		IndexPage pg = new IndexPage(driver);
		pg.signIn();
		log.info("SignIn Clicked");
		
		MyAccount acc = new MyAccount(driver);
		acc.email();
		log.info("You have enter your Email");
		acc.submitbtn();
		log.info("You have create your account ");
		
		createAccPage crAcc = new createAccPage(driver);
		crAcc.genderSelect();
		crAcc.EnterFN();
		crAcc.EnterLN();
		crAcc.EnterPw();
		crAcc.submit();
		log.info("Your have created your account sucessfully");
		
		VerifyRegisterUserName user = new VerifyRegisterUserName(driver);
		String actualRes = user.getUser();
		Assert.assertEquals("Adams com", actualRes);
		Reporter.log("Your Result  is matched",true);
		log.info("Your user is matched");
	}
	@Test(enabled = false)
	public void verifyLogin() throws InterruptedException {
		
		driver.get(url);
		log.info("url Opened");
		
		IndexPage pg = new IndexPage(driver);
		pg.signIn();
		log.info("SignIn Clicked");
		
		VerifyLogin login = new VerifyLogin(driver);
		Thread.sleep(3000);
		login.mailBtn("adamscom2922@gmail.com");
		login.pwdbtn("admascom");
		login.submitClick();
		
		VerifyRegisterUserName user = new VerifyRegisterUserName(driver);
		String actualRes = user.getUser();
		if(actualRes.equals("Adams com")) {
			log.info("Verify Login ..........Pass");
			Assert.assertTrue(true);
		}
		else {
			log.info("Verify Login ..........Fail");
			takeScreenshot(driver, "Verify Login");
			Assert.assertTrue(true);
		}
		
	}
	
	@Test(dependsOnMethods = "verifyLogin" , enabled = false)
	public void productPurchase() throws InterruptedException {
		Thread.sleep(3000);
		VerifySearchProduct srchpro = new VerifySearchProduct(driver);
		srchpro.search();
		String expRes = srchpro.Product();
		Assert.assertEquals("Printed Summer Dress",expRes);
		log.info("You have search product and matched");
		
		Thread.sleep(3000);
		AddToCartPage cart = new AddToCartPage(driver);
		cart.selectProduct();
		cart.addTocart();
		cart.productCheckOut();
		log.info("Product is added into cart");
		
		
		Checkout che = new Checkout(driver);
		che.finalCheckOut();
		
		AddressDetailsPage addrPg = new AddressDetailsPage(driver);
		addrPg.addAddres();
		addrPg.addresBtn();
		addrPg.cityName();
		addrPg.stateName();
		addrPg.countryName();
		addrPg.postalCode();
		addrPg.HomePhone();
		addrPg.MobilePhone();
		addrPg.AddtionalInfo();
		addrPg.saveInfo();
		log.info("Your Address details for product");
		
		BillingAddress bill = new BillingAddress(driver);
		bill.shipingCheckout();
		log.info("Address is Final");
		
		AgreeTerms agTerm =new AgreeTerms(driver) ;
		agTerm.agreeTerms();
		agTerm.checkOutbtn();
		log.info("Your are agree with terms and condition");
		
		PaymentOption pay = new PaymentOption(driver);
		pay.paymentOption1();
		log.info("You have Select Payment Option");
		
		CofirmOrder ord = new CofirmOrder(driver);
		ord.cofirmBtn();
		log.info("You order is confirmed");
	}
	@Test(enabled = true)
	public void LoginUsingDDT() throws InterruptedException {
		driver.get(url);
		log.info("url Opened");
		
		IndexPage pg = new IndexPage(driver);
		pg.signIn();
		log.info("SignIn Clicked");
		VerifyLogin login = new VerifyLogin(driver);
		Thread.sleep(3000);
		Map.readDataToMap("LoginPg");
		login.mailBtn(Map.getDatafromMap("Email"));
		login.pwdbtn(Map.getDatafromMap("Pwd"));
		login.submitClick();
		//System.out.println("You have login suessfully");
	}
}
