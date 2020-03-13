package stepDefinition;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjectRepository.AutoPractiseHome;
import pageObjectRepository.AutoPractiseLogin;
import resources.BaseUtility;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class MyStepDefinition extends BaseUtility {
	public AutoPractiseLogin lp;
	public AutoPractiseHome hpo;

	@Given("^Initialize the browser$")
	public void initialize_the_browser_with() throws Throwable {
		 driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" website$")
	public void navigate_to_website(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(arg1);
	}

	@Given("^click on login page link$")
	public void click_on_login_page_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 hpo= new AutoPractiseHome(driver);
		hpo.signin().click();
		
	}

	@When("^user enters correct \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_correct_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//System.out.println(driver.getTitle());
			lp= new AutoPractiseLogin(driver);
			lp.email().sendKeys(arg1);
			lp.password().sendKeys(arg2);
				
	}

	@When("^clicks on log in button$")
	public void clicks_on_log_in_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 lp= new AutoPractiseLogin(driver);
		 lp.Submit();
		 
		
	}

	@Then("^verify user is logged in successfully$")
	public void verify_user_is_logged_in_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actualmessage= driver.findElement(By.cssSelector("[class*='alert alert-danger']")).getText();
		//Assert.assertEquals(actualmessage, "Invalid email or password.");
		Assert.assertEquals(actualmessage, "Invalid email or password.");
	}
}

