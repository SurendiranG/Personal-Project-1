package stepdefinitions;



import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import drivers.DriversFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.AccountPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import utils.CommonUtils;


public class LoginValidation {
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		
		 driver = DriversFactory.getDriver();
		 HomePage homePage = new HomePage(driver);
		 homePage.clickOnMyAccount();
	    loginPage =	 homePage.selectLoginOption();
		
	}

	@When("^User enters the valid mail id (.+) in the email field$")
	public void user_enters_the_valid_mail_id_in_the_email_field(String emailText) {
		 
		 loginPage.enterMailAddress(emailText);
		 
	}

	@And("^User enters the valid password (.+) in the password field$")
	public void user_enters_the_valid_password_in_the_password_field(String passwordText) {
		
		loginPage.enterPassword(passwordText);
		 
	}

	@And("User clicks the login button")
	public void user_clicks_the_login_button() {
		
	    accountPage = loginPage.clickLoginButton();
		 
	}

	@Then("User should successfully logged in")
	public void user_should_successfully_logged_in() {
	
		Assert.assertTrue(accountPage.displayEditYourAccountInformation());
	}

	@When("User enters the invalid mail id in the email field")
	public void user_enters_the_invalid_mail_id_in_the_email_field() {
		 
	    commonUtils = new CommonUtils();
		loginPage.enterMailAddress(commonUtils.getEmailWithTimeStamp());
		
	}

	@And("User enters the invalid password {string} in the password field")
	public void user_enters_the_invalid_password_in_the_password_field(String invalidPasswordText) {
		
		loginPage.enterPassword(invalidPasswordText);
		
	}

	@Then("User should get the error message about credentials mismatch")
	public void user_should_get_the_error_message_about_credentials_mismatch() {
		
		Assert.assertTrue(loginPage.getWarningMessageText().contains(" Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
	}

	@When("User don't enters the login credentials")
	public void user_don_t_enters_the_login_credentials() {
		
		loginPage.enterMailAddress("");
		loginPage.enterPassword("");
		
	   
	}
	
	
	
	
	
	
	
	
	
}

