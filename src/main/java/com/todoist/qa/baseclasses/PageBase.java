package com.todoist.qa.baseclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class PageBase {
	public static WebDriver driver;
	public static Properties prop;

	public PageBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\ASUS\\Documents\\CTS Internship\\AutomationWS\\POMDemo\\src\\main\\java\\com\\todoist\\qa\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void openBrowser() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.driver",
					System.getProperty("user.dir") + "//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Opera")) {
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "//drivers//operadriver.exe");
			driver = new OperaDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void openApplication() {
		driver.get(prop.getProperty("url"));
	}
	
	public WebElement getWebElement(String xpath) {
		return (driver.findElement(By.xpath(xpath)));
	}

}
