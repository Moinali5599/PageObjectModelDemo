package com.todoist.qa.pageclasses;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.todoist.qa.baseclasses.PageBase;

public class HomePage extends PageBase {
	@FindBy(xpath = "//body[1]/div[1]/div[1]/main[1]/div[1]/header[1]/nav[2]/a[1]/svg[2]/g[1]/path[1]")
	public WebElement logo;
	@FindBy(xpath = "//header/nav[2]/div[1]/ul[3]/li[1]/a[1]")
	public WebElement loginButton;
	
	@FindBy(xpath = "//header/nav[2]/div[1]/ul[3]/li[2]/a[1]")
	public WebElement signupButton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void isLogoVisible() {
		if(logo.isDisplayed()) {
			System.out.println("Logo is visible");
		}else {
			System.out.println("Logo is not visible");
		}
	}
	
	public LoginPage clickLogin() {
		loginButton.click();
		return new LoginPage();
	}
	
	public SignupPage clickSignup() {
		signupButton.click();
		return new SignupPage();
	}


}
