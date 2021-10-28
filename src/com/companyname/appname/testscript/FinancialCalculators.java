package com.companyname.appname.testscript;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.companyname.appname.basetest.BaseTest;
import com.companyname.appname.util.Env;

public class FinancialCalculators extends BaseTest{
	

	@Test(dataProvider = "getBmiMaleData",priority=1)
	public void doBmiMaleTest(Hashtable<String, String> mmiMaleData) throws InterruptedException, IOException {

		//applog.debug("doLoginTest " + login.get("UserName") + " " + login.get("Password"));
		driver.get(Env.propFile("url_fncal"));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Fitness & Health')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'BMI Calculator')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='cage']")).clear();
		driver.findElement(By.xpath("//input[@id='cage']")).sendKeys(mmiMaleData.get("Age"));
		
		driver.findElement(By.xpath("//input[@type='radio' and @value='m']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='cheightmeter']")).clear();
		driver.findElement(By.xpath("//input[@id='cheightmeter']")).sendKeys(mmiMaleData.get("Height"));
		driver.findElement(By.xpath("//input[@id='ckg']")).clear();
		driver.findElement(By.xpath("//input[@id='ckg']")).sendKeys(mmiMaleData.get("Weight"));
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[2]")).click();
		Thread.sleep(9000);
		String data=driver.findElement(By.xpath("//body/div[@id='contentout']/div[@id='content']/div[4]/div[1]/b[1]")).getText();
		Thread.sleep(5000);
		System.out.println(data);
		if(data != null){
			applog.debug("Result Pass:-"+data);
			sc.takeScreen(driver, "BmiMaleTest");
		}else{
			applog.debug("Result Fail:-"+data);
		}

	}
	
	@Test(dataProvider = "getBmiFemaleData",priority=2)
	public void doBmiFemaleTest(Hashtable<String, String> bmiFemaleTest) throws InterruptedException, IOException {

		//applog.debug("doLoginTest " + login.get("UserName") + " " + login.get("Password"));
		driver.get(Env.propFile("url_fncal"));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Fitness & Health')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'BMI Calculator')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='cage']")).clear();
		driver.findElement(By.xpath("//input[@id='cage']")).sendKeys(bmiFemaleTest.get("Age"));
		
		driver.findElement(By.xpath("//input[@type='radio' and @value='f']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='cheightmeter']")).clear();
		driver.findElement(By.xpath("//input[@id='cheightmeter']")).sendKeys(bmiFemaleTest.get("Height"));
		driver.findElement(By.xpath("//input[@id='ckg']")).clear();
		driver.findElement(By.xpath("//input[@id='ckg']")).sendKeys(bmiFemaleTest.get("Weight"));
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[2]")).click();
		Thread.sleep(9000);
		String data=driver.findElement(By.xpath("//body/div[@id='contentout']/div[@id='content']/div[4]/div[1]/b[1]")).getText();
		Thread.sleep(5000);
		System.out.println(data);
		if(data != null){
			applog.debug("Result Pass:-"+data);
			sc.takeScreen(driver, "BmiFemaleTest");
		}else{
			applog.debug("Result Fail:-"+data);
		}
	}
	

}
