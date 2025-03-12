package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DataProvider;

public class CheckoutPage {
	private WebDriver driver;

	private By tbFirstName = By.id("first-name");
	private By tbLastName = By.id("last-name");
	private By tbPostalCode = By.id("postal-code");
	private By btnContinue = By.id("continue");

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void WaitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Long.parseLong(DataProvider.appConfig.getProperty("defaultWait"))));
		wait.until(d -> driver.findElement(btnContinue).isDisplayed());

	}

	public void enterFirstName(String firstName) {
		driver.findElement(tbFirstName).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(tbLastName).sendKeys(lastName);
	}

	public void enterPostalCode(String postalCode) {
		driver.findElement(tbPostalCode).sendKeys(postalCode);
	}

	public void Coninue() {
		driver.findElement(btnContinue).click();
	}
}
