package end2endframework;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepository.AutoPractiseCheckoutPage;
import pageObjectRepository.AutoPractiseHome;
import pageObjectRepository.AutoPractiseLogin;
import pageObjectRepository.LoggedInPageObjects;
import resources.BaseUtility;

public class LoginPageTest extends BaseUtility {
	public resources.MysqlConnect conc;
	public AutoPractiseHome hpo;
	public AutoPractiseLogin lpo;
	public LoggedInPageObjects lip;
	public AutoPractiseCheckoutPage apcp;
	public static Logger log = LogManager.getLogger(BaseUtility.class.getName());

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
	public void VerifyLogin() throws SQLException, IOException, InterruptedException {

		
        log.debug("Open an URL");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

		hpo = new AutoPractiseHome(driver);
		lpo = new AutoPractiseLogin(driver);
		lip = new LoggedInPageObjects(driver);
		hpo.signin().click();
		conc = new resources.MysqlConnect();
		Statement st = conc.databaseconnection1();
		ResultSet rs = st.executeQuery("select * from employeelogin");
		rs.next();
		log.info("Verifying Login");
		lpo.email().sendKeys(rs.getString("Username"));
		lpo.password().sendKeys(rs.getString("password"));
		lpo.Submit().click();
		Assert.assertTrue(lpo.SignOut().isDisplayed(), "Login Successful");
		log.info("Login Successful");
		hpo.searchbox().sendKeys("Printed Dress");
		log.info("Entered text in serachbox");
		hpo.submitSearch().click();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[@class='product-container']"))).build().perform();
		driver.findElement(By.cssSelector("a[title='Add to cart']")).click();
		log.info("Item added to cart");
		if (hpo.successmessage().isDisplayed()) {
			Assert.assertEquals(hpo.successmessage().getText(), "Product successfully added to your shopping cart");
			Assert.assertTrue(hpo.CheckoutButton().isEnabled());
			Assert.assertTrue(hpo.continueshopping().isEnabled());
		}
	   
		log.info("Clicked on checkout button");
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement checkbutton= wait.until(ExpectedConditions.visibilityOf(hpo.CheckoutButton()));
		checkbutton.click();
		
	}

	@Test(dependsOnMethods = "VerifyLogin")
	public void VerifySummaryStep() {
		
		
		Assert.assertEquals(driver.getTitle(), "Order - My Store", "Success");
		apcp = new AutoPractiseCheckoutPage(driver);
		//System.out.println(apcp.CheckoutStepsSize());

		for (int i = 0; i < apcp.CheckoutStepsSize(); i++) {

			Assert.assertTrue(apcp.CheckoutSteps().get(i).isDisplayed());
			if (!(apcp.CheckoutSteps().get(i).getText().contains("Summary"))) {
				Assert.assertFalse(apcp.CheckoutSteps().get(i).isSelected());
			}
		}
		log.info("Checkout steps verfication is successful");
	}

	@Test(dependsOnMethods = "VerifySummaryStep")
	public void VerifyCheckOutPageTableColumns() 
	{
		Assert.assertTrue(apcp.productTable().equals(apcp.getExpectedTableColumn()));
		log.info("Checkout elements verfication is successful");
		apcp.ProceedCheckout().click();
		log.info("Summary step is completed");
	}
	
	@Test(dependsOnMethods = "VerifyCheckOutPageTableColumns")
	public void VerifyAddressblock() throws InterruptedException
	{
		String ordermessage= driver.findElement(By.xpath("//*[@id='ordermsg']/label")).getText();
		apcp.messagebox().sendKeys("Priya Test Message");
		Thread.sleep(4000L);
		Assert.assertEquals(ordermessage, "If you would like to add a comment about your order, please write it in the field below.");
		log.info("Address steps is completed");
							
	}
	
	@Test(dependsOnMethods = "VerifyAddressblock")
	public void Verifyshipping() throws InterruptedException
	{
		apcp.processAddress().click();
	    log.info("Shipping step is started");
		apcp.processCarrier().click();
		 Thread.sleep(2000L);
		driver.findElement(By.xpath("//*[@class='fancybox-skin']/a")).click();
		Thread.sleep(3000L);
		if(!(apcp.termscheckbox().isSelected()))
		apcp.termscheckbox().click();
		Assert.assertTrue(apcp.termscheckbox().isSelected());
		Thread.sleep(4000L);
		apcp.processCarrier().click();
		
		
	}
	@Test(dependsOnMethods = "Verifyshipping")
	public void VerifyPayment() throws InterruptedException
	{
	    
		Assert.assertEquals(apcp.PaymentHeading().getText(), "PLEASE CHOOSE YOUR PAYMENT METHOD");
		apcp.paymentbankwire().click();
		Thread.sleep(2000L);
		apcp.confirmOrder().click();
		log.info("Payment step is completed");
		log.info("Order is placed successfully");
		Thread.sleep(2000L);
	}
	
	@AfterTest
	public void teardown() throws InterruptedException {
		
		driver.close();

	}

}
