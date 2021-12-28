package tests;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import listeners.TestListener;
import pages.homepage;


public class HomePageTest extends BaseTest {
	
	public homepage home;
	
	@BeforeMethod(alwaysRun = true)
	public void HomePageTestLoad() {
		home=new homepage(BaseTest.getDriver());
	}
	
	@Test
	public void validatecartIcon(Method method){
		
		
		TestListener.extentTest.get().log(Status.INFO, "Validating display of Cart icon");
         boolean actual=home.verifyShoppingCartDisplayed();
         Assert.assertEquals(actual, true);
        
			}
	
	
	@Test
	public void validateMyEbayOptionList(Method method){
		
		TestListener.extentTest.get().log(Status.INFO, "My Ebay Options lists are :");
		List<String>actualOptions=home.verifyMyEBayOptions();
		System.out.println("Actual Options :"+actualOptions);
		String str=prop.getPropertyValue("MyEbayOptions");
		   String []exp=str.split(",");
		   ArrayList<String> strList = new ArrayList<String>(
		            Arrays.asList(exp));
		   System.out.println("Expected Option is "+strList);
		   TestListener.extentTest.get().log(Status.INFO, "Displayed EBay option list is :"+strList);
			   //actualOptions.equals(strList);
			  actualOptions.contains(prop.getPropertyValue("MyEbayOptions"));
		
	}
	
	@AfterMethod
	public void teardown(){
		getDriver().quit();
	}
}
