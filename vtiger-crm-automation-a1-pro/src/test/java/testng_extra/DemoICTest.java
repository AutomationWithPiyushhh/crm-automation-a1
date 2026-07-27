package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class DemoICTest {
	@Test(invocationCount = 10, threadPoolSize = 11)
	public void setUp() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		Thread.sleep(10000);
		driver.quit();
	}
	
}
