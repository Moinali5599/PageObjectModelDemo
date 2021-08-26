package com.todoist.qa.testclasses;
import org.testng.annotations.*;

import com.todoist.qa.baseclasses.PageBase;
import com.todoist.qa.pageclasses.LoginPage;

public class LoginPageTest extends PageBase{
	LoginPage loginpage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		openBrowser();
		openApplication();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginWithEmailPassword() {
		loginpage.doLogin("moinali5599@gmail.com", "MoinAli@5599");
	}
	
	@Test(priority = 2)
	public void loginWithIncorrectPassword() {
		loginpage.doLogin("moinali5599@gmail.com", "Moin@1999");
	}
	
	@Test(priority = 3)
	public void loginWithIncorrectEmail() {
		loginpage.doLogin("incorrectmail", "MoinAli@5599");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
