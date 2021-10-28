package com.companyname.appname.basetest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.companyname.appname.util.TakeScreenShot;
import com.companyname.appname.util.TestUtil;
import com.companyname.appname.util.Xls_Reader;

public class BaseTest {

public Xls_Reader xl = new Xls_Reader("./Testdata/TestData.xlsx");	
public Logger applog = Logger.getLogger("devpinoyLogger");
public WebDriver driver;
	

public TakeScreenShot sc = new TakeScreenShot();
	
	@BeforeMethod
	public void launchBrowser() {
		applog.debug("Launch Browser");
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser() {
		applog.debug("Close Browser");
		driver.close();
	}
	
	@DataProvider
	public Object[][] getLoginData(){
		return TestUtil.getData("LoginTest", xl);
	
	}
	
	@DataProvider
	public Object[][] getFbData(){
		return TestUtil.getData("FbData", xl);
	
	}
	
	@DataProvider
	public Object[][] getRegData(){
		return TestUtil.getData("RegisterTest", xl);
	
	}
	
	
	@DataProvider
	public Object[][] getBmiMaleData(){
		return TestUtil.getData("BmiCalculatorMale", xl);
	
	}
	
	@DataProvider
	public Object[][] getBmiFemaleData(){
		return TestUtil.getData("BmiCalculatorFemale", xl);
	
	}
	
	@DataProvider
	public Object[][] getCalorieMaleData(){
		return TestUtil.getData("CalorieMale", xl);
	
	}
	
	@DataProvider
	public Object[][] getCalorieFemaleData(){
		return TestUtil.getData("CalorieFemale", xl);
	
	}
	
}
