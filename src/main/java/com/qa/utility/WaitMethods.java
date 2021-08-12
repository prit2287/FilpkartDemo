package com.qa.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class WaitMethods  extends TestBase{
	
	public static void clickon(WebDriver driver , WebElement element , int timeout)
	{
		
		new WebDriverWait(driver,timeout).until(ExpectedConditions.invisibilityOf(element));
		element.click();
		
	}
	
	
	public static void sendkeys(WebDriver driver , final WebElement element , int timeout , String value )
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	
	public static void clearData(WebDriver driver , WebElement element , int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
	}

}
