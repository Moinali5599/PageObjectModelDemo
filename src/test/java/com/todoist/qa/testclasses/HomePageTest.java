package com.todoist.qa.testclasses;

import org.testng.annotations.*;
import com.todoist.qa.baseclasses.PageBase;
import com.todoist.qa.pageclasses.HomePage;

public class HomePageTest extends PageBase {
	HomePage homepage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		openBrowser();
		openApplication();
		homepage = new HomePage();
	}
	@Test
	public void homePageTest() {
		homepage.isLogoVisible();
	}

}
