package com.companyname.appname.testscript;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.companyname.appname.basetest.BaseTest;
import com.companyname.appname.util.Env;

public class FbLogin extends BaseTest {
	
	@Test(dataProvider = "getFbData")
	public void doFbLogin(Hashtable <String,String> fdata) throws InterruptedException, IOException{
		applog.debug("doFbLogin");
		/*System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();*/
		driver.get(Env.map.get("url_facebook "));
		Thread.sleep(4000);
		System.out.println(Env.map.get("url_facebook "));
		driver.findElement(By.xpath("//input[@id='u_0_n']")).sendKeys(fdata.get("FirstName"));
		driver.findElement(By.xpath("//input[@id='u_0_p']")).sendKeys(fdata.get("LastName"));
		driver.findElement(By.xpath("//input[@id='u_0_s']")).sendKeys(fdata.get("Phone"));
		driver.findElement(By.xpath("//input[@id='u_0_v']")).sendKeys(fdata.get("Phone"));
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys(fdata.get("Password"));
	    		
		new Select(driver.findElement(By.xpath("//select[@id='month']"))).selectByVisibleText(fdata.get("Month"));
		new Select(driver.findElement(By.xpath("//select[@id='day']"))).selectByVisibleText(fdata.get("Dates"));
		new Select(driver.findElement(By.xpath("//select[@id='year']"))).selectByVisibleText(fdata.get("Year"));
		sc.takeScreen(driver, "FaceBook");
				
		//driver.findElement(By.xpath("//input[@type='radio' and @name='sex' and @value='-1']")).click();
		
		//new Select(driver.findElement(By.xpath("//select[@name='preferred_pronoun']"))).selectByVisibleText(fdata.get("Pronoun"));
		//driver.findElement(By.xpath("//input[@id='u_0_12']")).sendKeys(fdata.get("Option"));
		Thread.sleep(5000);
		//driver.close();
		
	}

}
