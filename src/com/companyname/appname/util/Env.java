package com.companyname.appname.util;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class Env {
	public static Map<String,String> map=null;
	public static Properties prop=null;
	
	public static Map<String,String> getConfig(){
		
		 prop=new Properties();
		 map=new HashMap<String,String>();
		
		try{
			prop.load(Env.class.getResourceAsStream("./env.properties"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		for(Entry<Object, Object> ent:prop.entrySet())
		{
			//System.out.println(ent.getKey()+"  "+ent.getValue());
			map.put((String) ent.getKey(), (String)ent.getValue());
		}
		
		
		return map;
		
		

		
	}
	
	public static void main(String[] args) {
		
	
		
	}
	
	

	

}
