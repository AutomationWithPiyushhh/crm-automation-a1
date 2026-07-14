package crm.organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException, IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String browser = pObj.getProperty("bro");
		String url = pObj.getProperty("bro");
		String username = pObj.getProperty("bro");
		String password = pObj.getProperty("bro");

//		open browser
		WebDriver driver = null;

//		String browser = "chrome";

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		login	
		driver.get(url);

		WebElement un = driver.findElement(By.name("user_name"));
		WebElement pwd = driver.findElement(By.name("user_password"));
		WebElement loginButton = driver.findElement(By.id("submitButton"));

		un.sendKeys(username);
		pwd.sendKeys(password);
		loginButton.click();

//		create organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

//		fill the form
		String orgName = "qsp2134";
		WebElement orgField = driver.findElement(By.name("accountname"));

		orgField.sendKeys(orgName);

//		save
		driver.findElement(By.className("save")).click();

//		verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		if (actOrgName.equals(orgName)) {
			System.out.println("org created successfullyyyy !!!");
		} else {
			System.out.println("Could not create organization");
		}

//		logout

//		close the browser
		Thread.sleep(3000);
		driver.quit();
	}
}
