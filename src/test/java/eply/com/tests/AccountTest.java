package eply.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import eply.com.pageobjects.AccountPage;
import eply.com.pageobjects.LoginPage;
import eply.com.pageobjects.MyFormsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Epic("Shopping Cart")
@Feature("Account details")
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

	@Link("https://demo.qameta.io/allure/#")
	@TmsLink("https://www.gurock.com/testrail")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a User when I add details - text 'saved.' should appears")
	@Issue("2")
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
