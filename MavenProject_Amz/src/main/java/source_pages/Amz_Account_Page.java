package source_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_Account_Page 
{
	WebDriver driver;
	
	// locating each element by @FindBy annotation
	
	@FindBy (id="nav-link-accountList")
	WebElement hoverOver_AccountOptions_list;
	
	@FindBy (xpath="(//span[.='Your Wish List'])[2]")
	WebElement click_on_WishList_option;
	
	@FindBy (linkText="Your Account")
	WebElement click_on_youraccount_option;
	
	public void hoverOver_AccountOptions()
	{
		Actions action = new Actions(driver);
		action.moveToElement(hoverOver_AccountOptions_list).perform();
	}
	
	public void click_on_WishList_option()
	{
		click_on_WishList_option.click();
	}
	
	public void click_on_YourAccount_option()
	{
		click_on_youraccount_option.click();
	}
	
	//initialize the components using page factory class inside a constructor
	
	public Amz_Account_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
