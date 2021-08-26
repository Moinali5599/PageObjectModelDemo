package com.todoist.qa.pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.todoist.qa.baseclasses.PageBase;

public class MainPage extends PageBase {
	
	@FindBy(xpath="//button[@aria-label='Main menu']")
	public WebElement mainMenuBtn;
	
	@FindBy(xpath="//input[@aria-label='Quick search']")
	public WebElement searchField;
	
	@FindBy(xpath="//button[@id='quick_add_task_holder']")
	public WebElement addTaskBtn;
	
	@FindBy(xpath="//*[@id=\"reactist-modal-box-0\"]/section/form/div[1]/div[1]/div/div/div/div[2]/div/div/div/div/span/br")
	public WebElement task_title_field;
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addTask(String task) {
		addTaskBtn.click();
		task_title_field.sendKeys(task);
		WebElement addtask=getWebElement("//button[@type='submit']");
		addtask.click();
	}
	
	public void markTaskAsComplete() {
		WebElement checkbox=getWebElement("//button[@aria-label='Mark task as complete']");
		checkbox.click();
	}
	

}
