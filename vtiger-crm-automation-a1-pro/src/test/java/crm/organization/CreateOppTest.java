package crm.organization;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;

public class CreateOppTest {
	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

//		get the data from Excel file
		String oppName = fUtil.getDataFromExcelFile("opp", 2, 0);

//		open browser
		WebDriver driver = null;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.maximizeWindow();
		wdUtil.waitForPageLoad();
//		login	
		driver.get(url);

		WebElement un = driver.findElement(By.name("user_name"));
		WebElement pwd = driver.findElement(By.name("user_password"));
		WebElement loginButton = driver.findElement(By.id("submitButton"));

		un.sendKeys(username);
		pwd.sendKeys(password);
		loginButton.click();

//		create opportunity
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.cssSelector("img[title='Create Opportunity...']")).click();

//		fill the form
		WebElement oppField = driver.findElement(By.name("potentialname"));
		oppField.sendKeys(oppName);

//		add organization

//		step 1> get the home address 
		String PID = driver.getWindowHandle(); // 32 digits unique session id in string format

//		step 2> perform the task which will open new window/s or tab/s
		driver.findElement(By.xpath("//img[contains(@onclick ,'module=Potential')]")).click();

		wdUtil.switchToWindowByUrl("Accounts");

//		step 6> perform the task on your desired webpage
		driver.findElement(By.partialLinkText("vtiger")).click();

//		step 7> come back to home
		driver.switchTo().window(PID);

//		save
		driver.findElement(By.className("save")).click();

//		verification

//		logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

//		hover on profile
		wdUtil.hover(profile);

//		click on sign out link
		driver.findElement(By.linkText("Sign Out")).click();

//		close the browser
		Thread.sleep(3000);
		driver.quit();
	}
}
