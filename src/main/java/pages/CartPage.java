package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DataProvider;

public class CartPage {
	private WebDriver driver;
	private By btnCheckout = By.id("checkout");
	private By itemList = By.xpath("//*[@data-test='inventory-item']");

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void WaitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Long.parseLong(DataProvider.appConfig.getProperty("defaultWait"))));
		wait.until(d -> driver.findElement(btnCheckout).isDisplayed());

	}

	public void Checkout() {
		driver.findElement(btnCheckout).click();
	}

	public int getCartItemCount() {
		return driver.findElements(itemList).size();
	}
}
