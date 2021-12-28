package utilities;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import tests.BaseTest;



public class commonMethods extends BaseTest {
	
	//public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;
	
	static int  Max_Limit=20;
	
	public static void waitforanElementclickable(WebElement element){
		wait=new WebDriverWait(getDriver(),Max_Limit );
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitforanVisibility(WebElement element){
		wait=new WebDriverWait(getDriver(),Max_Limit );
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static  boolean click(WebElement element){
		boolean status=false;
		try {
			waitforanElementclickable(element);
			element.click();
			status=true;
		}catch (Exception e) {
			e.getMessage();
			Assert.assertEquals(status, true, "click method is failed ");
		}
		return status;
		
	}
	
	public static String getText(WebElement element){
		String text=null;
		boolean status=false;
		try {
			waitforanVisibility(element);
			text=element.getText().trim();
			
		}catch (Exception e) {
			e.getMessage();
			Assert.assertEquals(status, true, "getText method is failed ");
		}
		return text;
		
		
	}
	
	public static  boolean sendKeys(WebElement element,String value){
		boolean status=false;
		try {
			waitforanVisibility(element);
			element.sendKeys(value);
			status=true;
		}catch (Exception e) {
			e.getMessage();
			Assert.assertEquals(status, true, "SendKeys method is failed ");
		}
		return status;
		
	}
	
	public static boolean isElementDisplayed(WebElement element){
		boolean status=false;
		try {
			waitforanVisibility(element);
			element.isDisplayed();
			status=true;
		}catch (Exception e) {
			e.getMessage();
			Assert.assertEquals(status, true, "isElementDisplayed method is failed ");
		}
		return status;
		
	}
	
	public static void checkPageIsReady() {
		try {
			for(int i=0;i<15;i++) {
				if(((JavascriptExecutor)getDriver()).executeScript("return document.readyState").equals("complete"))
					break;
			}
		}catch(Exception e) {
			
		}
	}
	
	public static boolean mouseHover(WebElement element) {
		boolean status=false;
		try {
			actions = new Actions(getDriver());
			actions.moveToElement(element).perform();
			status=true;
		} catch (Exception e) {
			e.getMessage();
			Assert.assertEquals(status, true, "mouseHover method is failed ");
		}
		return status;
	}
	
	public static boolean selectByVisibleText(WebElement element,String value) {
		boolean status=false;
		try {
			select = new Select(element);
			select.selectByVisibleText(value);
			status=true;
		} catch (Exception e) {
			e.getMessage();
			Assert.assertEquals(status, true, "selectByVisibleText method is failed ");
		}
		return status;
	}
	
	public static boolean verifyElementisEnabled(WebElement element){
		boolean status=false;
		try {
			element.isEnabled();
			status=true;
		}
		catch (Exception e) {
			e.getMessage();
			Assert.assertEquals(status, true, "verifyElementisEnabled method is failed ");
		}
		return status;
	}
	
	public static void pause(int timeunitSeconds) {
		try {
			Thread.sleep(1000*timeunitSeconds);
		}catch(Exception e) {
			
		}
		
	}

	public static String getCurrentWindow() {
		return getDriver().getWindowHandle();
	}
	
	public static boolean switchToNextTab() {
		boolean status=false;
		try {
		String subWindowHandler=null;
		Set<String> handles=getDriver().getWindowHandles();
		Iterator<String>iterator=handles.iterator();
		while(iterator.hasNext()) {
			subWindowHandler=iterator.next();
		}
		getDriver().switchTo().window(subWindowHandler);
		status=true;
		}catch (Exception e) {
			e.getMessage();
			Assert.assertEquals(status, true, "Switch to next tab method is failed ");
		}
		return status;
	}
	
	public static boolean switchParentTab(String tabName) {
		boolean status=false;
		try {
		getDriver().switchTo().window(tabName);
		status=true;
	}catch (Exception e) {
		Assert.assertEquals(status, true, "Switch to Parent Window method is failed ");
	}
		return status;
	}
	public static boolean scrollTo(WebElement element) {
		boolean status=false;
		try {
			if(element.isDisplayed()!=true) {
				//JavascriptExecutor executor = (JavascriptExecutor)getDriver();
				((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollToView();", element);
				((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,-300)");
				status=true;
			}
		}
		catch (Exception e) {
			e.getMessage();
			Assert.assertEquals(status, true, "Scroll to Element method is failed ");
		}
		return status;
	}
	
	//To take Screenshot 
	
	public static String getBase64Image() {
		return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}