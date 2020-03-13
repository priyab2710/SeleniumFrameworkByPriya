package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInPageObjects {


	public WebDriver driver;
	
	   public LoggedInPageObjects(WebDriver driver) {

		     this.driver=driver;
		     PageFactory.initElements(driver,this);
		}
		   
	   @FindBy(xpath="//a[contains(text(),'Sign out')]")
	   WebElement SignOut;
	  
	   @FindBy(css="[title='Continue shopping']")
	   WebElement continueshopping;
	   
	   @FindBy(css="[title='Proceed to checkout']")
	   WebElement CheckoutButton;
	   
	  // @FindBy(xpath="//*[@class='clearfix']/div[@class='layer_cart_product col-xs-12 col-md-6']/h2")
	   
	  
	   
	   public WebElement SignOut()
	   {
		   return SignOut;
	   }
	   
	 
	   
	  
		  
}
