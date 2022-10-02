package pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.Utility;

public class CreateNewAccPage {
	
	private WebDriver driver;
	private Select s;
	
	@FindBy (xpath="//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy (xpath="//input[@name='lastname']")
	private WebElement lastName;
	
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
	private WebElement signUp;
	
	public CreateNewAccPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void sendfirstName(String first)
	{
		firstName.sendKeys(first);
	}
	
	public void sendlastName(String last)
	{
		lastName.sendKeys(last);
	}
	
	public void sendmobileNo(String mob)
	{
		mobileNo.sendKeys(mob);
	}
	
	public void sendnewPassword(String pass)
	{
		newPassword.sendKeys(pass);
	}
	
	public void selectDoB()
	{
		s= new Select(date);
		s.selectByValue("27");
		s=new Select(month);
		s.selectByValue("1");
		s=new Select(year);
		s.selectByValue("1995");
	}
	
	public void selectGender()
	{
		female.click();
		male.click();
		custom.click();
		pronoun.click();
		s=new Select(pronoun);
		s.selectByValue("1");
	}
	
	public void clickOnsignUp()
	{
		signUp.click();
	}
	
	//OR
	
	public void createNewAccOnFacebook()
	{
		firstName.sendKeys("Sanket");
		lastName.sendKeys("Jade");
		mobileNo.sendKeys("8950502020");
		newPassword.sendKeys("pallavi!2123");
		s= new Select(date);
		s.selectByValue("20");
		s=new Select(month);
		s.selectByValue("5");
		s=new Select(year);
		s.selectByValue("1995");
		custom.click();
		pronoun.click();
		s=new Select(pronoun);
		s.selectByValue("1");
		signUp.click();
		
	}
	
	
	
	
	
	
	

}
