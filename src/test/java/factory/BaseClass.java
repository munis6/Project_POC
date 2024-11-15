package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	static WebDriver driver;
	static Logger logger;
	static Properties pro;
	
	public static WebDriver initializeBrowser() throws IOException
	{
		pro= getProperties();
		String executionEnv=pro.getProperty("execution_env");
		String browser=pro.getProperty("browser").toLowerCase();
		String os=pro.getProperty("os").toLowerCase();
		
		if(executionEnv.equalsIgnoreCase("remote"))
		{
			System.out.println("Entered Remote server execution");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			 switch (os) {
	        case "windows":
	            capabilities.setPlatform(Platform.WINDOWS);
	            break;
	        case "mac":
	            capabilities.setPlatform(Platform.MAC);
	            System.out.println("Selected Mac Machine");
	            break;
	        case "linux":
	            capabilities.setPlatform(Platform.LINUX);
	            System.out.println("picked up Remote Linux machine");
	            break;
	        default:
	            System.out.println("No matching OS");
	            return null;
	       }
			 
			//browser
			 switch (browser.toLowerCase()) {
	        case "chrome":
	            capabilities.setBrowserName("chrome");
	            
	            System.out.println("Remote Linux machine - Chrome driver initiated");
	            break;
	        case "edge":
	            capabilities.setBrowserName("MicrosoftEdge");
	            break;
	        case "firefox":
	            capabilities.setBrowserName("firefox");
	            System.out.println("Remote Firefox driver initiated");
	            break;
	        default:
	            System.out.println("No matching browser");
	            return null;
	        }
	      
	       driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			 
			// driver=new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
			
		}
		else if(executionEnv.equalsIgnoreCase("local"))
			{
				switch(browser.toLowerCase()) 
				{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    case "firefox":
			    	driver=new FirefoxDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
		 driver.manage().deleteAllCookies(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		 
		 return driver;
	}
	
	
	
	public static Properties getProperties() throws IOException
	{
		FileReader file=new FileReader(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		pro=new Properties();
		pro.load(file);
		return pro;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static Logger getLogger()
	{
		logger=LogManager.getLogger();
		return logger;
	}
	
	public static String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}


	public static String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

		
	public static String randomAlphaNumeric()
	{
	String str=RandomStringUtils.randomAlphabetic(5);
	String num=RandomStringUtils.randomNumeric(10);
	return str+num;
	}

}
