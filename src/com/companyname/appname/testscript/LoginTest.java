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

public class LoginTest extends BaseTest {

	@Test(dataProvider = "getLoginData")
	public void doLoginTest(Hashtable<String, String> login) throws InterruptedException, IOException {

		applog.debug("doLoginTest " + login.get("UserName") + " " + login.get("Password"));
		driver.get(Env.propFile("url_login"));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='desktop']")).sendKeys(login.get("UserName"));
		driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/form[1]/input[4]")).sendKeys(login.get("Password"));
		driver.findElement(By.xpath("//button[@id='btn_signin']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Send passcode to my mobile phone')]")).click();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter otp");
		BigInteger opt=sc.nextBigInteger();
		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		// Enter username
		//JS.executeScript("document.")
	
		driver.findElement(By.xpath("//input[@name='otp']")).sendKeys();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(5000);

	}

}
