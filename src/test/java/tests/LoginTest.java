package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;

import base.BaseTest;
import pages.LoginPage;
import utils.DataProvider;
import utils.Log;
import utils.Watch;

public class LoginTest extends BaseTest {

	@Test(description = "Verify error message for locked out user")
	public void VerifyLockedOutUserLogintest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(DataProvider.InputData.getProperty("lockedOutUser"));
		loginPage.enterPassword(DataProvider.InputData.getProperty("password"));
		loginPage.login();
		Assert.assertEquals(loginPage.getLoginErrorMessage(), DataProvider.outputData.getProperty("lockedOutError"));
	}
}
