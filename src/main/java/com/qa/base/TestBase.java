package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.utility.ScreenshotClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;

	static ExtentReports extentReport;
	static ExtentTest extentTest;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// @Parameters("browser")
	// @BeforeTest
	
	public static void initialization(String browsername) throws InterruptedException {

		try {

			if (browsername.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browsername.equals("FF")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\parag.ladekar\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (browsername.equals("IE")) {
				System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer_x64_3.150.1 (2)\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	     Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		driver.manage().deleteAllCookies();

		extentReport = new ExtentReports(System.getProperty("user.dir") + "/test-output/APIMReport.html", true);
	
	}

	@AfterMethod
	public static void attachScreenshot(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			extentTest.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			String screenshotPath = ScreenshotClass.getScreenhot(driver, result.getName());

			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}

		extentReport.endTest(extentTest);
	}

	@AfterTest
	public static void teardown() {
		//extentReport.flush();

	}

}
