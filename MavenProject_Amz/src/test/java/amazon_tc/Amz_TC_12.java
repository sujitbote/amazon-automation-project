package amazon_tc;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.Launch_Quit_Browser;
import resources.Navigations_on_Tab;
import source_pages.Amz_Account_Page;
import source_pages.Amz_Checkout_Page;
import source_pages.Amz_Login_Page;
import source_pages.Amz_Logout_Page;
import source_pages.Amz_Product_Page;
import source_pages.Amz_Wishlist_Page;

//Login->seraching he product->buy now->verify the payment from CC details section->logout
@Listeners (resources.TestListeners.class)

public class Amz_TC_12 extends Launch_Quit_Browser
{
	@Test(dataProvider="data1", dataProviderClass=resources.Fetch_Excel_Data.class)

	public void login_addProd_UPI_PaymentOption_logout(String un, String pwd) throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Fetch_Excel_Data.fetchValue();

		Amz_Login_Page login = new Amz_Login_Page(driver);
		Amz_Account_Page account = new Amz_Account_Page(driver);
		Amz_Product_Page search = new Amz_Product_Page(driver);
		Amz_Wishlist_Page wishlist = new Amz_Wishlist_Page(driver);
		Amz_Logout_Page logout = new Amz_Logout_Page(driver);
		Amz_Checkout_Page checkout = new Amz_Checkout_Page(driver);
		Navigations_on_Tab navigate = new Navigations_on_Tab(driver);
		
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
		wishlist.click_View_Your_List();				
		wishlist.click_on_Add_to_Cart_fromWishListPage();
		wishlist.click_on_Proceed_to_Checkout_fromWishListPage();
	
		checkout.use_Selected_Address();
		checkout.select_credit_card_rb();
		checkout.enter_Card_Details_popup();
		navigate.switch_to_Frame();
		
		Assert.assertTrue("CC detail popup is not displayed", checkout.is_CC_DetailsPopupDisplayed());
		System.out.println("CC details popup is dislayed successsfully");
		
		checkout.cancel_card_details_popup();

		wishlist.navigate_Back_To_WishlistPage();

		account.hoverOver_AccountOptions();
		logout.click_sign_out_pb();
		
	}
	
}
