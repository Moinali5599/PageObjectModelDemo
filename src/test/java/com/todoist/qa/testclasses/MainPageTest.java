package com.todoist.qa.testclasses;

import org.testng.annotations.*;
import com.todoist.qa.baseclasses.PageBase;
import com.todoist.qa.pageclasses.LoginPage;
import com.todoist.qa.pageclasses.MainPage;

public class MainPageTest extends PageBase{
	public MainPage mainpage;
	public LoginPage loginpage;
	public MainPageTest() {
		super();
	}
	
	@BeforeTest
	public void startTest() {
		openBrowser();
		openApplication();
		loginpage = new LoginPage();
		mainpage=loginpage.doLogin("moinali5599@gmail.com", "MoinAli@5599");
	}
	
	@Test(priority = 1)
	public void addTaskTest() {
		mainpage.addTask(prop.getProperty("taskName"));
	}
	
	@Test(priority = 2)
	public void markTaskAsCompleteTest() {
		mainpage.markTaskAsComplete();
	}

}
