package source_pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amz_Wishlist_Page 
{
	WebDriver driver;
	String selected_product;
	String wishlist_pagetitle;

	@FindBy (id = "add-to-wishlist-button-submit")
	WebElement add_to_Wishlist;
	
	@FindBy (xpath = "//span[@class='a-button a-button-span12 a-button-primary']")
	WebElement click_ContinueShopping;
	
	@FindBy (xpath = "(//input[@name='submit.deleteItem'])[1]")
	WebElement click_DeleteProduct_from_Wishlist;
	
	@FindBy (css ="#nav-al-your-account>a:nth-child(4)")
	WebElement click_view_wishlist;
	
	@FindBy (xpath="//a[@class='a-button-text a-text-center']")
	WebElement add_to_cart_from_wishlist_page;
	
	@FindBy (xpath="//a[.='Proceed to checkout']")
	WebElement Proceed_to_Checkout_fromWishListPage;
	
	@FindBy (css="span[class='a-button a-spacing-medium a-button-span12 a-button-base']>span")
	WebElement click_view_your_list;
	
	@FindBy (css = "#productTitle")
	WebElement get_selected_product_name;
	
	@FindBy (css = "#itemName_IN9C6VP6O51XB")
	WebElement get_added_product_name_in_wishlist;
	
	@FindBy (css = "#itemName_IN9C6VP6O51XB")
	WebElement product_deleted_element;
	
	public void click_View_Your_List()
	{
		click_view_your_list.click();
	}
	
	public boolean verify_Product_Added_To_Wishlist()
	{
		boolean condition = false;
		String wishlist_product = get_added_product_name_in_wishlist.getText();

		if(wishlist_product.equals(selected_product))
		{
			condition = true;
		}
		return condition;
	}
	
	public void click_Wishlish_pb()
	{
		selected_product = get_selected_product_name.getText();
		add_to_Wishlist.click();
	}
	
	public void click_ContinueShopping_pb()
	{
		click_ContinueShopping.click();
	}
	
	public void DeleteProduct_from_Wishlist()
	{
		click_DeleteProduct_from_Wishlist.click();
	}
	public boolean isProductDeletedFromWishlist()
	{
		boolean condition = false;
		if(product_deleted_element.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public void view_wishlist()
	{
		click_view_wishlist.click();
	}
	
	public void click_on_Add_to_Cart_fromWishListPage()
	{
		wishlist_pagetitle = driver.getTitle();
		add_to_cart_from_wishlist_page.click();
	}
	
	public void click_on_Proceed_to_Checkout_fromWishListPage()
	{
		Proceed_to_Checkout_fromWishListPage.click();
	}
	
	public void waitUntil_wishlistConfirmation_popupLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Close']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-button a-button-span12 a-button-primary']")));
	}
	
	public void navigate_Back_To_WishlistPage()
	{
		String current_page_title = driver.getTitle();		
		
		while (!(current_page_title.equals(wishlist_pagetitle)))
		{
			driver.navigate().back();
			current_page_title = driver.getTitle();
		}
	}
	
	public Amz_Wishlist_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	

}
