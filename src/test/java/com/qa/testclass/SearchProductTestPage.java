package com.qa.testclass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.SearchProduct;

public class SearchProductTestPage extends TestBase {

	@BeforeTest
	public void setup() throws InterruptedException {
		initialization("chrome");
	}

	@Test(priority=1 , groups= {"smoke"})
	public static void searchProduct() {
		try {
		SearchProduct.click_on_page();
		SearchProduct.search_product();
		SearchProduct.all_mobileList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception raised");
		}

	}
}
