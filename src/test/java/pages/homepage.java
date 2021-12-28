package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.commonMethods;

public class homepage {
	
	
	  WebDriver driver;
	
	 @FindBy(xpath="//a[@aria-label='Your shopping cart']")
	 WebElement shoppingCartIcon;
	 @FindBy(linkText="My eBay")
	 WebElement MyEbay;
	 @FindBy(xpath="//ul[@id='gh-ul-nav']/li")
	 List<WebElement> MyEbayTags;
	 @FindBy(css="input[type='text'][id='gh-ac']")
	 WebElement productSearchTxtBox;
	 @FindBy(css="input[type='submit'][id='gh-btn']")
	 WebElement searchBtn;
	 @FindBy(xpath="//button[@type='button'][@title='Close tooltip']")
	 WebElement closeBtn;
	 @FindBy(xpath="//h3[@class='s-item__title']")
	 WebElement SearchedProductName;
	 public WebElement productSearch(String value)
	    {
		 String xpath="//h3[text()='"+value+"']";
	    return driver.findElement(By.xpath(xpath));
	    }
	
	
	public homepage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean verifyShoppingCartDisplayed(){
			commonMethods.checkPageIsReady();
			return commonMethods.isElementDisplayed(shoppingCartIcon);
		
	}
	
	public List<String> verifyMyEBayOptions(){
		List<String>MyEbayList=new ArrayList<String>();
		commonMethods.checkPageIsReady();
		commonMethods.mouseHover(MyEbay);
		for (WebElement element : MyEbayTags) {
			String text = element.getText();
			System.out.println(text);
			MyEbayList.add(text);
		}
		return MyEbayList;
	}
	
	public void performProductSearch(String product) {
		commonMethods.checkPageIsReady();
		commonMethods.sendKeys(productSearchTxtBox, product);
		commonMethods.click(searchBtn);
		commonMethods.waitforanElementclickable(productSearch(product));
		commonMethods.click(closeBtn);
		commonMethods.click(productSearch(product));
	}
	
	public String getSearchedProductName() {
		return commonMethods.getText(SearchedProductName);
	}
	
}
