package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
//		step 1> create the java rep object of the physical file
//		./src/test/resources/commondata.properties
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		
//		step 2> by using load(), load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		step 3> by using getProperty() and passing the key, get the value
		String browser = pObj.getProperty("bro");
		System.out.println(browser);
	}
}
