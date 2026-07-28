package testng_dp_extra;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoLogin {

	@Test(dataProvider = "getData")
	public void login(String un , String pwd) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.saucedemo.com/");

		LoginPage lp = new LoginPage(driver);

		WebElement username = lp.getUsername();
		WebElement password = lp.getPassword();
		WebElement loginButton = lp.getLoginButton();

//		same set of data
//		String un = "standard_user";
//		String pwd = "secret_sauce";

		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();

		boolean status = driver.getCurrentUrl().contains("inventory");

		Assert.assertTrue(status);

		Thread.sleep(1000);
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] creds = new Object[6][2];
//      							row column
//							num of row => num of execution
//							num of col => num of parameters
		creds[0][0] = "standard_user";
		creds[0][1] = "secret_sauce";

		creds[1][0] = "locked_out_user";
		creds[1][1] = "secret_sauce";

		creds[2][0] = "problem_user";
		creds[2][1] = "secret_sauce";

		creds[3][0] = "performance_glitch_user";
		creds[3][1] = "secret_sauce";

		creds[4][0] = "error_user";
		creds[4][1] = "secret_sauce";

		creds[5][0] = "visual_user";
		creds[5][1] = "secret_sauce";

		return creds;
		
	}

}
