package stepdefinitions;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import drivers.DriversFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.HomePage;
import pagefactory.SearchResultsPage;

public class SearchValidation {
       WebDriver driver;
     private  HomePage homePage;
     private  SearchResultsPage searchResultsPage;
    
       
	@Given("User navigates to Homepage of the application")
	public void user_navigates_to_homepage_of_the_application() {
		
		driver = DriversFactory.getDriver();
	}

	@When("User enters the valid product name {string} into the search box field")
	public void user_enters_the_valid_product_name_into_the_search_box_field(String validProductText) {
	    homePage = new HomePage(driver);
		homePage.enterProduct(validProductText);
		
	}

	@And("User clicks on Search button")
	public void user_clicks_on_search_button() {
		
		searchResultsPage = homePage.clickOnSearchButton();
		
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
		Assert.assertTrue(searchResultsPage.displayValidProduct());
	}

	@When("User enters the invalid product name {string} into the search box field")
	public void user_enters_the_invalid_product_name_into_the_search_box_field(String invalidProductText) {
		
		homePage = new HomePage(driver);
		homePage.enterProduct(invalidProductText);
	   
	}

	@Then("User should get an error message")
	public void user_should_get_an_error_message() {
		
		Assert.assertEquals("There is no product that matches the search criteria.",searchResultsPage.getMessageText());
	}

	@When("User don't enter any product in search box field")
	public void user_don_t_enter_any_product_in_search_box_field() {
		homePage = new HomePage(driver);
	}
}
