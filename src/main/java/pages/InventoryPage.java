package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DataProvider;

public class InventoryPage {
	private WebDriver driver;

	private By btnAddToCart = By.xpath("//*[@data-test='inventory-item']//button");
	private By lbPrice = By.xpath("//*[@data-test='inventory-price']");
	private By btnCart = By.xpath("//*[@data-test='shopping-cart-link']");
	private By sortOption = By.xpath("//*[@data-test='product-sort-container']");

	public InventoryPage(WebDriver driver) {

		this.driver = driver;
	}
	public void WaitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Long.parseLong(DataProvider.appConfig.getProperty("defaultWait"))));
		wait.until(d -> driver.findElement(btnCart).isDisplayed());

	}
	public void AddToCart(int productIndex) {
		driver.findElements(btnAddToCart).get(productIndex).click();
	}

	public void RemoveProductFromCart(int productIndex) {
		driver.findElements(btnAddToCart).get(productIndex).click();
	}

	public void GoToCart() {
		driver.findElement(btnCart).click();
	}

	public void SortByPrice() {
		Select dropdown = new Select(driver.findElement(sortOption));
		dropdown.selectByIndex(2);
	}
	public String getCartItemCount()
	{
		return driver.findElement(btnCart).getText();
	}
}
