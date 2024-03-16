package com.MyProjectStore.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MySProjectStorePageObject.AddToCartPage;
import com.MySProjectStorePageObject.AddressDetailsPage;
import com.MySProjectStorePageObject.AgreeTerms;
import com.MySProjectStorePageObject.BillingAddress;
import com.MySProjectStorePageObject.Checkout;
import com.MySProjectStorePageObject.CofirmOrder;
import com.MySProjectStorePageObject.PaymentOption;
import com.MySProjectStorePageObject.VerifySearchProduct;

public class TC_Product extends BaseClass {

	@Test
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
}
