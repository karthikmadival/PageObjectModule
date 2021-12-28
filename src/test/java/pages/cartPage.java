package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.commonMethods;

public class cartPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//select[@name='Capacity']")
	WebElement phoneCapacity;
	@FindBy(xpath="//select[@name='Phone Color']")
	WebElement phoneColor;
	@FindBy(xpath="//a[@id='binBtn_btn']")
	WebElement BuyItNowBtn;
	@FindBy(xpath="//button[@id='sbin-signin-btn']")
	WebElement signInToCheckOutBtn;
	@FindBy(xpath="//a[@id='isCartBtn_btn']")
	WebElement addToCartBtn;
	@FindBy(xpath="//i[@id='gh-cart-n']")
	WebElement cartCount;
	@FindBy(xpath="//button[text()='Go to checkout']")
	WebElement checkOutBtn;
	@FindBy(xpath="//h3[@class='item-title truncate-multiline lines-2 black-link']")
	WebElement productDetails;
	
	
	public cartPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void chooseMobileConfig(String capacity,String color) {
		commonMethods.checkPageIsReady();
		commonMethods.selectByVisibleText(phoneCapacity, capacity);
		commonMethods.selectByVisibleText(phoneColor, color);
		
		
	}
	
	public void clickAddToCartButton() {
		commonMethods.scrollTo(addToCartBtn);
		commonMethods.click(addToCartBtn);
	}
	
	public void clickSignInToCheckoutButton() {
		commonMethods.scrollTo(signInToCheckOutBtn);
	}
	public void clickBuyItNowButton() {
		commonMethods.click(BuyItNowBtn);
	}
	
	public String getCartCount() {
		return commonMethods.getText(cartCount);
	}
	public void clickCheckOutButton() {
		commonMethods.click(checkOutBtn);
	}
	public String getProductNameFromCart() {
		return commonMethods.getText(productDetails);
	}

}
