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
import pages.CreateNewAccPage;
import pages.LoginOrSignUpPage;
import pages.MessengerPage;
import pages.RoomsPage;
import utils.Utility;

public class TestNgCreateNewAccount extends Base {
	
	private WebDriver driver;
	private LoginOrSignUpPage loginOrSignUpPage;
	private CreateNewAccPage createNewAccPage;
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
	public void launchBrowser()
	{
		loginOrSignUpPage=new LoginOrSignUpPage(driver);
		createNewAccPage= new CreateNewAccPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		driver.get("https://www.facebook.com/");
		loginOrSignUpPage.clickOncreateNewAcc();
	}
	
	@Test (invocationCount=3)
	public void verifycreateNewAcc() throws IOException
	{
		testId= 101;
		
		String data=Utility.fetchDataFromExcelSheet("database", i, 0);
		createNewAccPage.sendfirstName(data);
		
		data=Utility.fetchDataFromExcelSheet("database", i, 1);	
		createNewAccPage.sendlastName(data);
		
		data=Utility.fetchDataFromExcelSheet("database", i, 2);	
		createNewAccPage.sendmobileNo(data);
		
		data=Utility.fetchDataFromExcelSheet("database", i, 3);	
		createNewAccPage.sendnewPassword(data);
		
		createNewAccPage.selectDoB();
		
		createNewAccPage.selectGender();
		
		createNewAccPage.clickOnsignUp();
		
		
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
		createNewAccPage=null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	


}
