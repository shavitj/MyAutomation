package eply.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(css="#body_Username")
	WebElement Username;
	@FindBy(css="#body_Password")
	WebElement Password;
	@FindBy(css="#body_SubmitButton")
	WebElement loginbtn;
	@FindBy(css="#body_ForgotPasswordButton")
	WebElement forgotPasswordLink;
	@FindBy(css="#body_ErrorMessage")
	WebElement errorMsg; 
	@FindBy(css="#ePlyHeader_FirstName")
	WebElement loginSucceed;

	public LoginPage (WebDriver driver) {
		super (driver);
	}

	//Actions
	public void login(String Username,String Password) {
		fillText(this.Username, Username);
		fillText(this.Password, Password);
		click(loginbtn);
	}

	public void forgotPassword() {
		click (forgotPasswordLink);
	}

	public String getErrorMessage() {
		return getText(errorMsg);
	}

	public String loginValidate() {
		String name = loginSucceed.getText();
		return name;
	}

}
