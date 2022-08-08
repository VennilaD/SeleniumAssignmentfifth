package com.pages;

import org.openqa.selenium.By;

import com.utility.Library;

public class Alerts {
public static By normalAlert=By.name("alert");
public static By confirmalert=By.name("confirmation");
public static By promptalert=By.name("prompt");

public static void clickonaormalalert() {
	Library.driver.findElement(normalAlert).click();
}
public static void clickonconfirmalert() {
	Library.driver.findElement(confirmalert).click();
}
public static void clickonpromptalert() {
	Library.driver.findElement(promptalert).click();
}





}




