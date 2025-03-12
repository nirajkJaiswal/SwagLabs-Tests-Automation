package tests;

import org.testng.annotations.Parameters;
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
import utils.Watch;

public class PerformanceTest extends BaseTest {
	@Test(description = "Verify page load time for different users", dataProvider = "Users")
	public void ValidateCheckoutFlow(String username) {
		LoginPage login = new LoginPage(driver);
		InventoryPage inventory = new InventoryPage(driver);
		CartPage cart = new CartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		CheckoutReviewPage review = new CheckoutReviewPage(driver);
		CheckoutCompletePage confirmation = new CheckoutCompletePage(driver);

		login.enterUserName(username);
		login.enterPassword(DataProvider.InputData.getProperty("password"));
		Watch.Start();
		login.login();
		inventory.WaitForPageLoad();
		Log.Info("Time taken in ms for login: " + Watch.Stop());

		inventory.AddToCart(0);
		Watch.Start();
		inventory.GoToCart();
		cart.WaitForPageLoad();
		Log.Info("Time taken in ms for cart page: " + Watch.Stop());

		Watch.Start();
		cart.Checkout();
		checkout.WaitForPageLoad();
		Log.Info("Time taken in ms for Checkout page: " + Watch.Stop());

		checkout.enterFirstName(DataProvider.InputData.getProperty("firstName"));
		checkout.enterLastName(DataProvider.InputData.getProperty("lastName"));
		checkout.enterPostalCode(DataProvider.InputData.getProperty("postalCode"));

		Watch.Start();
		checkout.Coninue();
		review.WaitForPageLoad();
		Log.Info("Time taken in ms for review page: " + Watch.Stop());

		Watch.Start();
		review.Finish();
		confirmation.WaitForPageLoad();
		Log.Info("Time taken in ms for confirmation page: " + Watch.Stop());

	}

	@org.testng.annotations.DataProvider(name = "Users")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "performance_glitch_user" }, { "standard_user" } };

	}
}
