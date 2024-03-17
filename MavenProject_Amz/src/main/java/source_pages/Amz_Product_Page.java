package source_pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Amz_Product_Page
{
	SoftAssert softassert = new SoftAssert();
	
	WebDriver driver;

	//locate all required elements by using @FindBy annotation
	
	@FindBy (id = "twotabsearchtextbox")
	WebElement search_product;
	
	@FindBy (xpath = "(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]")
	WebElement click_SearchedProduct;
	
	@FindBy (xpath = "(//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']/span/span)[2]")
	WebElement product_price_tag;
	
	@FindBy (xpath = "//div[@id='detailBulletsWrapper_feature_div']/h2")
	WebElement product_details_section;
	
	@FindBy (xpath = "//h2[@class='softlines']")
	WebElement product_description_section_1;
	
	@FindBy (xpath = "//h2[.='Product Description']")
	WebElement product_description_section_2;
	
	@FindBy (css = "#n-title+ul>span>span:last-child")
	WebElement click_on_product_category_serach;
	
	@FindBy (xpath = "//div[@class='a-section aok-relative s-image-tall-aspect']/img")
	List<WebElement> list_of_filtered_products_by_category;
	
	@FindBy (css = "li[id='p_36/4516638031']>span")
	WebElement click_on_search_by_price;
	
	@FindBy (xpath = "//span[@class='a-price-whole']")
	List<WebElement> list_of_filtered_products_by_price;
	
	@FindBy (xpath = "//a[@class='a-link-normal s-no-hover s-underline-text s-underline-link-text s-link-style a-text-normal']//span[@class='a-price-whole']")
	List<WebElement> list_of_sorted_products_from_low_price;
	
	@FindBy (css = "#s-result-sort-select")
	WebElement click_on_sort_product;
	
	@FindBy (xpath = "(//ul[@class='a-nostyle a-list-link']/li)[2]")
	WebElement click_on_sort_option_price_low_to_high;
	
	@FindBy (xpath = "(//ul[@class='a-nostyle a-list-link'])/li")
	List<WebElement> list_of_sorted_options;
	
	@FindBy (css = "ul.a-nostyle.a-list-link")
	WebElement sort_option_dropdown;
	
	@FindBy (xpath = "(//div[@class='a-popover-inner']/ul/li)[5]")
	WebElement click_on_sort_option_new_arrivals;
	
	@FindBy (xpath = "//div[@class='a-fixed-left-grid AverageCustomerReviews a-spacing-small']/div")
	WebElement check_for_customer_reviews;
	
	@FindBy (xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
	List<WebElement> list_of_searched_products_result;
	
	@FindBy (css = "div[class='a-section a-spacing-small puis-padding-left-micro puis-padding-right-micro']")
	List<WebElement> list_of_searched_products_details;
	
	@FindBy (css = "span.a-dropdown-prompt")
	WebElement check_sort_by_option;
	
	
	public void searchProduct()
	{
		search_product.sendKeys("shoe");
	}
	
	public void enter_after_searchProduct()
	{		
		search_product.sendKeys(Keys.ENTER);
	}
	
	public String getPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void click_on_searchedProduct()
	{
		click_SearchedProduct.click();
	}
	
	public void moveControl_to_childTab()
	{
		Set<String> handle =driver.getWindowHandles();
		Iterator<String> iterate =handle.iterator();
		iterate.next();
		String childTab = iterate.next();
		driver.switchTo().window(childTab);
	}
	
	public boolean check_ProductDetailsSection_isPresent()
	{
		boolean condition = false;
		if(product_details_section.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public boolean check_ProductDescriptionSection_isPresent()
	{
		boolean condition = false;
		if(product_details_section.isDisplayed())
		{
			condition = true;
		}
		return condition;

	}
	
	public boolean check_ProductPrice_isPresent()
	{
		boolean condition = false;
		if(product_price_tag.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public void click_on_Product_Category_Serach_Filter()
	{
		click_on_product_category_serach.click();
	}
	
	public boolean verify_List_Of_Filtered_Products_By_Category()
	{
		boolean condition = false;
		int count = 0;
		String[] c = {"shoe","sneaker","Shoe", "Sneaker", "boot", "Boot", "Loafer", "Lace", "Mushy", "Flat"};
		
		for(WebElement product : list_of_filtered_products_by_category)
		{
			boolean is_product_valid = false;
			
			for(int i=0; i<c.length; i++)
			{
				if(product.getAttribute("alt").contains(c[i]))
				{
					count++;
					is_product_valid = true;
					break;
				}	
			}
			
			if(is_product_valid == false)
			{
				System.out.println(product.getAttribute("src")+" , "+product.getAttribute("alt"));
			}
		}
		
		if(list_of_filtered_products_by_category.size() == count)
		{
			condition = true;
		}
		
		return condition;
	}
	
	public boolean verify_List_Of_Filtered_Products_By_Price()
	{
		boolean condition = false;
		int count = 0;
		
		for(WebElement price : list_of_filtered_products_by_price)
		{
			int num = Integer.valueOf(price.getText());
			
			if(num <= 500)
			{
				count++;
			}
			
			else
			{
				System.out.println(price.getText());
			}
		}
		
		if(list_of_filtered_products_by_price.size() == count)
		{
			condition = true;
		}
		return condition;
	}
	
	public void click_On_Search_By_Price()
	{
		click_on_search_by_price.click();
	}
	
	public boolean get_Actual_Status_Of_Products_Sorted_by_LowPrice()
	{
		boolean sorted_by_price_status = false;
		
		ArrayList<Integer>al1 = new ArrayList<Integer>();

		for(WebElement price1 : list_of_sorted_products_from_low_price)
		{
			int product_price = Integer.valueOf(price1.getText().replace(",",""));
			
			al1.add(product_price);
		}
		
		
		ArrayList<Integer>al2 = new ArrayList<Integer>(al1);
		
		Collections.sort(al2);
		
		if(al1.equals(al2))
		{
			sorted_by_price_status = true;
		}
		
		return sorted_by_price_status;
	}
	
	public void verify_Products_Sorted_By_LowPrice()
	{
		softassert.assertTrue(get_Actual_Status_Of_Products_Sorted_by_LowPrice(), "Oops!!! products are not sorted by low price");
	}
	
	public void click_on_sort_by_low_price()
	{
		Select select = new Select(click_on_sort_product);
		select.selectByIndex(1);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")));
	}
	public void click_on_sort_by_high_price()
	{
		Select select = new Select(click_on_sort_product);
		select.selectByIndex(2);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")));
	}
	public void click_on_sort_by_avg_customer_reviews()
	{
		Select select = new Select(click_on_sort_product);
		select.selectByIndex(3);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")));
	}
	
	public void click_On_Sort_Option_New_Arrivals()
	{
		click_on_sort_option_new_arrivals.click();
	}
	
	public boolean verify_sort_by_price_low_to_high() throws InterruptedException
	{	
		boolean condition = false;
		if(check_sort_by_option.getText().equals("Price: Low to High"))
		{
			condition=true;
		}
		return condition;
	}
	
	public boolean verify_sort_by_price_high_to_low()
	{				
		boolean condition = false;
		if(check_sort_by_option.getText().equals("Price: High to Low"))
		{
			condition=true;
		}
		return condition;
	}
	
	public boolean verify_sort_by_avg_customer_review()
	{	
		boolean condition = false;
		if(check_sort_by_option.getText().equals("Avg. Customer Review"))
		{
			condition=true;
		}
		return condition;
	}
	
	public void verify_searched_result_for_DetailsDescriptionReviewsPrice_Sections()
	{
		System.out.println("product list size is: "+list_of_searched_products_result.size());

		for(int i=0; i<list_of_searched_products_result.size()-65; i++)
		{
			
			WebElement product = list_of_searched_products_result.get(i);
			String product_name = product.getText();
			product.click();
	
			Set<String> handles =driver.getWindowHandles();
			Iterator<String> iterate= handles.iterator();
			String parent_tab = iterate.next();
			String child_tab = iterate.next();
				
			driver.switchTo().window(child_tab);
			
			try
			{
				softassert.assertTrue(product_price_tag.isDisplayed());
			}
			catch(NoSuchElementException e11)
			{
				softassert.fail("product_price_tag is not displayed for - "+ product_name);
			}
			
			try
			{
				softassert.assertTrue(product_description_section_1.isDisplayed());
			}
			catch(NoSuchElementException e11)
			{
				try
				{
					softassert.assertTrue(product_description_section_2.isDisplayed());
				}
				catch(NoSuchElementException e12)
				{
					softassert.fail("product_description_section is not displayed for - "+ product_name);
				}
			}
			
			try
			{
				softassert.assertTrue(product_details_section.isDisplayed());
			}
			catch(NoSuchElementException e11)
			{
				softassert.fail("product_details_section is not displayed for - "+ product_name);
			}
			
			try
			{
				softassert.assertTrue(check_for_customer_reviews.isDisplayed());
			}
			catch(NoSuchElementException e11)
			{
				softassert.fail("customer_reviews are not displayed for - "+ product_name);
			}

			driver.close();
			driver.switchTo().window(parent_tab);
			
		}
		
	softassert.assertAll();
		
	}
	
	public Amz_Product_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
