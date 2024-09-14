package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;

public class LoginSteps {
	
	WebDriver driver;
	
	LoginPage loginPage;
	
	MyAccountsPage myAccountsPage;
	
	@Given("the user navigates to login page")
	public void navigates_to_login_page() {
		
		BaseClass.getLogger().info("Login page launched");
		System.out.println("Application Launched, Driver Initialized");
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_and_password(String user, String pwd) {
		
		loginPage=new LoginPage(BaseClass.getDriver());
		loginPage.setUserName(user);
		loginPage.setPassword(pwd);
	    
	}

	@When("user clicks on the submit button")
	public void user_clicks_on_the_submit_button() {
		
		loginPage.clickSubmitButton();
	    
	}

	@Then("the user should be redirected to MyAccount page")
	public void validate_my_account_page() {
		
		
		  myAccountsPage=new MyAccountsPage(BaseClass.getDriver());
		  
		  boolean targetPage=myAccountsPage.isMyAccountPageExists();
		  
		  Assert.assertEquals(targetPage, true);
		 
		
		System.out.println("My Accounts page is displayed");
		
		
	}

}
