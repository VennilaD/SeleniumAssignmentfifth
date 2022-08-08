package com.gmoonline;

import org.testng.annotations.Test;

import com.pages.Alerts;
import com.utility.Constants;
import com.utility.Library;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidatingalertsPOM extends Library{
	@Test(priority=0)
	  public void Alertvalidation() {
		  
		  System.out.println("inside Alertvalidation");
		  driver.navigate().to(ObjProperties.getProperty("chercheralertvalidation"));
		  driver.manage().timeouts().pageLoadTimeout(Constants.pageLoadTimeOut,TimeUnit.SECONDS);
		 String alertpagetitle = driver.getTitle();
		 System.out.println("alertpagetitle:"+alertpagetitle);
		 Assert.assertEquals(alertpagetitle, ObjProperties.getProperty("titleofalertwindow"));
			 
	  }
		 
	  @Test(priority=1	)
	  public void validationtypesofalerts() throws InterruptedException {
		  driver.findElement(Alerts.normalAlert).click();
		  ExplicitWaitForAlertIsPresent();
		  Thread.sleep(5000);
		  Alert normalAlert=driver.switchTo().alert();
		  String normalalertmessage=normalAlert.getText();
		  System.out.println("normalalertmessage :"+normalalertmessage);
		  Assert.assertEquals(normalalertmessage, ObjProperties.getProperty("alertmessageinaccepttype"));
		  normalAlert.accept();
		  
		  
		  driver.findElement(Alerts.confirmalert).click();
		  ExplicitWaitForAlertIsPresent();
		  Thread.sleep(5000);
		  Alert confirmalert=driver.switchTo().alert();
		  String confirmalerttitle=confirmalert.getText();
		  System.out.println("confirmalerttitle :"+confirmalerttitle);
		  Assert.assertEquals(confirmalerttitle,ObjProperties.getProperty("confirmalertmessage"));
		  confirmalert.dismiss();
		  
		  driver.findElement(Alerts.promptalert).click();
		  ExplicitWaitForAlertIsPresent();
		  Thread.sleep(5000);
		  Alert promptalert=driver.switchTo().alert();
		  promptalert.sendKeys(ObjProperties.getProperty("promptalersendkeys"));
		  promptalert.accept();
		  
	  }
	
	
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  Library.Launchbrowser();
  }

 
@AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  ReadPropertiesFile();
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  
  }

  
@AfterSuite
  public void afterSuite() {
  }

}
