package pages;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DataProvider;

public class LoginPage {
	private WebDriver driver;

	private By tb_username = By.id("user-name");
	private By tb_password = By.id("password");
	private By btn_login = By.id("login-button");
	private By loginError = By.xpath("//*[@data-test='error']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void WaitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Long.parseLong(DataProvider.appConfig.getProperty("defaultWait"))));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.until(d -> driver.findElement(btn_login).isDisplayed());

	}

	public void enterUserName(String username) {
		driver.findElement(tb_username).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(tb_password).sendKeys(password);
	}

	public void login() {
		driver.findElement(btn_login).click();
	}

	public String getLoginErrorMessage() {
		return driver.findElement(loginError).getText();
	}
}
