package com.companyname.appname.testscript;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.companyname.appname.basetest.BaseTest;
import com.companyname.appname.util.Env;

public class RegTest extends BaseTest{
	
	@Test(dataProvider = "getRegData")
	public void doRegTest(Hashtable <String,String> reg) throws InterruptedException, IOException {
		applog.debug("doRegTest");
		
		driver.get(Env.propFile("url_reg"));
		String title = driver.getTitle();
		applog.debug("title = " + title);
		String curl = driver.getCurrentUrl();
		applog.debug("current url =" + curl);
		Thread.sleep(4000);

		String register = driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).getText();
		applog.debug("Register =" + register);
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(reg.get("FirstName"));
		String fname = driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value");
		applog.debug("fname = " + fname);

		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(reg.get("LastName"));
		String lname = driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value");
		applog.debug("lname = " + lname);

		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(reg.get("Phone"));
		String phone = driver.findElement(By.xpath("//input[@name='phone']")).getAttribute("value");
		applog.debug("phone = " + phone);

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(reg.get("UserName"));
		String uname = driver.findElement(By.xpath("//input[@id='userName']")).getAttribute("value");
		applog.debug("Uname = " + uname);

		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(reg.get("Address"));
		String address1 = driver.findElement(By.xpath("//input[@name='address1']")).getAttribute("value");
		applog.debug("Address = " + address1);

		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(reg.get("City"));
		String city = driver.findElement(By.xpath("//input[@name='city']")).getAttribute("value");
		applog.debug("City = " + city);

		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(reg.get("State"));
		String state = driver.findElement(By.xpath("//input[@name='state']")).getAttribute("value");
		applog.debug("State = " + state);

		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(reg.get("PostalCode"));
		String postcode = driver.findElement(By.xpath("//input[@name='postalCode']")).getAttribute("value");
		applog.debug("postcode = " + postcode);

		WebElement element = driver.findElement(By.xpath("//select[@name='country']")); //"//select[@name='country']/option[3] "
		Select select = new Select(element);
		select.selectByIndex(2);
		String country = element.getAttribute("value");   //how to write this
		applog.debug("country = " + country);
		
		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(reg.get("Email"));
		String email = driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value");
		applog.debug("email = " + email);

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(reg.get("Password"));
		String paswrd = driver.findElement(By.xpath("//input[@name='password']")).getAttribute("value");
		applog.debug("paswrd = " + paswrd);

		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(reg.get("ConfirmPassword"));
		String cpaswrd = driver.findElement(By.xpath("//input[@name='confirmPassword']")).getAttribute("value");
		applog.debug("cpaswrd = " + cpaswrd);

		String submit = driver.findElement(By.xpath("//input[@name='submit']")).getAttribute("name");
		applog.debug("submit = " + submit);
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		Thread.sleep(10000);
		String regmsg = driver.findElement(By.xpath("//font[contains(text(),'Thank you for registering.')]")).getText();
		if (regmsg.contains("Thank you for registering")) {
			applog.debug("Result Pass");
			sc.takeScreen(driver, "Register");
		} else {
			applog.debug("Result Fail");
		}
	}


}
