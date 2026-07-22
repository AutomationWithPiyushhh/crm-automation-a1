package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	


	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addToCart;

	@FindBy(css = "a[data-test='shopping-cart-link']")
	private WebElement cart;


	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getCart() {
		return cart;
	}
}
