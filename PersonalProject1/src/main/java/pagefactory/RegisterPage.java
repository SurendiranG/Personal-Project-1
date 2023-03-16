package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy (id="input-firstname")
	private WebElement lastNameField;
	
	@FindBy (id="input-email")
	private WebElement emailField;
	
	@FindBy (id="input-telephone")
	private WebElement telePhoneField;
	
	@FindBy (id="input-password")
	private WebElement passwordField;
	
	@FindBy (id="input-confirm")
	private WebElement confrimPasswordField;
	
	@FindBy (name="agree")
	private WebElement privacyPolicy;
	
	@FindBy (xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy (xpath="//input[@name='newsletter'][@value='1']") 
	private WebElement radioButton;
	
	@FindBy (xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy (xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy (xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy (xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy (xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telePhoneWarning;
	
	@FindBy (xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);	
	}
	
	public void enterTelePhoneNumber(String telePhoneText) {
		telePhoneField.sendKeys(telePhoneText);		
	}
	
	public void enterPassword(String passWordText) {
		passwordField.sendKeys(passWordText);
	}
	
	public void enterPasswordForConfirm(String reEnterPassword) {
		confrimPasswordField.sendKeys(reEnterPassword);
	}
	
	public void checkPrivacyPolicy() {
		privacyPolicy.click();
	}
	
    public AccountSuccessPage selectContinueButton() {
    	continueButton.click();
    	return new AccountSuccessPage(driver);
    }
    
    public void selectNewsLetter() {
    	radioButton.click();
    }
    
    public String getWarningMessage() {
    	return warningMessage.getText();	
    }
    
    public String firstNameWarningMessage() {
    	return firstNameWarning.getText();
    }
    
    public String lastNameWarningMessage() {
    	return lastNameWarning.getText();
    }
    
    public String emailWarningMessage() {
    	return emailWarning.getText();
    }
    
    public String telePhoneWarningMessage() {
    	return telePhoneWarning.getText();
    }
    
    public String passwordWarningMessage() {
    	return passwordWarning.getText();
    }
    
}
