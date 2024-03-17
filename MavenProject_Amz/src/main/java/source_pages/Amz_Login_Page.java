package source_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_Login_Page
{
	//WebDriver driver;
	
	// locating each element by @FindBy annotation
	
	@FindBy (id ="nav-link-accountList")
	WebElement navigateTo_Signin_page;
	
	@FindBy (id="ap_email")
	private WebElement username;
	
	@FindBy (id="continue")
	WebElement continue_pb;
	
	
	@FindBy (xpath="//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy (id="signInSubmit")
	WebElement sign_in_pb;
	
	
	
	//create separate method for each component to perform an action

	public void navigatetoSigninPage()
	{
		navigateTo_Signin_page.click();
	}
	
	public void enterUsername(String un)
	{
		username.sendKeys(un);
	}
	
	public void click_Continue_pb()
	{
		continue_pb.click();
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void click_sign_in_pb()
	{
		sign_in_pb.click();
	}
	
	//initialize the components using page factory class inside a constructor
	
	public Amz_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
}
