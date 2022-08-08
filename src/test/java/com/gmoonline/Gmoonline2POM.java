package com.gmoonline;

import org.testng.annotations.Test;

import com.pages.Gmoonlineproductplacing;
import com.utility.Constants;
import com.utility.Library;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Gmoonline2POM extends Library{
	//WebDriver driver;
	
	
  @Test(priority=0)
  public void Validategmoonlinetitle() {
	  
	  String title=driver.getTitle();
	  System.out.println("title:" +title);
	  Assert.assertEquals(title, ObjProperties.getProperty("GmoOnlineTitle"));
	  
  }
  @Test(priority=1,dependsOnMethods= {"Validategmoonlinetitle"})
  public void ValidateEnterGmoOnline() {
	  	driver.findElement(Gmoonlineproductplacing.Entergmoonline).click();
	  	driver.manage().timeouts().pageLoadTimeout(Constants.pageLoadTimeOut,TimeUnit.SECONDS);
		driver.findElement(Gmoonlineproductplacing.clearingglassesindexbox).clear();
	  	driver.findElement(Gmoonlineproductplacing.enteringquantityofglasses).sendKeys(Constants.QuantityOfSunGlasses);
		driver.findElement(Gmoonlineproductplacing.clickplacetheorder).click();
		String titleofplaceorder=driver.getTitle();
		System.out.println("titleofplaceorder: "+titleofplaceorder);
		Assert.assertEquals(titleofplaceorder, ObjProperties.getProperty("placeordertitle"));
		
		String glassprice=driver.findElement(Gmoonlineproductplacing.unitpriceofsunglasses).getText().substring(2);
		System.out.println("glassprice: "+glassprice);
		Float threeglassprice=Float.parseFloat(glassprice)*Integer.parseInt(Constants.QuantityOfSunGlasses);
		System.out.println("threeglassprice :"+threeglassprice);
		
		String applicationthreeglassprice=driver.findElement(Gmoonlineproductplacing.priceofsunglassesfromapplication).getText().substring(2);
		Float fromapplicationthreeglassprice=Float.parseFloat(applicationthreeglassprice);
		System.out.println("fromapplicationthreeglassprice:"+fromapplicationthreeglassprice);
		Assert.assertEquals(threeglassprice, fromapplicationthreeglassprice);

		String producttotal=driver.findElement(Gmoonlineproductplacing.producttotalvalue).getText().substring(2);
		System.out.println("producttotal:"+producttotal);
		Float valueofproducttotal=Float.parseFloat(producttotal);


	
		String salestax=driver.findElement(Gmoonlineproductplacing.salestaxvalue).getText().substring(2);
		System.out.println("salestax:"+salestax);
		Float valueofsalestax=Float.parseFloat(salestax);
		
		String shippingandhandling=driver.findElement(Gmoonlineproductplacing.shippinghandlingvalue).getText().substring(2);
		System.out.println("shippingandhandling:"+shippingandhandling);
		Float valueofshippingandhandling=Float.parseFloat(shippingandhandling);
		
		Float total=Float.parseFloat(producttotal)+Float.parseFloat(salestax)+Float.parseFloat(shippingandhandling);
		System.out.println("total :"+total);
		
		
		String applicationgrandtotal=driver.findElement(Gmoonlineproductplacing.applicationgrandtotalvalue).getText().substring(2);
		System.out.println("applicationgrandtotal :"+applicationgrandtotal);
		Float valueofapplicationgrandtotal=Float.parseFloat(applicationgrandtotal);
		
		Assert.assertEquals(valueofapplicationgrandtotal,total);
		
		
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
