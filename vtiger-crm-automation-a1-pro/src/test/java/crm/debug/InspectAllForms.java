package crm.debug;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.FileUtility;

/**
 * Debug script to print all input field IDs/names on multiple module create pages.
 */
public class InspectAllForms {
    
    static WebDriver driver;
    static FileUtility fUtil;
    static String url;
    
    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
        fUtil = new FileUtility();
        url = fUtil.getDataFromJsonFile("url");
        String username = fUtil.getDataFromJsonFile("un");
        String password = fUtil.getDataFromJsonFile("pwd");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.findElement(By.name("user_name")).sendKeys(username);
        driver.findElement(By.name("user_password")).sendKeys(password);
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(2000);

        // Inspect Organization create form
        inspectCreateForm("Organizations", "img[title='Create Organization...']", "ORGANIZATION");

        // Inspect Contact create form
        navigateToModule("index.php?module=Contacts&action=index");
        inspectCreateForm(null, "img[title='Create Contact...']", "CONTACT");

        // Inspect Lead create form
        navigateToModule("index.php?module=Leads&action=index");
        inspectCreateForm(null, "img[title='Create Lead...']", "LEAD");

        // Inspect Opportunity create form
        navigateToModule("index.php?module=Potentials&action=index");
        inspectCreateForm(null, "img[title='Create Opportunity...']", "OPPORTUNITY");

        // Inspect HelpDesk create form
        navigateToModule("index.php?module=HelpDesk&action=index");
        inspectCreateForm(null, "img[title='Create Ticket...']", "HELPDESK/CASE");

        // Inspect Product create form
        navigateToModule("index.php?module=Products&action=index");
        inspectCreateForm(null, "img[title='Create Product...']", "PRODUCT");

        // Inspect Vendor create form
        navigateToModule("index.php?module=Vendors&action=index");
        inspectCreateForm(null, "img[title='Create Vendor...']", "VENDOR");

        // Inspect Campaign create form
        navigateToModule("index.php?module=Campaigns&action=index");
        inspectCreateForm(null, "img[title='Create Campaign...']", "CAMPAIGN");

        // Inspect Activity (Event) create form
        navigateToModule("index.php?module=Calendar&action=EditView&activity_mode=Events");
        System.out.println("===== ACTIVITY/EVENT Form Fields =====");
        printFormFields();
        System.out.println("===== End ACTIVITY/EVENT =====\n");
        
        driver.quit();
        System.out.println("Inspection complete!");
    }
    
    static void navigateToModule(String relPath) throws InterruptedException {
        driver.get(url + relPath);
        Thread.sleep(2000);
    }
    
    static void inspectCreateForm(String linkText, String createBtnCss, String label) throws InterruptedException {
        if (linkText != null) {
            driver.findElement(By.linkText(linkText)).click();
            Thread.sleep(1500);
        }
        try {
            driver.findElement(By.cssSelector(createBtnCss)).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Could not find create button for " + label + ": " + e.getMessage().split("\n")[0]);
            return;
        }
        System.out.println("===== " + label + " Form Fields =====");
        printFormFields();
        System.out.println("===== End " + label + " =====\n");
    }
    
    static void printFormFields() {
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for (WebElement el : inputs) {
            String id = el.getAttribute("id");
            String name = el.getAttribute("name");
            String type = el.getAttribute("type");
            if (!"hidden".equals(type) && type != null) {
                System.out.println("  INPUT: id='" + id + "' name='" + name + "' type='" + type + "'");
            }
        }
        List<WebElement> selects = driver.findElements(By.tagName("select"));
        for (WebElement el : selects) {
            System.out.println("  SELECT: id='" + el.getAttribute("id") + "' name='" + el.getAttribute("name") + "'");
        }
        List<WebElement> textareas = driver.findElements(By.tagName("textarea"));
        for (WebElement el : textareas) {
            System.out.println("  TEXTAREA: id='" + el.getAttribute("id") + "' name='" + el.getAttribute("name") + "'");
        }
    }
}
