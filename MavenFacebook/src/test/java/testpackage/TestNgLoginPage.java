package testpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
import utils.Utility;

public class TestNgLoginPage extends Base{
	
	private WebDriver driver;
	private LoginOrSignUpPage loginOrSignUpPage;
	private String url;
	private String title;
	private int testId;
	private int i=0;
	
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
	public void createPOMObjects()
	{
		loginOrSignUpPage=new LoginOrSignUpPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		driver.get("https://www.facebook.com/");
		loginOrSignUpPage.clickOncreateNewAcc();
	}
	
	@Test (invocationCount=5)
	public void verifycreateNewAcc() throws IOException
	{
		testId= 111;
		String data= Utility.fetchDataFromExcelSheet("Testdata", i, 0);
		loginOrSignUpPage.sendusername(data);
		data= Utility.fetchDataFromExcelSheet("TestData", i, 1);
		loginOrSignUpPage.sendpassword(data);
		url= driver.getCurrentUrl();
		title=driver.getTitle();
		
		Assert.assertEquals(url,"https://www.messenger.com/help");
		Assert.assertEquals(title, "Messenger Help Centre");
	}
	
	@AfterMethod
	public void logout(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, testId);
		}
		System.out.println("logout");
		i++;
	}

	@AfterClass
	public void removePOMObjects()
	{
		loginOrSignUpPage=null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	



}
