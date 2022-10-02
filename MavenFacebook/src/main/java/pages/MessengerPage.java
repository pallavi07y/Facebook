package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class MessengerPage {
	
	@FindBy (xpath="//a[text()='Rooms']") 
	private WebElement rooms;
	
	@FindBy (xpath="//a[text()='Features']") 
	private WebElement features;
	
	@FindBy (xpath="//a[text()='Privacy and safety']")
	private WebElement privacyAndSafety;
	
	public MessengerPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnRooms()
	{
		rooms.click();
	}
	
	public void clickOnfeatures()
	{
		features.click();
	}
	
	public void clickOnprivacyAndSafety()
	{
		privacyAndSafety.click();
	}
	

}
