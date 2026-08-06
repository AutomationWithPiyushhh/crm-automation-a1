package advance_reports_listeners;



import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_utility.List_Imp.class)
public class SauceDemoTest {

	@BeforeSuite
	public void repConfig() {
		System.out.println("it is @BeforeSuite");

	}

	@Test
	public void case1() throws InterruptedException {
		Assert.assertTrue(true);
	}

	@Test
	public void case2() {
		Assert.assertTrue(false);
	}

	@Test(dependsOnMethods = "case2")
	public void case3() throws InterruptedException {
		Assert.assertTrue(true);
	}

	@AfterSuite
	public void repBackup() {
		System.out.println("it is @AfterSuite");
	}

}
