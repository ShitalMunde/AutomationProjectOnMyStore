package com.MyProjectStore.TestCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.Logger;
import com.MyProjectStore.Utility.ReadConfig;


public class BaseClass {


	ReadConfig red = new ReadConfig();
	String url = red.getBaseurl();
	String browser = red.getBrowser();
	
	public static WebDriver driver;
	public static Logger log;
	
	@BeforeClass
	public void setup() {
		
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		log = LogManager.getLogger("MyProjectStore");
		
	}
	@AfterClass
	public void closeApp() {
		//driver.close();
	}
	
	public void takeScreenshot(WebDriver driver,String testName){
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "//ScreenShots//" + testName + ".png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
		}
	}

	
}
