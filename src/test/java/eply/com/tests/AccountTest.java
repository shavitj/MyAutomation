package eply.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import eply.com.pageobjects.AccountPage;
import eply.com.pageobjects.LoginPage;
import eply.com.pageobjects.MyFormsPage;

public class AccountTest extends BaseTest {

	@Test(description="Login") 
	public void login() throws InterruptedException {
		driver.get("https://www.eply.com/Login/index.aspx");
		//initiate login
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.login("shavit1986@gmail.com", "shavitdemo123");
		Thread.sleep(2000);
		String expected = "Hello, Shavit!";
		String actual = LoginPage.loginValidate();
		Assert.assertEquals(actual, expected);
	}

	@Test(description="add account details and validate saved")
	public void accountDetails() {
		MyFormsPage myForms = new MyFormsPage(driver);
		myForms.account();
		//enter details
		AccountPage accountPage = new AccountPage(driver);
		String expected = "Saved.";
		String actual = accountPage.account("ShavitQA.co.il", "Tabenkin", "Haifa", "Israel");
		Assert.assertEquals(actual, expected);
	}

}
