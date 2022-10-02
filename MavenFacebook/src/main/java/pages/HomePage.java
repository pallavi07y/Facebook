package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy (xpath="//span[text()='Friends']") 
	private WebElement friends;
	
	@FindBy (xpath="(//div[@aria-label='Your profile'])[1]") 
	private WebElement profile;
	
	@FindBy (xpath="//span[text()='Log Out']") 
	private WebElement logout;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFriends()
	{
		friends.click();
	}
	
	public void clickOnProfile()
	{
		profile.click();
	}
	
	public void clickOnLogout ()
	{
		logout.click();
	}
}
