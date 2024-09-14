package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage extends BasePage{
	
	public MyAccountsPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "//strong[contains(text(),'Congratulations student. You successfully logged i')]") // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement lnkLogout;
	

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		lnkLogout.click();

	}

}
