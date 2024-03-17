package source_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_Logout_Page
{
	//WebDriver driver;
	
	// locating each element by @FindBy annotation
	
	@FindBy (xpath ="//span[.='Sign Out']")
	WebElement click_SignOut_pb;
	
	public void click_sign_out_pb()
	{
		click_SignOut_pb.click();
	}
	
	//initialize the components using page factory class inside a constructor
	
	public Amz_Logout_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}
	
	
}
