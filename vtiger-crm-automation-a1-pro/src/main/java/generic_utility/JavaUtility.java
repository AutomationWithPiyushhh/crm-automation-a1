package generic_utility;

import static org.junit.Assert.assertNotNull;

public class JavaUtility {
	public static int generateRandomNumber() {
		
		double randomDouble = Math.random();
		double ran = randomDouble*1000; 
		int random = (int) ran;
		return random;
		
	}
	
//	need to ask students did they perform or not !!!
	public String getCurrentDateTime() {
//		output :- 135120_20072026
		return null;
	}
}
