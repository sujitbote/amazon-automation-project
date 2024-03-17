package amazon_tc;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.Fetch_Excel_Data;
import resources.Launch_Quit_Browser;
import source_pages.Amz_Account_Page;
import source_pages.Amz_Login_Page;
import source_pages.Amz_Logout_Page;
import source_pages.Amz_Product_Page;
import source_pages.Amz_Wishlist_Page;

//scenario = Login->searching->adding the product to wishlist->adding the product to cart->logout
@Listeners(resources.TestListeners.class)
public class Amz_TC_06 extends Launch_Quit_Browser
{
	
	@Test (dataProvider="data1", dataProviderClass=Fetch_Excel_Data.class)
	public void login_addtoCart_Logout(String un, String pwd) throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Fetch_Excel_Data.fetchValue();

		Amz_Login_Page login = new Amz_Login_Page(driver);
		Amz_Account_Page account = new Amz_Account_Page(driver);
		Amz_Product_Page search = new Amz_Product_Page(driver);
		Amz_Wishlist_Page wishlist = new Amz_Wishlist_Page(driver);
		Amz_Logout_Page logout = new Amz_Logout_Page(driver);

		login.navigatetoSigninPage();
		login.enterUsername(un);
		login.click_Continue_pb();
		login.enterPassword(pwd);
		login.click_sign_in_pb();
		
		search.searchProduct();
		search.enter_after_searchProduct();
		search.click_on_searchedProduct();

		search.moveControl_to_childTab();
		
		wishlist.click_Wishlish_pb();
		wishlist.waitUntil_wishlistConfirmation_popupLoad();
		wishlist.click_View_Your_List();
				
		Assert.assertTrue("incorrect product is added to wishlist",wishlist.verify_Product_Added_To_Wishlist());
		System.out.println("correct product is added to wishlist");
		
		account.hoverOver_AccountOptions();
		logout.click_sign_out_pb();
		
	}

}
