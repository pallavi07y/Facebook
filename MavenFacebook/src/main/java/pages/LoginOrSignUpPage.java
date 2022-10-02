package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class LoginOrSignUpPage {
	
	//variables declaration
	
	@FindBy (xpath="//input[@id='email']") 
	private WebElement username;
	
	@FindBy (xpath="//input[@id='pass']") 
	private WebElement password;
	
	@FindBy (xpath="//div[@class='_9lsb _9ls8']") 
	private WebElement eye;
	
	@FindBy (xpath="//button[text()='Log in']") 
	private WebElement loginButton;
	
	@FindBy (xpath="//a[text()='Messenger']") 
	private WebElement messenger;
	
	@FindBy (xpath="(//a[@role='button'])[2]") 
	private WebElement createNewAcc;
	
	@FindBy (xpath="//a[text()='Forgotten password?']") 
	private WebElement forgottenPassword;
	
	
	//Variable Initialization
	
	public LoginOrSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendusername (String user)
	{
		username.sendKeys(user);
	}
	
	public void sendpassword (String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnEye()
	{
		eye.click();
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	
	public void clickOnMessenger()
	{
		messenger.click();
	}
	
	public void clickOnforgottenPassword()
	{
		forgottenPassword.click();
	}
	
	public void clickOncreateNewAcc()
	{
		createNewAcc.click();
	}
	
	
	//Or
	
	public void loginToApplication()
	{
		username.sendKeys("pallavisiddhai@gmail.com");
		password.sendKeys("Pallavi@123");
		eye.click();
		loginButton.click();
	}
	
	
	
	
	

}
