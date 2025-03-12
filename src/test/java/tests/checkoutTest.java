package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutPage;
import pages.CheckoutReviewPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DataProvider;
import utils.Log;

public class checkoutTest extends BaseTest {

	@Test(description = "Verify Checkout functionality for second lowest item")
	public void ValidateCheckoutFlow() {
		LoginPage login = new LoginPage(driver);
		InventoryPage inventory= new InventoryPage(driver);
		CartPage cart= new CartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		CheckoutReviewPage review= new CheckoutReviewPage(driver);
		CheckoutCompletePage confirmation= new CheckoutCompletePage(driver);
		
		Log.Info("When User Login with Standard user ");
		login.enterUserName(DataProvider.InputData.getProperty("standardUser"));
		login.enterPassword(DataProvider.InputData.getProperty("password"));
		login.login();
		Log.Info("Then Login should be successful");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		Log.Info("And When User sort price Low to High");
		inventory.SortByPrice();
		Log.Info("And Add lowest-priced item to the cart ");
		inventory.AddToCart(0);
		Log.Info("Then product should be added to cart");
		Assert.assertEquals(inventory.getCartItemCount(), "1");
		Log.Info("Remove litem from the cart ");
		inventory.RemoveProductFromCart(0);
		Log.Info("Then product should be removed from cart");
		Assert.assertEquals(inventory.getCartItemCount(), ""); 
		Log.Info("And Add second lowest-priced item to the cart ");
		inventory.AddToCart(1);
		Log.Info("Then product should be added to cart");
		Assert.assertEquals(inventory.getCartItemCount(), "1");
		Log.Info("And user proceed to cart ");
		inventory.GoToCart();
		Log.Info("And user verify cart item");
		assertEquals(cart.getCartItemCount(), 1);
		Log.Info("And user proceed to checkout");
		cart.Checkout();
		Log.Info("And user provide details");
		checkout.enterFirstName(DataProvider.InputData.getProperty("firstName"));
		checkout.enterLastName(DataProvider.InputData.getProperty("lastName"));
		checkout.enterPostalCode(DataProvider.InputData.getProperty("postalCode"));
		Log.Info("And user continue to review page");
		checkout.Coninue();
		Log.Info("And user complete the purchase");
		review.Finish();
		assertEquals(confirmation.getConfirmationHeaderText(), DataProvider.outputData.getProperty("confirmationMessage"));
		
	}
}
