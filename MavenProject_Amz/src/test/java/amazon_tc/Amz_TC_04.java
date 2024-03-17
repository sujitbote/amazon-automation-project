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

//scenario = Login->add product>select qty from cart->logout

@Listeners(resources.TestListeners.class)

public class Amz_TC_04 extends Launch_Quit_Browser
{
	@Test (dataProvider="data1", dataProviderClass=resources.Fetch_Excel_Data.class)
	public void login_Searching_Logout(String un, String pwd) throws EncryptedDocumentException, IOException, InterruptedException
	{
		Amz_Login_Page login = new Amz_Login_Page(driver);
		Amz_Account_Page account = new Amz_Account_Page(driver);
		Amz_Logout_Page logout = new Amz_Logout_Page(driver);
		Amz_Product_Page search = new Amz_Product_Page(driver);
		Amz_ShoppingCart_Page shoppingcart = new Amz_ShoppingCart_Page(driver);
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
		
		shoppingcart.click_on_Add_to_Cart_fromProductPage();
		
		shoppingcart.go_to_Cart();
		shoppingcart.qty_dd();
		shoppingcart.select_qty_from_dd();
		
		soft_assert.assertTrue(shoppingcart.verifySelectedQty(), "qty is incorrect");
		soft_assert.assertAll("assertion is done");
		System.out.println("qty is verified successfully");
		
		account.hoverOver_AccountOptions();
		logout.click_sign_out_pb();		
		
	}
	
}
