package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class SignUpPage {
	
	@FindBy (xpath="(//a[@role='button'])[2]") 
	private WebElement CreateNewAcc;
	
	@FindBy (xpath="//input[@name='firstname']") 
	private WebElement FirstName;
	
	@FindBy (xpath="//input[@name='lastname']") 
	private WebElement LastName;
	
	@FindBy (xpath="//input[@name='reg_email__']") 
	private WebElement mobileNo;
	
	@FindBy (xpath="//input[@name='reg_passwd__']") 
	private WebElement newPassword;
	
	@FindBy (xpath="//select[@name='birthday_day']") 
	private WebElement date;
	
	@FindBy (xpath="//select[@name='birthday_month']") 
	private WebElement month;
	
	@FindBy (xpath="//select[@name='birthday_year']") 
	private WebElement year;
	
	@FindBy (xpath="(//input[@type='radio'])[1]") 
	private WebElement female;
	
	@FindBy (xpath="(//input[@type='radio'])[2]") 
	private WebElement male;
	
	@FindBy (xpath="(//input[@type='radio'])[3]") 
	private WebElement custom;
	
	@FindBy (xpath="//select[@name='preferred_pronoun']") 
	private WebElement pronoun;
	
	@FindBy (xpath="//button[@name='websubmit']") 
	private WebElement signup;
	
	public SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewaccountOnApplication()
	{
		CreateNewAcc.click();
		FirstName.sendKeys("pallavi");
		LastName.sendKeys("Maind");
		mobileNo.sendKeys("9595769434");
		newPassword.sendKeys("pallavi!21234");
		date.click();
		month.click();
		year.clear();
		female.click();
		custom.click();
		pronoun.click();
		signup.click();
	}
	
	

}
