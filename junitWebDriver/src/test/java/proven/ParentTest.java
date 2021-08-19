package proven;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ParentTest {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	public static final int SHORT_WAIT = 5;
	public static final int MEDIUM_WAIT = 10;
	public static final int LONG_WAIT = 15;

	
	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");

		//Set path for driver exe
		//System.setProperty("webdriver.chrome.driver","path/to/driver/exe");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(SHORT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, LONG_WAIT);
	}
	
	@After
	public void tearDown() {
		driver.quit();
		
	}


	protected void navigateToPage(String url) {
		// TODO Auto-generated method stub
		driver.navigate().to(url);
	}






}
