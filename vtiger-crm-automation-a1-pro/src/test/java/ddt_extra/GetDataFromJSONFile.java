package ddt_extra;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetDataFromJSONFile {
	public static void main(String[] args) throws IOException, ParseException {
//		step 1> create the java rep object of the physical file
//		./src/test/resources/commondata.json
		FileReader fr = new FileReader("./src/test/resources/commondata.json");
	
//		step 2> parse it to Java Object
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		
//		step 3> downcast it to JSONObject
		JSONObject jObj = (JSONObject) obj;
		
//		Step 4> by using get() and passing key, get the value and convert to string
		String browser = jObj.get("bro").toString();
		String url = jObj.get("url").toString();
		String username = jObj.get("un").toString();
		String password = jObj.get("pwd").toString();
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		
		
		
		
		
		
		
	}
}
