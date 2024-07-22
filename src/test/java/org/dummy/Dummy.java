package org.dummy;

import org.help.BaseClass;
import org.openqa.selenium.WebElement;
import org.pom.POMFramework;

public class Dummy extends BaseClass{
	public static void main(String[] args) {
		
		LaunchBrowser();	 
			
		OpenApp("https://www.facebook.com/");
	
	POMFramework pom = new POMFramework();	
	
	WebElement u = pom.getU();
	WebElement p = pom.getP();
	WebElement login = pom.getLogin();
	
    u.sendKeys("abc@gmail.com");
    p.sendKeys("12345");
    login.click();

	}

}
