package testpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.Base;
import pages.LoginOrSignUpPage;
import pages.MessengerPage;
import pages.RoomsPage;
import utils.Utility;

public class TestngFacebook extends Base{
	
	private WebDriver driver;
	private LoginOrSignUpPage loginOrSignUpPage;
	private MessengerPage messengerPage;
	private RoomsPage roomsPage;
	private String url;
	private String title;
	private int testId;
	
	@Parameters("browser")
	
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver=openChromebrowser();
		}
		if(browserName.equals("Firefox"))
		{
			driver=openFirefoxbrowser();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		loginOrSignUpPage=new LoginOrSignUpPage(driver);
		messengerPage= new MessengerPage(driver);
		roomsPage=new RoomsPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver.get("https://www.facebook.com/");
		loginOrSignUpPage.clickOnMessenger();
		messengerPage.clickOnRooms();
	}
	
	@Test
	public void returnToMessenger() throws IOException
	{   testId=121;
		roomsPage.clickOnreturnsToMessengercom();
		
		url= driver.getCurrentUrl();
		title=driver.getTitle();
		Assert.assertEquals(url,"https://www.messenger.com/");
		Assert.assertEquals(title, "Messenger");
	}
	 
	@Test
	public void verifyHelpCentreButton() throws IOException
	{   testId=122;
		roomsPage.clickOnvisitOurHelpCenter();
		url= driver.getCurrentUrl();
		title=driver.getTitle();
		Assert.assertEquals(url,"https://www.messenger.com/help");
		Assert.assertEquals(title, "Messenger Help Center");
	}
	
	@AfterMethod
	public void logout(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, testId);
		}
		System.out.println("logout");
	}

	@AfterClass
	public void removePOMObjects()
	{
		loginOrSignUpPage=null;
		messengerPage=null;
		roomsPage=null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	

}
