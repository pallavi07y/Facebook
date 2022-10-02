package testpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.LoginOrSignUpPage;

public class VerifyLogoutButton {
	
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","F:\\velocity\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
		loginOrSignUpPage.loginToApplication();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnProfile();
		homePage.clickOnLogout();
		
		String url= driver.getCurrentUrl();
		String title= driver.getTitle();
		
		if(url.equals("https://www.facebook.com/") && title.equals("Facebook"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}

}
