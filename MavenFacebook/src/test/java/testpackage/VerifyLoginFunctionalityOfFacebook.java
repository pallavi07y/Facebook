package testpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginOrSignUpPage;
import utils.Utility;

public class VerifyLoginFunctionalityOfFacebook {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","F:\\velocity\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		int testId=121;
		LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
		String data=Utility.fetchDataFromExcelSheet("Testdata", 0, 0);
		loginOrSignUpPage.sendusername(data);
		data=Utility.fetchDataFromExcelSheet("TestData", 0, 1);
		loginOrSignUpPage.sendpassword(data);
		loginOrSignUpPage.clickOnEye();
		loginOrSignUpPage.clickOnLoginButton();
		
		Utility.captureScreenshot(driver, testId);
		
//		loginOrSignUpPage.loginToApplication();
		
//		String url= driver.getCurrentUrl();
//		String title= driver.getTitle();
//		
//		if(url.equals("https://www.facebook.com/") && title.equals("Facebook"))
//		{
//			System.out.println("PASS");
//		}
//		else
//		{
//			System.out.println("FAIL");
//		}
	}

}
