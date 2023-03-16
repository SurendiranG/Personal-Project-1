package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
   WebDriver driver;
   
   public SearchResultsPage(WebDriver driver) {
	   this.driver =driver;
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy (linkText="iPhone")
   private WebElement validIphoneProduct;
     
   @FindBy (xpath="//input[@id='button-search']/following-sibling::p")
   private WebElement messageText;
   
   
   
   public boolean displayValidProduct() {
	  return validIphoneProduct.isDisplayed();
   }
   
   
   public String getMessageText() {
	  return messageText.getText();
   }
   
   
}
