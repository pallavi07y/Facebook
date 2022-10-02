package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMMock16 {
	
	private WebDriver driver;
	
	@FindBy (xpath="//input[@id='email']")
	private WebElement username;
	
	@FindBy (xpath="//input[@id='pass']")
	private WebElement password;
	
	@FindBy (xpath="//button[@id='Login']")
	private WebElement loginButton;
	
	public POMMock16(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void loginToApplication()
	{
		username.sendKeys("pallavi@gmail.com");
		password.sendKeys("pallavi@1234");
		loginButton.click();
	}
	
	//OR
	
	public void sendUsername()
	{
		username.sendKeys("pallavi@gmail.com");	
	}
	
	public void sendpassword()
	{
		password.sendKeys("pallavi@1234");
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	

}
