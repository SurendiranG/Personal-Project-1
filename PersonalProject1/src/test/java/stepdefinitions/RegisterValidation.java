package stepdefinitions;


import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import drivers.DriversFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.AccountSuccessPage;
import pagefactory.HomePage;
import pagefactory.RegisterPage;
import utils.CommonUtils;

public class RegisterValidation {
       WebDriver driver;
       
     private  RegisterPage registerPage;
     private AccountSuccessPage accountSuccessPage;
     private CommonUtils commonUtils;
    
     
	@Given("User navigates to Register page")
	public void user_navigates_to_register_page() {
		
		
		driver = DriversFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();
	    
	}

	@When("User enters the details in the below fields")
	public void user_enters_the_details_in_the_below_fields(DataTable dataTable) {
		Map<String,String>dataMap = dataTable.asMap(String.class, String.class);	
		
		commonUtils = new CommonUtils();
		
		   registerPage.enterFirstName(dataMap.get("firstName"));
		   registerPage.enterLastName(dataMap.get("lastName"));
		   registerPage.enterEmail(commonUtils.getEmailWithTimeStamp());
	       registerPage.enterTelePhoneNumber(dataMap.get("telephone"));
	       registerPage.enterPassword(dataMap.get("password"));
	       registerPage.enterPasswordForConfirm(dataMap.get("password"));
	       
	}

	@And("User checks the privacy policy")
	public void user_checks_the_privacy_policy() {
		   registerPage.checkPrivacyPolicy();
		   driver.findElement(By.name("agree")).click(); 
	}

	@And("User clicks the continue button")
	public void user_clicks_the_continue_button() {
		  
		accountSuccessPage =   registerPage.selectContinueButton();
		
	}

	@Then("User should created the account successfully")
	public void user_should_created_the_account_successfully() {
		
		Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.getPageHeading());
	}

	@And("User selects the Newsletter")
	
	public void user_selects_the_newsletter() {
		
		
		registerPage.selectNewsLetter();
		
	}

	@When("User enters the details in the below fields with duplicate email")
	public void user_enters_the_details_in_the_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String,String>dataMap = dataTable.asMap(String.class, String.class);
		
		   registerPage.enterFirstName(dataMap.get("firstName"));
		   registerPage.enterLastName(dataMap.get("lastName"));
		   registerPage.enterEmail(dataMap.get("email"));
	       registerPage.enterTelePhoneNumber(dataMap.get("telephone"));
	       registerPage.enterPassword(dataMap.get("password"));
	       registerPage.enterPasswordForConfirm(dataMap.get("password"));
	}


	@Then("User should get a error message about duplicate email")
	public void user_should_get_a_error_message_about_duplicate_email() {
		Assert.assertTrue(registerPage.getWarningMessage().contains(" Warning: E-Mail Address is already registered!"));
		
	}
	

	@When("User don't enter any details into the fields")
	public void user_don_t_enter_any_details_into_the_fields() {
		   registerPage.enterFirstName("");
		   registerPage.enterLastName("");
		   registerPage.enterEmail("");
	       registerPage.enterTelePhoneNumber("");
	       registerPage.enterPassword("");
	       registerPage.enterPasswordForConfirm("");
	}

	@Then("User should get a error messages for every mandatory field")
	public void user_should_get_a_error_messages_for_every_mandatory_field() {
		   Assert.assertTrue(registerPage.getWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
	       Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.firstNameWarningMessage());
	       Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.lastNameWarningMessage());
	       Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.emailWarningMessage());
	       Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.telePhoneWarningMessage());
	       Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.passwordWarningMessage());

	}
	
       
}
