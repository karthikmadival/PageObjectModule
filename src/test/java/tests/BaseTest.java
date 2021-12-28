package tests;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.GetProperties;

public class BaseTest {

	public  WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	public static ExtentReports extent;
	
	
	public static GetProperties prop;

	@BeforeSuite
	public void setup() {
		
		prop = new GetProperties();
		prop.configFileReader();

	}


	@Parameters("browserName")
	@BeforeMethod(alwaysRun = true)
	public WebDriver launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		getDriver().get(prop.getPropertyValue("url"));
		getDriver().manage().window().maximize();

		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	

	

}
