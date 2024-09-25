package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement txtUserName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@id='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//img[@alt='Practice Test Automation']")
			WebElement logo;


	public void setUserName(String email) {
		txtUserName.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmitButton() {
		btnSubmit.click();
	}
	
	public boolean checkLogo() {
		
		boolean isDisplayed=logo.isDisplayed();
		
		if(!isDisplayed)
		{
			System.out.println("NoSuchElementFound");
		}
		
		return isDisplayed;
	}

}
