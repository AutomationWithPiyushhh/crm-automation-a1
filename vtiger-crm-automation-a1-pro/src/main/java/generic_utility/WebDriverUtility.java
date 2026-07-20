package generic_utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	WebDriver driver;
	Actions act;
	WebDriverWait wait;

//	this points to the current class object
	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void hover(WebElement element) {

		act.moveToElement(element).build().perform();
	}

	public void rightClick(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void waitAndClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void waitForEleToVisibleAndClick(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void select(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	public void select(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void switchToWinByTitle(String partialTitle) {

		
		
		
		
		
		
		
		
	}

	public void switchToWinByUrl(String partialUrl) {

	}

}
