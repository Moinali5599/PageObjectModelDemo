package com.todoist.qa.pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.todoist.qa.baseclasses.PageBase;

public class LoginPage extends PageBase {
	@FindBy(xpath = "//input[@name='email']")
	WebElement email_field;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password_field;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@class='ist_button ist_button_google']")
	WebElement login_with_google;

	@FindBy(xpath = "//a[@class='ist_button ist_button_facebook']")
	WebElement login_with_facebook;

	@FindBy(xpath = "//a[@class='ist_button ist_button_apple']")
	WebElement login_with_apple;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public MainPage doLogin(String email, String password) {
		email_field.sendKeys(email);
		password_field.sendKeys(password);
		loginBtn.click();
		if (driver.getTitle().equalsIgnoreCase("Log in to Todoist")) {
			WebElement errormsg = getWebElement("//div[@class='error_msg']/span");
			System.out.println("Log in failed");
			System.out.println(errormsg.getText());
		}else{
			System.out.println("Login Success");
		}
		return new MainPage();
	}
}
