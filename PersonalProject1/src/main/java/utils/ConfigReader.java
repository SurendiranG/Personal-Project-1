package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
     
	public Properties initializeProperties() {
		
		Properties prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+ "/src/main/resources/configurations/config.properties");
		
		try{
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
}
