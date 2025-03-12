package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.DataProvider;
import utils.Log;

public class BaseTest {

	protected static WebDriver driver;
	public BaseTest()
	{
		new DataProvider();
	}

	@BeforeMethod
	public void setup() {
		
		Log.Info("Starting webdriver!");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(DataProvider.appConfig.getProperty("url"));	
	}

	@AfterMethod
	public void tearDown() {
		if(driver!=null)
			Log.Info("Quiting webdriver!");
		driver.quit();
	}
}
