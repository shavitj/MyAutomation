package eply.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import eply.com.pageobjects.LoginPage;
import eply.com.pageobjects.MyFormsPage;

public class FormsFilterTest extends BaseTest {

	@Test(description="Login")
	public void login() throws InterruptedException {
		//open login page
		driver.get("https://www.eply.com/Login/index.aspx");
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.login("shavit1986@gmail.com", "shavitdemo123");
		Thread.sleep(2000);
		String expected = "Hello, Shavit!";
		String actual = LoginPage.loginValidate();
		Assert.assertEquals(actual, expected);
	}

	@Test(description="select time Amount for events display and validate selection from element attribute")
	public void formsPeriod() {
		//select from drop-down
		MyFormsPage myFormsPage = new MyFormsPage(driver);
		String expected = "9 months";
		String actual = myFormsPage.dropDownSelection("9 months");
		Assert.assertEquals(actual, expected);
	}

}
