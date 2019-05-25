package eply.com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	@FindBy(css="#FirstName")
	WebElement firstName;
	@FindBy(css="#LastName")
	WebElement lastName;
	@FindBy(css="#Company")
	WebElement companyName;
	@FindBy(css="#Email")
	WebElement email;
	@FindBy(css="#SearchButton")
	WebElement btnSearch;
	@FindBy(css="#RadFromDatePicker_dateInput")
	WebElement fromDate;
	@FindBy(css="#RadToDatePicker_dateInput")
	WebElement toDate;
	@FindBy(css="#MessageLabel")
	WebElement message;

	public SearchPage(WebDriver driver) {
		super(driver);	
	}

	//Actions

	public void search(String firstName,String lastName,String companyName,String email, String fromDate, String toDate) {
		fillText(this.firstName, firstName);
		fillText(this.lastName, lastName);
		fillText(this.companyName, companyName);
		fillText(this.email, email);
		fillText(this.fromDate, fromDate);
		fillText(this.toDate, toDate);
		click(btnSearch);

	}

	public String isSearchSucceed ( ) {
		message = driver.findElement(By.cssSelector("#MessageLabel"));
		return message.getText();
	}

}

