package crm.product;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.ProductPage;

/**
 * Test Script: Create Product Test using POM design pattern.
 * Steps:
 *   1. Login to VTiger CRM
 *   2. Navigate to Products module
 *   3. Click Create Product
 *   4. Fill in the product form (name, code, unit price, qty per unit)
 *   5. Save and verify
 *   6. Logout
 */
public class CreateProductTest {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		get the data from json file
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.getDataFromJsonFile("bro");
		String url = fUtil.getDataFromJsonFile("url");
		String username = fUtil.getDataFromJsonFile("un");
		String password = fUtil.getDataFromJsonFile("pwd");

//		generate a unique product name
		String productName = "AutoProduct" + JavaUtility.generateRandomNumber();
		String productCode = "PROD" + JavaUtility.generateRandomNumber();

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

//		navigate to url & login
		driver.get(url);
		driver.navigate().refresh();

//		========== POM: LoginPage ==========
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();

//		========== POM: HomePage ==========
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

//		========== POM: ProductPage ==========
		ProductPage pp = new ProductPage(driver);
		pp.getCreateProductButton().click();

//		fill the Create Product form
		pp.getProductName().sendKeys(productName);
		pp.getProductCode().sendKeys(productCode);
		pp.getQtyPerUnit().sendKeys("1");
		pp.getUnitPrice().sendKeys("999.99");
		pp.getCommissionRate().sendKeys("10");
		pp.getQtyInStock().sendKeys("100");
		pp.getReorderLevel().sendKeys("10");

//		select product category
		Select categorySelect = new Select(pp.getProductCategory());
		categorySelect.selectByIndex(1); // select first available category

//		add description
		pp.getDescription().sendKeys("Automated test product created by Selenium POM script.");

//		save the record
		pp.getSaveButton().click();

//		verification
		String actProductName = pp.getDetailViewProductName().getText();
		if (actProductName.equals(productName)) {
			System.out.println("Product created successfully! Name: " + actProductName);
		} else {
			System.out.println("Product creation failed! Expected: " + productName + " | Actual: " + actProductName);
		}

//		logout
		HomePage hp2 = new HomePage(driver);
		wdUtil.hover(hp2.getProfileIcon());
		hp2.getSignOutLink().click();

//		close the browser
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Create Product Test Completed.");
	}
}
