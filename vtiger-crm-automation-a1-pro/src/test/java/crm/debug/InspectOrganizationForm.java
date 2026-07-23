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
 * Debug script to print all input field IDs/names on Organization create page.
 */
public class InspectOrganizationForm {
    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
        FileUtility fUtil = new FileUtility();
        String url = fUtil.getDataFromJsonFile("url");
        String username = fUtil.getDataFromJsonFile("un");
        String password = fUtil.getDataFromJsonFile("pwd");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(url);
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.findElement(By.name("user_name")).sendKeys(username);
        driver.findElement(By.name("user_password")).sendKeys(password);
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Organizations")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
        Thread.sleep(2000);

        System.out.println("===== Organization Form Fields =====");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for (WebElement el : inputs) {
            String id = el.getAttribute("id");
            String name = el.getAttribute("name");
            String type = el.getAttribute("type");
            if (!"hidden".equals(type)) {
                System.out.println("INPUT: id='" + id + "' name='" + name + "' type='" + type + "'");
            }
        }

        List<WebElement> selects = driver.findElements(By.tagName("select"));
        for (WebElement el : selects) {
            String id = el.getAttribute("id");
            String name = el.getAttribute("name");
            System.out.println("SELECT: id='" + id + "' name='" + name + "'");
        }

        List<WebElement> textareas = driver.findElements(By.tagName("textarea"));
        for (WebElement el : textareas) {
            String id = el.getAttribute("id");
            String name = el.getAttribute("name");
            System.out.println("TEXTAREA: id='" + id + "' name='" + name + "'");
        }

        System.out.println("===== End of Organization Form Fields =====");
        Thread.sleep(3000);
        driver.quit();
    }
}
