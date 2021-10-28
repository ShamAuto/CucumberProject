package com.companyname.appname.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timestamp {
	
 public String TimeStamp()
 {
	String fileName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	String timeStamp =fileName.substring(0, 4)+"_"+fileName.substring(4,6)+"_"+fileName.substring(6,8)+"_"+fileName.substring(8,10)
	             +"_"+fileName.substring(10,12)+"_"+fileName.substring(12,14)+".png";
	return timeStamp;
}

 
 public static void main(String[] args) {
	
	 timestamp t=new timestamp();
	 System.out.println(t.TimeStamp());
}
 
 
}



