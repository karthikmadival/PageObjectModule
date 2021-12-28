package tests;



import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;

import listeners.TestListener;
import pages.homepage;
import pages.registerPage;

import utilities.commonMethods;

public class NewRegisterTestCase extends BaseTest {

	
	public registerPage regPage;
	public homepage home;
	@BeforeMethod(alwaysRun = true)
	public void PageTestLoad() {
		home=new homepage(BaseTest.getDriver());
		regPage=new registerPage(BaseTest.getDriver());
	}
	
	@Test
	public void VerifyRegisterUserButton(Method method){
		
		commonMethods.checkPageIsReady();
		TestListener.extentTest.get().log(Status.INFO, "Enter User Details");
		regPage.clickRegister();
		//ExtentTestManager.test.log(Status.INFO, "Clicked on Register Link", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		commonMethods.checkPageIsReady();
		regPage.enterUN("test");
		regPage.enterLN("TestOne");
		regPage.enterPW("Boity@$12345");
		regPage.enterEmail("Test@gmail.com");
		boolean actualstatus=regPage.verifyRegisterBtnisEnbaled();
		Assert.assertEquals(actualstatus, true);
		
	}
	
	@AfterMethod
	public void teardown(){
		getDriver().quit();
		
	}
	
}
