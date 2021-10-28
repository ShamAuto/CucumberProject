package com.companyname.appname.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class TakeScreenShot {
	
	WebDriver driver;
	timestamp t=new timestamp();
	public void takeScreen(WebDriver driver,String sname) throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dstFile = new File(System.getProperty("user.dir") +"//Screenshot//"+sname+"_"+t.TimeStamp());
	    Files.copy(scrFile,dstFile );
	}
	
	
	
}
