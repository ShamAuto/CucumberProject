package com.companyname.appname.testscript;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.companyname.appname.basetest.BaseTest;
import com.companyname.appname.util.Env;

public class FinancialCalculators2 extends BaseTest{
	

	@Test(dataProvider = "getCalorieMaleData",priority=1)
	public void doCaloriesMaleTest(Hashtable<String, String> caloriesMaleData) throws InterruptedException, IOException {

		driver.get(Env.propFile("url_fncal"));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Fitness & Health')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Calorie Calculator')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='cage']")).clear();
		driver.findElement(By.xpath("//input[@id='cage']")).sendKeys(caloriesMaleData.get("Age"));
		
		driver.findElement(By.xpath("//input[@type='radio' and @value='m']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='cheightmeter']")).clear();
		driver.findElement(By.xpath("//input[@id='cheightmeter']")).sendKeys(caloriesMaleData.get("Height"));
		driver.findElement(By.xpath("//input[@id='ckg']")).clear();
		driver.findElement(By.xpath("//input[@id='ckg']")).sendKeys(caloriesMaleData.get("Weight"));
		new Select(driver.findElement(By.xpath("//select[@id='cactivity']"))).selectByVisibleText(caloriesMaleData.get("Activity"));
		driver.findElement(By.xpath("//input[@value='Calculate']")).click();
		Thread.sleep(9000);
		String data=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]")).getText();
		Thread.sleep(5000);
		System.out.println(data);
		if(data != null){
			applog.debug("Result Pass:-"+data);
			sc.takeScreen(driver, "CaloriesMaleTest");
		}else{
			applog.debug("Result Fail:-"+data);
		}
	}
	
	@Test(dataProvider = "getCalorieFemaleData",priority=2)
	public void doCaloriesFemaleTest(Hashtable<String, String> caloriesFemaleTest) throws InterruptedException, IOException {

		//applog.debug("doLoginTest " + login.get("UserName") + " " + login.get("Password"));
		driver.get(Env.propFile("url_fncal"));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Fitness & Health')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Calorie Calculator')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='cage']")).clear();
		driver.findElement(By.xpath("//input[@id='cage']")).sendKeys(caloriesFemaleTest.get("Age"));
		
		driver.findElement(By.xpath("//input[@type='radio' and @value='f']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='cheightmeter']")).clear();
		driver.findElement(By.xpath("//input[@id='cheightmeter']")).sendKeys(caloriesFemaleTest.get("Height"));
		driver.findElement(By.xpath("//input[@id='ckg']")).clear();
		driver.findElement(By.xpath("//input[@id='ckg']")).sendKeys(caloriesFemaleTest.get("Weight"));
		new Select(driver.findElement(By.xpath("//select[@id='cactivity']"))).selectByVisibleText(caloriesFemaleTest.get("Activity"));
		driver.findElement(By.xpath("//input[@value='Calculate']")).click();
		Thread.sleep(9000);
		String data=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]")).getText();
		Thread.sleep(5000);
		System.out.println(data);
		if(data != null){
			applog.debug("Result Pass:-"+data);
			sc.takeScreen(driver, "CaloriesFemaleTest");
		}else{
			applog.debug("Result Fail:-"+data);
		}
	}
	

}
