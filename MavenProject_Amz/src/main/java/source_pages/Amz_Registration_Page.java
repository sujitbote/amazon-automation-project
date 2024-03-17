package source_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Amz_Registration_Page 
{
	
	@FindBy (linkText="Start here.")
	WebElement click_to_register_new_user_pb;
	
	@FindBy (id="ap_customer_name")
	WebElement enter_your_first_and_last_name;
	
	@FindBy (id="ap_phone_number")
	WebElement enter_your_phone_number;
	
	public void click_to_Register_New_User()
	{
		click_to_register_new_user_pb.click();
	}
	
	public void enter_your_First_and_Last_Name()
	{
		enter_your_first_and_last_name.sendKeys("trying registration");
	}
	public void enter_your_Phone_Number()
	{
		enter_your_phone_number.sendKeys("123456789");
	}
	
	

}
