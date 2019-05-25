package eply.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import eply.com.pageobjects.LoginPage;
import eply.com.pageobjects.MyFormsPage;
import eply.com.pageobjects.SearchPage;

public class SearchTest extends BaseTest {

	@Test (description="Login")
	public void login() throws InterruptedException {
		//open login page
		driver.get("https://www.eply.com/Login/index.aspx?Logout=True");
		//initiate login page and log-in with credentials
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.login("shavit1986@gmail.com", "shavitdemo123");
		Thread.sleep(2000);
		String expected = "Hello, Shavit!";
		String actual = LoginPage.loginValidate();
		Assert.assertEquals(actual, expected);
	}

	@Test (description="search event and validate search was made")
	public void search() {
		//initiate the main page + click the searchAll link
		MyFormsPage myForms = new MyFormsPage(driver); 
		myForms.openSearchAll();
		//initiate the search page + execute search
		SearchPage searchPage = new SearchPage(driver);
		searchPage.search("shavit", "jerasi", "shavitAutomation", "shavit@gmail.com", "8/21/2018 12:00 AM", "8/28/2018 12:00 AM");
		//validation for Test results
		String expected = "The search was done.";
		String actual = searchPage.isSearchSucceed();
		Assert.assertEquals(actual, expected);
	}
}
