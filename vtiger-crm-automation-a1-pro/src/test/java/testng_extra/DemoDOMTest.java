package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoDOMTest {
	@Test(enabled = false)
	public void createCity() {
		System.out.println("NOIDA");
	}
	
	@Test
	public void modifyCity() {
		Assert.assertTrue(false);
		System.out.println("NOIDA to GREATER NOIDA");
	}
	
	@Test(dependsOnMethods = "modifyCity", alwaysRun = true)
	public void deleteCity() {
		System.out.println("GREATER NOIDA DELETED");
	}
	
	
}
