package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoPriorityTest {
	@Test(priority = -1)
	public void createCity() {
		System.out.println("NOIDA");
	}
	
	@Test
	public void modifyCity() {
		Assert.assertTrue(false);
		System.out.println("NOIDA to GREATER NOIDA");
	}
	
	@Test(priority = 1)
	public void deleteCity() {
		System.out.println("GREATER NOIDA DELETED");
	}
	
	
}
