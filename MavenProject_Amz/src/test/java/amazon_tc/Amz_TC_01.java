package amazon_tc;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import resources.Launch_Quit_Browser;
import source_pages.Amz_Account_Page;
import source_pages.Amz_Login_Page;
import source_pages.Amz_Logout_Page;
import source_pages.Amz_Product_Page;

//verify searching with filters (eg. category, price range) gives accurate results

public class Amz_TC_01 extends Launch_Quit_Browser
{
	@Test (dataProvider="data1", dataProviderClass=resources.Fetch_Excel_Data.class)
	public void Amz_TestCase_1(String un, String pwd)
	{
		Amz_Login_Page login = new Amz_Login_Page(driver);
		Amz_Product_Page search = new Amz_Product_Page(driver);
		Amz_Product_Page product = new Amz_Product_Page(driver);
		Amz_Logout_Page logout = new Amz_Logout_Page(driver);
		Amz_Account_Page account = new Amz_Account_Page(driver);
		SoftAssert soft_assert = new SoftAssert();
		
		login.navigatetoSigninPage();
		login.enterUsername(un);
		login.click_Continue_pb();
		login.enterPassword(pwd);
		login.click_sign_in_pb();
		
		search.searchProduct();
		search.enter_after_searchProduct();
		
		product.click_on_Product_Category_Serach_Filter();
		soft_assert.assertTrue(product.verify_List_Of_Filtered_Products_By_Category(), "failed to filter by category");
		
		product.click_On_Search_By_Price();
		soft_assert.assertTrue(product.verify_List_Of_Filtered_Products_By_Price(), "failed to filter by price");

		soft_assert.assertAll("Assertion is completed");
		System.out.println("all the products are successfully filtered by category & price");
		
		account.hoverOver_AccountOptions();
		logout.click_sign_out_pb();
	}

}
