package amazon_tc;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.Launch_Quit_Browser;
import source_pages.Amz_Account_Page;
import source_pages.Amz_Login_Page;
import source_pages.Amz_Logout_Page;
import source_pages.Amz_Product_Page;
import source_pages.Amz_ShoppingCart_Page;
import source_pages.Amz_Wishlist_Page;

//Login->seraching->adding the product to wishlist->removing the product from wishlist->adding the product to cart->removong the product from cart->logout
@Listeners (resources.TestListeners.class)
public class Amz_TC_07 extends Launch_Quit_Browser
{
	@Test(dataProvider="data1", dataProviderClass=resources.Fetch_Excel_Data.class)
	public void login_AddRemoveProd_from_Wishlist_and_Cart(String un, String pwd) throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Fetch_Excel_Data.fetchValue();

		Amz_Login_Page login = new Amz_Login_Page(driver);
		Amz_Account_Page account = new Amz_Account_Page(driver);
		Amz_Product_Page search = new Amz_Product_Page(driver);
		Amz_Wishlist_Page wishlist = new Amz_Wishlist_Page(driver);
		Amz_ShoppingCart_Page shoppingcart = new Amz_ShoppingCart_Page(driver);
		Amz_Logout_Page logout = new Amz_Logout_Page(driver);
		SoftAssert soft_assert = new SoftAssert();

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
		wishlist.click_ContinueShopping_pb();
		
		shoppingcart.click_on_Add_to_Cart_fromProductPage();
		
		account.hoverOver_AccountOptions();
		account.click_on_WishList_option();
		
		wishlist.DeleteProduct_from_Wishlist();
		soft_assert.assertTrue(wishlist.isProductDeletedFromWishlist(),"product is not deleted from wishlist");
		
		shoppingcart.go_to_shoppingcart();
		
		shoppingcart.remove_Product_from_ShoppingCart();
		soft_assert.assertTrue(shoppingcart.isProductDeletedFromCart(),"product is not deleted from shopping cart");
		
		soft_assert.assertAll("assertion is completed");
		System.out.println("product is successfully deleted from wishlist & shopping cart");
		
		account.hoverOver_AccountOptions();
		logout.click_sign_out_pb();
	}
	

}
