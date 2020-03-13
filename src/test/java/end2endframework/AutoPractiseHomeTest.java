package end2endframework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepository.AutoPractiseHome;

import resources.BaseUtility;

public class AutoPractiseHomeTest extends BaseUtility {

		
	public static Logger log= LogManager.getLogger(AutoPractiseHomeTest.class.getName());
	
   @BeforeTest
	public void initialize() throws IOException
	{
		log.info("----------Initializing driver-------------");
		try {
		driver = initializeDriver();
		}
		catch (Exception e)
		{
			log.error("Initializing Driver Failed due to exception - "+ e);
			
			//stacktrace debug 
		}
		
	}
		
	@Test
	public void openAutomationHomePage() throws IOException
	{
		
		driver.get(prop.getProperty("url"));

		//AutoPractiseHome hpo= new AutoPractiseHome(driver);
		//hpo.signin().click();
		Assert.assertEquals(driver.getTitle(), "My Store");
					
	}
	@AfterTest
	public void teardown()
	{
		log.info("----------Closing browser-------------");
		driver.close();
		
	}
	
}
