package com.pages;

import org.openqa.selenium.By;

public class Frames {
public static String singleframe="frame1";
public static By insidesingleframe=By.tagName("input");
public static String checkboxframe="frame3";
public static By clickcheckbox=By.id("a");
public static String dropdownframe="frame2";
public static By clickdropdown=By.id("animals");
public static By outerframeisframe1=By.xpath("//iframe[@data-ezsrc='frames1.html']");
public static By innerframeisframe3=By.xpath("//iframe[@data-ezsrc='checkbox.html']");


}
