package org.pom;

import org.help.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMFramework extends BaseClass {
	
	public POMFramework() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="email")
	private WebElement u;
	
	@FindBy(name="pass")
	private WebElement p;
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement login;

	public WebElement getU() {
		return u;
	}

	public WebElement getP() {
		return p;
	}

	public WebElement getLogin() {
		return login;
	}
	
	
	

}
