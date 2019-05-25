package eply.com.pageobjects;

import org.openqa.selenium.Alert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	WebDriver driver;
	JavascriptExecutor js;
	public String winHandleBefore;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js=(JavascriptExecutor)driver;
	}

	public void click (WebElement el) {
		highlightElement(el, "yellow");
		el.click();
		sleep(1000);
	}

	public void fillText(WebElement el, String text) {
		highlightElement(el, "orange");
		el.clear();
		el.sendKeys(text);
	}

	public String getText (WebElement el) {
		highlightElement(el, "green");
		return el.getText();
	}

	public String getUrl (WebElement el) {
		highlightElement(el, "#7FFFD4");
		sleep(1000);
		return el.getText();

	}

	public void isDisplayed (WebElement el) {
		highlightElement(el, "black");
		el.isDisplayed();
	}
	
	public void isSelected (WebElement el) {
		highlightElement(el, "#DC143C");
		el.isSelected();
	}

	public void selectText(WebElement el, String text) { 
		//highlight
		Select select = new Select(el);
		select.selectByVisibleText(text);
	}
	
	public void selectIndex(WebElement el, int i) {
		Select select = new Select(el);
		select.selectByIndex(i);
	}

	public void dragAndDrop (WebElement drag, WebElement drop) {
		//	highlightElement(el, "#0080ff");
		Actions act = new Actions(driver);
		//	WebElement drop = null;
		//	WebElement drag = null;
		act.dragAndDrop(drag, drop).build().perform();
	}

	public void DragAndDropBoxes (WebElement el, WebElement subEl) {
		Actions action = new Actions(driver);
		action.dragAndDrop(el, subEl);
	}

	public void acceptAlert() /*(WebElement el)*/ {
		//highlightElement(el, "purple");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() /*(WebElement el)*/ {
		//highlightElement(el, "purple");
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void hoverPopUp (WebElement el, WebElement subEl) {
		highlightElement(el, "#00BFFF");
		Actions action = new Actions(driver);
		action.moveToElement(el).perform();
		sleep(2000);
		action.moveToElement(subEl);
		action.click();
		action.perform();
	}
	
	public void canvasCoordinatesClick(WebElement el, int xOffset, int yOffset) {
		highlightElement(el, "pink");
		Actions action = new Actions(driver);
		action.moveToElement(el);
		action.moveByOffset(xOffset, yOffset);
		action.click().build().perform();
		
	}

	public void refreshPage (WebElement el) {
		driver.navigate().refresh();	
		sleep(1000);
	}
	
	public void switchWindow() {
		this.winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	public void returnToWindow() {
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	protected void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 2px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		//change the style back after few seconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},800);", element);
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver , 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver , 30);
        wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void sleep(long mil) {
		try {
			Thread.sleep(mil);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
