package eply.com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class MyFormsPage extends BasePage {

	@FindBy(css="#ePlyHeader_SearchLink")
	WebElement searchAll;
	@FindBy(css="#ePlyHeader_accountLink")
	WebElement account;
	@FindBy(css="#DateFilter")
	WebElement DropDownBtn;
	//WebElement dropDownSelection;
	@FindBy(css="#DateFilter>[selected]")
	WebElement selectedTimeAmount;

	public MyFormsPage(WebDriver driver) {
		super(driver);
	}

	//Actions
	public void openSearchAll() {
		click(searchAll);
	}
	
    @Step("click on account link {0}")
	public void account() {
		click(account);
	}

	public void dropDownBtn() {
		click(DropDownBtn);
	}

	public void runFilter(String text) {
		//should implement it
	}

	public int getTableRows() {
		List<WebElement> rows = driver.findElements(By.cssSelector(".rgMasterTable tr"));
		return rows.size();
	}

	public String dropDownSelection(String textToSelect) {
		Select select = new Select(DropDownBtn);
		select.selectByVisibleText(textToSelect);
		String selectedValue = selectedTimeAmount.getAttribute("value");
		return selectedValue;
	}

}