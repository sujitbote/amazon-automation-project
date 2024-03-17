package amazon_tc;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import resources.Launch_Quit_Browser;
import resources.Navigations_on_Tab;
import source_pages.Amz_Account_Page;
import source_pages.Amz_Login_Page;
import source_pages.Amz_Logout_Page;
import source_pages.Amz_Product_Page;

//check if product can be sorted by price, rating

public class Amz_TC_02 extends Launch_Quit_Browser
{
	
	@Test (dataProvider="data1", dataProviderClass=resources.Fetch_Excel_Data.class)
	public void Amz_TestCase_1(String un, String pwd) throws InterruptedException
	{
		Amz_Login_Page login = new Amz_Login_Page(driver);
		Amz_Product_Page search = new Amz_Product_Page(driver);
		Amz_Product_Page product = new Amz_Product_Page(driver);
		Amz_Logout_Page logout = new Amz_Logout_Page(driver);
		Amz_Account_Page account = new Amz_Account_Page(driver);
		Navigations_on_Tab navigate = new Navigations_on_Tab(driver);
		SoftAssert soft_assert = new SoftAssert();
		
		login.navigatetoSigninPage();
		login.enterUsername(un);
		login.click_Continue_pb();
		login.enterPassword(pwd);
		login.click_sign_in_pb();
		
		search.searchProduct();
		search.enter_after_searchProduct();
		
		product.click_on_sort_by_low_price();
		soft_assert.assertTrue(product.verify_sort_by_price_low_to_high(), "failed to sort by low to high");
		
		navigate.tab_Refresh();
		
		product.click_on_sort_by_high_price();
		soft_assert.assertTrue(product.verify_sort_by_price_high_to_low(), "failed to sort by high to low");
		
		navigate.tab_Refresh();

		product.click_on_sort_by_avg_customer_reviews();
		soft_assert.assertTrue(product.verify_sort_by_avg_customer_review(), "failed to sort by avg customer review");
		
		soft_assert.assertAll("all assertion completed");
		System.out.println("products are successfully sorted by prices & customer reviews");
		
		account.hoverOver_AccountOptions();
		logout.click_sign_out_pb();
	}
	
	
	
	
	

}
