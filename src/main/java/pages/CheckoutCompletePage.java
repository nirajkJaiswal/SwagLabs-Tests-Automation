package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DataProvider;

public class CheckoutCompletePage {

	private WebDriver driver;

	private By confirmationHeader = By.xpath("//*[@data-test='complete-header']");

	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
	}

	public void WaitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Long.parseLong(DataProvider.appConfig.getProperty("defaultWait"))));
		wait.until(d -> driver.findElement(confirmationHeader).isDisplayed());

	}

	public String getConfirmationHeaderText() {
		return driver.findElement(confirmationHeader).getText();
	}
}
