package eply.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

	@FindBy(css="#ForgotPasswordPanelUsernameField")
	WebElement username;
	@FindBy(css="#ForgotPasswordPanelSubmitButton")
	WebElement submit;
	@FindBy(css="#ForgotPasswordPanelSuccessLabel")
	WebElement message;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	public void forgotPassword(String user) {
		fillText(username, user);
		click(submit);

	}
	public String getMessage( ) {
		//message = driver.findElement(By.cssSelector("#ForgotPasswordPanelSuccessLabel"));
		return message.getText();
	}

}
