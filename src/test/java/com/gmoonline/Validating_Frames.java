package com.gmoonline;

import org.testng.annotations.Test;

import com.pages.Frames;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Validating_Frames extends Library{
	

	  
	@Test(priority=0)
	public  void validatepageloadinginframes() {
		
		driver.get(ObjProperties.getProperty("chercherframesvalidation"));
		String framestitle=driver.getTitle();
		System.out.println("framestitle :+framestitle");
		Assert.assertEquals(framestitle,ObjProperties.getProperty("chercherframestitle"),"frames title is invalid");
	}
	
	@Test(priority=1)
	public void validatesingleframes() throws InterruptedException {
		System.out.println("inside validatingsingleframes");
		driver.switchTo().frame(Frames.singleframe);
		driver.findElement(Frames.insidesingleframe).clear();
	    driver.findElement(Frames.insidesingleframe).sendKeys(ObjProperties.getProperty("insidesingleframetext"));
	    driver.switchTo().frame(Frames.checkboxframe);
	    driver.findElement(Frames.clickcheckbox).click();
	    Thread.sleep(3000);
	    driver.findElement(Frames.clickcheckbox).click();
	    Thread.sleep(3000);
	    driver.switchTo().defaultContent();
	    
	}
  @Test(priority=2)
  public void validatingdropdownframe() throws InterruptedException {
	  System.out.println("inside validatingdropdowns");
	  driver.switchTo().frame(Frames.dropdownframe);
	  driver.findElement(Frames.clickdropdown).click();
	  Thread.sleep(3000);
	  driver.switchTo().defaultContent();
	  	  
 
  }
  @Test(priority=3)
  public void validatingmultipleframes() {
	  System.out.println("inside validatingmultipleframes");
	  WebElement outerframeelement=driver.findElement(Frames.outerframeisframe1);
	  driver.switchTo().frame(outerframeelement);
	  WebElement innerframeelement=driver.findElement(Frames.innerframeisframe3);
	  driver.switchTo().frame(innerframeelement);
	  driver.findElement(Frames.clickcheckbox).click();
	  driver.switchTo().defaultContent();
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
	 // driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  
  }

  
@AfterSuite
  public void afterSuite() {
  }

}
