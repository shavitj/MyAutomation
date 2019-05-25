package eply.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

	@FindBy(css="#Website")
	WebElement webSite;
	@FindBy(css="#Address")
	WebElement StreetAddress;
	@FindBy(css="#Province")
	WebElement Province;
	@FindBy(css="#Country")
	WebElement Country;
	@FindBy(css="#Button1")
	WebElement btnSave;
	@FindBy(css=".saveInfo")
	WebElement detailesSaved;

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	//Actions

	public String account(String webSite,String StreetAddress,String Province,String Country) {
		String saved = detailesSaved.getText();
		fillText(this.webSite, webSite);
		fillText(this.StreetAddress, StreetAddress);
		fillText(this.Province, Province);
		fillText(this.Country, Country);
		click(btnSave);
		return saved;
	}
}
