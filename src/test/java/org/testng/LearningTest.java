package org.testng;


import java.io.IOException;
import java.util.Date;

import org.help.BaseClass;
import org.openqa.selenium.WebElement;
import org.pom.POMFramework;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearningTest extends BaseClass{
	
	@BeforeClass	
	private void start() {
		
		LaunchBrowser();
		OpenApp("https://www.facebook.com/");
		MaximaizeWindow();
	}
	
	@BeforeMethod
	private void beforemethod() {
		Date startdate = new Date();
		System.out.println("Test start time " + startdate);		
	}
	
	@Test
	private void maintest() throws IOException {
		
   	  String username = DataDriven("C:\\Users\\Win11\\eclipse-workspace\\Testing\\xl sheet\\demo.xlsx","sheet1", 0, 0);
   	  String password = DataDriven("C:\\Users\\Win11\\eclipse-workspace\\Testing\\xl sheet\\demo.xlsx","sheet1", 1, 3);

   	POMFramework pom = new POMFramework() ;
   	
   	WebElement u = pom.getU();
   	WebElement p = pom.getP();
   	SendUserValue(u, username);
   	SendUserValue(p, password);
	}
	
	@AfterMethod
	private void aftermethod() {
		Date enddate = new Date();
		System.out.println("Test End time " + enddate);
	}	

}
