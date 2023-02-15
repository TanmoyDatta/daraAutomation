package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v106.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class DriverSetUp {
	private static String browserName = System.getProperty("browser","Chrome"); // console a user driver select kore dibe. , select na korle by default chrome browser open hobe
	
	private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal(); // localDriver nam a akta variable nilam
	// localDriver k set korar jonno method likhte hobe , and get korar jonno akta method likhte hobe
	// isolate kora holo ata
	// LOCAL_DRIVER er set method
	
	public static void setDriver(WebDriver driver) { // set method , set method korte (WebDriver driver) nite hobe/  [void thakle return kore na]
		DriverSetUp.LOCAL_DRIVER.set(driver); // localDriver er variable  er moddhe driver ta assgin kore dibo / set kore dilam
	}
	// LOCAL_DRIVER er get method
	public static WebDriver getDriver() {
		return LOCAL_DRIVER.get(); // localDriver ta get korlam
	}
	
	public static WebDriver getBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			return new ChromeDriver();
		case "firefox":
			return new FirefoxDriver();
		case "edge":
			return new EdgeDriver();
		default:
			throw new RuntimeException("Browser is not found using the name '"+browserName+"'!");
		}
	}
	
	@BeforeClass
	public static synchronized void setBrowser() {
		WebDriver webDriver = getBrowser(browserName);
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		webDriver.manage().window().maximize();
		setDriver(webDriver);
	}
	
	@AfterClass
	public static synchronized void quitBrowser() {
		getDriver().quit();
	}
}