package eply.com.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	WebDriver driver;

	//Define driver
	@BeforeClass
	public void setup() {
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\��������\\Selenium\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void setWaitForPage() {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void failedTest(ITestResult result) {
		//check if test failed
		if(result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
