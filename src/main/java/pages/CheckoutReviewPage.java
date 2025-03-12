package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DataProvider;

public class CheckoutReviewPage {
	private WebDriver driver;

	private By btnfinish = By.id("finish");

	public CheckoutReviewPage(WebDriver driver) {
		this.driver = driver;
	}

	public void WaitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Long.parseLong(DataProvider.appConfig.getProperty("defaultWait"))));
		wait.until(d -> driver.findElement(btnfinish).isDisplayed());

	}

	public void Finish() {
		driver.findElement(btnfinish).click();
	}
}
