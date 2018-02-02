package com.tam.m4;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Runner {
	
	public static void main(String args[]) {
		List<String> suitesList = new ArrayList<String>();
		TestNG testng = new TestNG();
		testng.setOutputDirectory("Output-M4");
		suitesList.add("testng.xml");
		testng.setTestSuites(suitesList);
		testng.run(); 
		
	}
	
	
}
