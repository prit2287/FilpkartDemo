package com.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utility.WaitUtility;

public class SearchProduct extends TestBase {

	@FindBy(xpath = "//input[@type='text']")
	static WebElement search_box;

	@FindBy(xpath = "//div[@class='_2QfC02']/child::button[1]")
	static WebElement clk_cross;

	public SearchProduct() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public static void click_on_page() throws InterruptedException, AWTException {
		Actions actions = new Actions(driver);

		Robot robot = new Robot();

		robot.mouseMove(20, 20);

		actions.click().build().perform();

		robot.mouseMove(200, 70);

		actions.click().build().perform();
	}

	public static void search_product() {
		WebElement searchbox = driver.findElement(By.xpath("//input[@type='text']"));
		searchbox.sendKeys("smartphone" + Keys.ENTER);
		

	}

	public static void all_mobileList() {
		
		driver.navigate().refresh();
		
		List<WebElement> flipkartTotalItems = driver.findElements(By.tagName("a"));
		System.out.println(flipkartTotalItems.size());
		for(WebElement count:flipkartTotalItems)
		{
		   if(count.equals("APPLE iPhone 12 (Blue, 128 GB)"))
		   {
			   System.out.println(count.getText());
		   }
		}
		

}
}
