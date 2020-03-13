package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoPractiseHome {

	public WebDriver driver;
	
	public AutoPractiseHome(WebDriver driver) {
		this.driver=driver;
	}
	
	private By signin= By.xpath("//*[@class='header_user_info']//a[contains(text(),'Sign in')]");
	private By searchbox =By.id("search_query_top");
	private By Navbar= By.cssSelector("div[role='navigation']");
	private By submitSearch =By.name("submit_search")  ;
	private By successmessage =By.xpath("//*[@id='layer_cart']//div[span[@title='Close window']]/h2");
	private By  continueshopping=By.cssSelector("[title='Continue shopping']");
	private By  CheckoutButton=By.xpath("//*[@class='button-container']//a[contains(@title,'Proceed')]");
	  
	   
	   
	 public WebElement signin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement searchbox()
	{
		return driver.findElement(searchbox);
	}
	
	public WebElement submitSearch()
	   {
		System.out.println("submitSearch");
		   return driver.findElement(submitSearch);
	   }
	
	
	   public WebElement successmessage()
	   {
		   System.out.println("successmessage");
		   return driver.findElement(successmessage);
	   }
	   public WebElement continueshopping()
	   {
		   return driver.findElement(continueshopping);
	   }
		   
	   public WebElement CheckoutButton()
	   {
		   System.out.println("Checkoutbutton");
		   return driver.findElement(CheckoutButton);
		  
	   }
}
