package end2endframework;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.BaseUtility;

public class PlanitConnect extends BaseUtility{

	@BeforeTest
	public void initialize() throws IOException {
		log.info("Initializing driver");
		try {
			driver = initializeDriver();
		} catch (Exception e) {
			log.error("Initializing Driver Failed due to an exception" + e);
		}

	}
	
	@Test
	public void AddSkills()
	{
		driver.get(prop.getProperty("URLPlanit"));
	}
	}