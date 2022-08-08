package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {
	public static Properties ObjProperties;
	public static WebDriver driver;

	
	public static void ReadPropertiesFile() {
		try {
			FileInputStream ObjInputStream=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
		    ObjProperties=new Properties();
			ObjProperties.load(ObjInputStream);
			System.out.println(ObjProperties.getProperty("browser"));
			System.out.println(ObjProperties.getProperty("GmoOnlineURL"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	 public static void Launchbrowser() {
			String browserfromproperties=ObjProperties.getProperty("browser");
			WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
			  driver.get(ObjProperties.getProperty("GmoOnlineURL"));
			  driver.manage().window().maximize();
			 // driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	 }  
			  
	public static void ExplicitWaitForAlertIsPresent() {
		WebDriverWait wait = new WebDriverWait(driver,Constants.ExplicitWait);
		  wait.until(ExpectedConditions.alertIsPresent());
	}	


}