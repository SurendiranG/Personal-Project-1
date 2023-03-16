package hooks;

 
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import drivers.DriversFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;
	
	
    
	
	@Before
	public void setUp() {
		Properties prop = new ConfigReader().initializeProperties();
	  		 
	 driver = DriversFactory.initializeBrowser(prop.getProperty("browser"));	
	 driver.get(prop.getProperty("url"));
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}
	  
}
