package testpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginOrSignUpPage;
import pages.MessengerPage;
import pages.RoomsPage;

public class TestClassFacebook {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","F:\\velocity\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
		loginOrSignUpPage.clickOnMessenger();
		
		MessengerPage messengerPage= new MessengerPage(driver);
		messengerPage.clickOnRooms();
		
		RoomsPage roomsPage=new RoomsPage(driver);
		roomsPage.clickOnreturnsToMessengercom();
		
		String url= driver.getCurrentUrl();
		String title=driver.getTitle();
		
		if(url.equals("https://www.messenger.com/") && title.equals("Messenger"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}

}
