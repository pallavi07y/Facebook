package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	@FindBy (xpath= "//input[@id='identify_email']")
	private WebElement forgotText;
	
	@FindBy (xpath= "//button[@id='did_submit']")
	private WebElement searchButton;
	
	
	public ForgotPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSerach()
	{
		forgotText.sendKeys("pallavi@gmail.com");
		searchButton.click();
	}
	

}
