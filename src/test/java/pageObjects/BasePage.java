package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

class BasePage {
	
	protected WebDriver driver;
	
	 BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); //this is very important to load page objects
	}

}
