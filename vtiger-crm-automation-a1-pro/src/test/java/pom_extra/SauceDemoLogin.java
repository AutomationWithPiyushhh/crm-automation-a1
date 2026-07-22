package pom_extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLogin {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.saucedemo.com/");

		LoginPage lp = new LoginPage(driver);

		WebElement username = lp.getUsername();
		WebElement password = lp.getPassword();
		WebElement loginButton = lp.getLoginButton();

		Thread.sleep(3000);
		driver.navigate().refresh();

//		util
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginButton.click();

//		add to cart
		HomePage hp = new HomePage(driver);
		hp.getAddToCart().click();
		hp.getCart().click();

//		checkout
		CartPage cp = new CartPage(driver);
		cp.getCheckoutButton().click();

		Thread.sleep(4000);
		driver.quit();
	}
}
