package eply.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import eply.com.pageobjects.ForgotPasswordPage;
import eply.com.pageobjects.LoginPage;

public class ForgotPasswordTest extends BaseTest {

	@Test(description="forgot Password displays Msg for wrong Email")
	public void forgotPassword() {
		driver.get("https://www.eply.com/login/index.aspx");
		//open login page and click on 'forgotPassword' link
		LoginPage loginPage = new LoginPage(driver);
		loginPage.forgotPassword();
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.forgotPassword("shavit@gmail.com");
		String expected = "instructions on how to reset your password";
		String actual = forgotPasswordPage.getMessage();
		if (actual.toLowerCase().contains(expected)) {
			System.out.println(expected);
			Assert.assertEquals(actual, expected);
		}
	}

}