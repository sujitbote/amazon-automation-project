package source_pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amz_ShoppingCart_Page
{
	WebDriver driver;
	
	@FindBy (xpath ="//input[@id='add-to-cart-button']")
	WebElement add_to_cart_pb;
	
	@FindBy (id="nav-cart")
	WebElement go_to_shoppingcart_page;
	
	@FindBy (xpath="(//input[@value='Delete'])[1]")
	WebElement remove_product_from_cart;
	
	@FindBy (id="sc-buy-box-ptc-button")
	WebElement proceed_to_buy_pb;
	
	@FindBy (id="nav-cart")
	WebElement go_to_cart;
	
	@FindBy (xpath="//span[@class='a-button a-button-dropdown quantity']/span")
	WebElement qty_dd;
	
	@FindBy (xpath="(//div[@class='a-popover-wrapper']/div/ul/li)[6]")
	WebElement select_qty_from_dd;
	
	@FindBy (css="#sc-subtotal-label-activecart")
	WebElement get_displayed_qty_subtotal_text;
	
	@FindBy (xpath="(//span[@class='a-dropdown-prompt'])[1]")
	WebElement get_selected_qty;
	
	@FindBy (css=".a-spacing-mini.a-spacing-top-base")
	WebElement product_deleted_element;
	
	public void go_to_Cart()
	{
		go_to_cart.click();
	}
	public boolean isProductDeletedFromCart()
	{
		boolean condition = false;
		if(product_deleted_element.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	public boolean verifySelectedQty()
	{
		String substring[] = get_displayed_qty_subtotal_text.getText().split(" ");
		String displayed_qty = substring[1].replace("(", "").trim();
		String selected_qty = get_selected_qty.getText();
		
		boolean condition = false;
		
		if(displayed_qty.equals(selected_qty))
		{
			condition = true;
		}
		return condition;
	}
	
	public void qty_dd()
	{
		qty_dd.click();
	}
	
	public void select_qty_from_dd()
	{
		select_qty_from_dd.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-button a-button-dropdown quantity']/span")));

	}
	
	public void click_on_Add_to_Cart_fromProductPage()
	{
		add_to_cart_pb.click();
	}
	

	public void go_to_shoppingcart()
	{
		go_to_shoppingcart_page.click();
	}
	
	public void remove_Product_from_ShoppingCart()
	{
		go_to_shoppingcart_page.click();
	}
	
	public void proceed_to_buy()
	{
		proceed_to_buy_pb.click();
	}
	
	
	
	public void waitUntil_addToShoppingCartPBEnabled_afterWishlistpopup()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
	}
	
	
	public Amz_ShoppingCart_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
