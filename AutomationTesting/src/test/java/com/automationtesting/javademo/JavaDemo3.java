package com.automationtesting.javademo;

import java.util.HashMap;

public class JavaDemo3 {
	public static void main(String[] args) {
		HashMap<Integer,String > emplist=new HashMap<Integer, String>();
		emplist.put(101,"syam");
		emplist.put(102,"siva");
		emplist.put(103,"satya");
		emplist.put(104,"sundar");
	System.out.println(emplist.get(102));	
	
	

   HashMap<String,String>credentials=new HashMap<String, String>();
   credentials.put("username", "Admin");
   credentials.put("password", "admin123");
   credentials.put("url", "OrangeHrm");
	
	System.out.println(credentials.get("username"));
	
	
	}
	}