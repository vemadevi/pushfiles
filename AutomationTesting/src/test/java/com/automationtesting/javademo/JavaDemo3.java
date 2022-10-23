package com.automationtesting.javademo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
	
	ArrayList<Object> fuits=new ArrayList<Object>();
	fuits.add("apple");
	fuits.add("banana");
	fuits.add("KIWI");
	fuits.add(120);
	fuits.add('a');
	fuits.add('b');
	
	System.out.println(fuits);
	
	HashSet<Object> vegs=new HashSet<Object>();
	
	vegs.add("apple");
	vegs.add("banana");
	vegs.add("KIWI");
	vegs.add('a');
	vegs.add("p");
	vegs.add(102);
	System.out.println(vegs);
	}
	}