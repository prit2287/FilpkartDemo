package com.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class SelectClass extends TestBase {
	
	public static void selectDropDownValue(By locator , String type , String value )
	{
		Select sel = new Select(getElement(locator));
		switch(type) {
		case"index":
			sel.selectByIndex(Integer.parseInt(value));
			break; 
		case"value":
			sel.selectByValue(value);
			break;
		case"visibletext":
			sel.selectByVisibleText(value);
			break;
			
			default:
				System.out.println("please pass the correct value ..");
			
		
		}
		
	}

	private static WebElement getElement(By locator) {
		// TODO Auto-generated method stub
		return driver.findElement(locator);
	}

	
	
		
	

	

}
