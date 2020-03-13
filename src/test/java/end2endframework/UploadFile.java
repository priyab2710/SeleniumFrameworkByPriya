package end2endframework;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.BaseUtility;

public class UploadFile extends BaseUtility {

	@BeforeTest
	public void initialize() throws IOException {
		
		try {
			driver = initializeDriver();
		} catch (Exception e) {
			System.out.println("Error initializing browser");
		}

	}

	@Test
	public void VerifyLogin() throws SQLException, IOException, InterruptedException {

		        log.debug("Open an URL");
		driver.get(prop.getProperty("urlfileupload"));
		driver.findElement(By.id("pick-files")).click();
		Thread.sleep(2000L);
        Runtime.getRuntime().exec("C:\\Users\\pbhamare\\Documents\\Priya_test\\fileupload.exe");
}
}
