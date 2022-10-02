package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class RoomsPage {
	
	@FindBy (xpath="//a[text()=' Return to messenger.com ']") 
	private WebElement returnsToMessengercom;
	
	@FindBy (xpath="//a[text()=' Visit our help center ']") 
	private WebElement visitOurHelpCenter;
	
	public RoomsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnreturnsToMessengercom()
	{
		returnsToMessengercom.click();
	}
	
	public void clickOnvisitOurHelpCenter()
	{
		visitOurHelpCenter.click();
	}
	

}
