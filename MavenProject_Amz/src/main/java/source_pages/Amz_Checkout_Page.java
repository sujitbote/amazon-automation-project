package source_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amz_Checkout_Page 
{
	@FindBy (xpath="(//input[@class='a-button-input'])[2]")
	WebElement use_selected_address_pb;
	
	@FindBy (xpath="(//input[@name='ppw-instrumentRowSelection'])[1]")
	WebElement credit_debit_card_rb;
	
	@FindBy (xpath="(//input[@name='ppw-instrumentRowSelection'])[2]")
	WebElement net_banking_rb;
	
	@FindBy (xpath="(//input[@name='ppw-instrumentRowSelection'])[3]")
	WebElement upi_payment_rb;
	
	@FindBy (xpath="(//input[@name='ppw-instrumentRowSelection'])[5]")
	WebElement cash_on_delivery_rb;
	
	@FindBy (xpath="(//a[.='Enter card details'])[1]")
	WebElement enter_card_details_section;
	
	@FindBy (css="#a-popover-header-1")
	WebElement card_details_popup;
	
	@FindBy (xpath="//button[.='Cancel']")
	WebElement cancel_card_details_popup;
	
	public void use_Selected_Address()
	{
		use_selected_address_pb.click();
	}
	
	public boolean is_COD_PaymentOptionSelected()
	{
		boolean condition = false;
		if(cash_on_delivery_rb.isSelected())
		{
			condition = true;
		}
		return condition;
	}
	public boolean is_CC_PaymentOptionSelected()
	{
		boolean condition = false;
		if(credit_debit_card_rb.isSelected())
		{
			condition = true;
		}
		return condition;
	}
	public boolean is_NetBanking_PaymentOptionSelected()
	{
		boolean condition = false;
		if(net_banking_rb.isSelected())
		{
			condition = true;
		}
		return condition;
	}
	public boolean is_UPI_PaymentOptionSelected()
	{
		boolean condition = false;
		if(upi_payment_rb.isSelected())
		{
			condition = true;
		}
		return condition;
	}
	public boolean is_CC_DetailsPopupDisplayed()
	{
		boolean condition = false;
		if(card_details_popup.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public void select_Cash_On_Delivery_rb()
	{
		cash_on_delivery_rb.click();
	}
	
	public void select_credit_card_rb()
	{
		credit_debit_card_rb.click();
	}
	
	public void select_Net_Banking_rb()
	{
		net_banking_rb.click();
	}
	
	public void select_UPI_Payment_rb()
	{
		upi_payment_rb.click();
	}
	
	public void enter_Card_Details_popup()
	{
		enter_card_details_section.click();
	}
	
	public void cancel_card_details_popup()
	{
		cancel_card_details_popup.click();
	}
	
	public Amz_Checkout_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
