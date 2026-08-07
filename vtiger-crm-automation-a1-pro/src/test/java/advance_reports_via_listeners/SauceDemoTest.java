package advance_reports_via_listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_utility.List_Imp.class)
public class SauceDemoTest {

	@Test
	public void login() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void logout() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		driver.quit();
		Assert.assertTrue(false);
	}

}
