package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.commonMethods;

public class registerPage {

	
	WebDriver driver;
	
	@FindBy(id="firstname")
	WebElement FirstName;
	@FindBy(id="lastname")
	WebElement LastName;
	@FindBy(id="Email")
	WebElement Email;
	@FindBy(id="password")
	WebElement Password;
	@FindBy(id="EMAIL_REG_FORM_SUBMIT")
	WebElement RegisterBtn;
	@FindBy(xpath="//span[@id='gh-ug-flex']/a")
	WebElement RegisterLink;
	
	public registerPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean enterUN(String un){
		return commonMethods.sendKeys(FirstName, un);
	}
	
	public boolean enterLN(String ls){
		return commonMethods.sendKeys(LastName, ls);
	}
	
	public boolean enterEmail(String email){
		return commonMethods.sendKeys(Email, email);
	}
	
	public boolean enterPW(String pw){
		return commonMethods.sendKeys(Password, pw);
	}
	
	public boolean verifyRegisterBtnisEnbaled(){
		return commonMethods.verifyElementisEnabled(RegisterBtn);
		
		
	}
	public boolean clickRegister(){
		return commonMethods.click(RegisterLink);
	}
	
	
}
