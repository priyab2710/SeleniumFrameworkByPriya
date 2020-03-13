package pageObjectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoPractiseCheckoutPage {

	public WebDriver driver;
	


	public AutoPractiseCheckoutPage(WebDriver driver) {
		this.driver = driver;
	}


	private By CheckoutSteps = By.cssSelector("#order_step li span");
	private By productTable = By.cssSelector("[id='cart_summary'] thead tr th, class");
	//private By submitSearch = By.name("submit_search");
	private By ProceedCheckout = By.xpath("//*[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']");
	private By termscheckbox = By.xpath("//*[@class='order_carrier_content box']//input[@id='cgv']");
	private By messagebox = By.xpath("//*[@id='ordermsg']/textarea[@name='message']");
	private By processAddress = By.name("processAddress");
	private By processCarrier = By.name("processCarrier");
	private By paymentbankwire = By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a");
	private By confirmOrder = By.xpath("//*[@id='cart_navigation']//button[@type='submit']");
	private By PaymentHeading = By.xpath("//*[@id='center_column']/h1");

	public int CheckoutStepsSize() {
		return driver.findElements(CheckoutSteps).size();
	}
	
	public List<WebElement> CheckoutSteps() {
		return driver.findElements(CheckoutSteps);
	}
	public WebElement ProceedCheckout() {
		return driver.findElement(ProceedCheckout);
	}
	public WebElement PaymentHeading() {
		return driver.findElement(PaymentHeading);
	}
	public WebElement paymentbankwire() {
		return driver.findElement(paymentbankwire);
	}
	
	public WebElement confirmOrder() {
		return driver.findElement(confirmOrder);
	}
	
	public ArrayList<String> productTable() {
		//return driver.findElements(productTable);
		ArrayList<String> productTablelist = new ArrayList<String>();
		int size= driver.findElements(productTable).size();
	    List<WebElement> w= driver.findElements(productTable);
		for(int i=0;i<size;i++)
		{
			productTablelist.add(w.get(i).getText());
		}
		return productTablelist;
	}
	
	public int productTableColumn() {
		return driver.findElements(productTable).size();
	}
	
	
	
	public ArrayList<String> getExpectedTableColumn() {
    ArrayList<String> producttablecolumnsexpected= new ArrayList<String>();
	   
	producttablecolumnsexpected.add("Product");
	producttablecolumnsexpected.add("Description");
	producttablecolumnsexpected.add("Avail.");
	producttablecolumnsexpected.add("Unit price");
	producttablecolumnsexpected.add("Qty");
	producttablecolumnsexpected.add("Total");
	producttablecolumnsexpected.add(" ");
	return producttablecolumnsexpected;
}


	public WebElement processAddress() {
		return driver.findElement(processAddress);
	}
	public WebElement messagebox() {
		return driver.findElement(messagebox);
	}
	public WebElement termscheckbox() {
		return driver.findElement(termscheckbox);
	}
	public WebElement processCarrier() {
		return driver.findElement(processCarrier);
	}
	
}
	 
	
