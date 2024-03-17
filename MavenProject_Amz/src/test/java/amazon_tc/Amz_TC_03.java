package amazon_tc;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.Fetch_Excel_Data;
import resources.Launch_Quit_Browser;
import source_pages.Amz_Account_Page;
import source_pages.Amz_Login_Page;
import source_pages.Amz_Logout_Page;
import source_pages.Amz_Product_Page;


//scenario = ensure that the product details page displays all necessary info (price, reviews, description)

//@Listeners (resources.TestListeners.class)
public class Amz_TC_03 extends Launch_Quit_Browser
{
	
	@Test (dataProvider="data1", dataProviderClass=Fetch_Excel_Data.class)
	public void login_addtoCart_Logout(String un, String pwd) throws EncryptedDocumentException, IOException, InterruptedException
	{

		Amz_Login_Page login = new Amz_Login_Page(driver);
		new Amz_Account_Page(driver);
		new Amz_Logout_Page(driver);
		Amz_Product_Page product = new Amz_Product_Page(driver);
		Amz_Logout_Page logout = new Amz_Logout_Page(driver);
		Amz_Account_Page account = new Amz_Account_Page(driver);
		SoftAssert soft_assert = new SoftAssert();

		login.navigatetoSigninPage();
		login.enterUsername(un);
		login.click_Continue_pb();
		login.enterPassword(pwd);
		login.click_sign_in_pb();

		product.searchProduct();
		product.enter_after_searchProduct();
		product.click_on_searchedProduct();
		product.moveControl_to_childTab();
		
		soft_assert.assertTrue(product.check_ProductPrice_isPresent(), "Product price tag is not displayed");
		soft_assert.assertTrue(product.check_ProductDetailsSection_isPresent(), "Product details section is not displayed");
		soft_assert.assertTrue(product.check_ProductDescriptionSection_isPresent(), "Product description section is not displayed");
		
		soft_assert.assertAll("Assertion is completed");
		System.out.println("Product price tag, details & description section is displayed successfully");

		account.hoverOver_AccountOptions();
		logout.click_sign_out_pb();
		
	}

}
