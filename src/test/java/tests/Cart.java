package tests;



import java.lang.reflect.Method;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import listeners.TestListener;
import pages.cartPage;
import pages.homepage;

import utilities.commonMethods;

public class Cart extends BaseTest {

	public homepage home;
	public cartPage cartpage;
	
	@BeforeMethod(alwaysRun = true)
	public void HomePageTestLoad() {
		home=new homepage(BaseTest.getDriver());
		cartpage=new cartPage(BaseTest.getDriver());
	}
	
	@Test
	public void addProductToCart(Method method) {
		//ExtentTestManager.test=startTest(method.getName(),"Verify User is able To add Product to the Cart");
	  //TestListener.log(Status.INFO, "User is performing Product Search");
		TestListener.extentTest.get().log(Status.INFO, "User is performing Product Search");
		String currentWindow=commonMethods.getCurrentWindow();
		TestListener.extentTest.get().log(Status.INFO, "User performed product Search and the product is " +prop.getPropertyValue("Iphone_Product"));
		home.performProductSearch(prop.getPropertyValue("Iphone_Product"));
		commonMethods.switchToNextTab();
		cartpage.chooseMobileConfig(prop.getPropertyValue("IphoneCapacity"), prop.getPropertyValue("IphoneColor"));
		TestListener.extentTest.get().log(Status.INFO, "User is about to click Add to Cart button ", MediaEntityBuilder.createScreenCaptureFromBase64String(commonMethods.getBase64Image()).build());
		cartpage.clickAddToCartButton();
		String actual=cartpage.getCartCount();
		TestListener.extentTest.get().log(Status.INFO, "Searched Product added to the Cart and count is  "+actual, MediaEntityBuilder.createScreenCaptureFromBase64String(commonMethods.getBase64Image()).build());
		Assert.assertEquals(actual, prop.getPropertyValue("CartCount"));
		String actualProductName=cartpage.getProductNameFromCart();
		commonMethods.switchParentTab(currentWindow);
		TestListener.extentTest.get().log(Status.INFO, "Comparing Product Name from Cart Page and Product Search Page",MediaEntityBuilder.createScreenCaptureFromBase64String(commonMethods.getBase64Image()).build());
		String expectedProductName=home.getSearchedProductName();
		Assert.assertEquals(actualProductName, expectedProductName);
		
	}
	
	
	@AfterMethod
	public void teardown(){
		getDriver().quit();
		
	}
}
