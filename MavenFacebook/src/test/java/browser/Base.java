package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver openChromebrowser()
	{
		System.setProperty("webdriver.chrome.driver","F:\\velocity\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxbrowser()
	{
		System.setProperty("webdriver.gecko.driver","F:\\velocity\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		return driver;
	}

}
