package testpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CreateNewAccPage;
import pages.LoginOrSignUpPage;
import utils.Utility;

public class VerifySignUpofFacebook {
	
	public static void main(String[] args) throws IOException {
	
	System.setProperty("webdriver.chrome.driver","F:\\velocity\\chromedriver_win32\\chromedriver.exe");
	
	WebDriver driver= new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.facebook.com/");
	
	LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
	CreateNewAccPage createNewAccPage= new CreateNewAccPage(driver);
    int testId=101;
	loginOrSignUpPage.clickOncreateNewAcc();
//	createNewAccPage.createNewAccOnFacebook();
//	createNewAccPage.captureScreenshot();
	String data=Utility.fetchDataFromExcelSheet("database", 0, 0);
	createNewAccPage.sendfirstName(data);
	data=Utility.fetchDataFromExcelSheet("database", 0, 1);
	createNewAccPage.sendlastName(data);
	data=Utility.fetchDataFromExcelSheet("database", 0, 2);
	createNewAccPage.sendmobileNo(data);
	data=Utility.fetchDataFromExcelSheet("database", 0, 3);
	createNewAccPage.sendnewPassword(data);
	Utility.captureScreenshot(driver, testId);
	createNewAccPage.selectDoB();
	
	createNewAccPage.selectGender();
	
	createNewAccPage.clickOnsignUp();
	
	Utility.captureScreenshot(driver, testId);
	
	
	}
	
}

