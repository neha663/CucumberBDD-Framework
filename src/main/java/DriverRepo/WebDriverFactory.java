package DriverRepo;

import java.util.HashMap;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	static WebDriver driver;
	static String resourceFolder = "resources/files/software/";
	private static WebDriverFactory instance = null;

	private WebDriverFactory() {
	}

	/**
	 * Singleton pattern
	 * 
	 * @return a single instance
	 */
	public static WebDriverFactory getInstance() {
		if (instance == null) {
			instance = new WebDriverFactory();
		}
		return instance;
	}

	public static WebDriver createNewWebDriver(String browser, String os) {

		/******** The driver selected is Local: Firefox ********/
		if ("FIREFOX".equalsIgnoreCase(browser)) {
			if ("WINDOWS".equalsIgnoreCase(os)) {
				WebDriverManager.firefoxdriver().setup();
			} else {
				WebDriverManager.firefoxdriver().setup();
			}
			driver = new FirefoxDriver();
		}

		/******** The driver selected is Chrome ********/

		else if ("CHROME".equalsIgnoreCase(browser)) {
			if ("WINDOWS".equalsIgnoreCase(os)) {
				WebDriverManager.chromedriver().setup();
			} else {
				WebDriverManager.chromedriver().setup();
			}
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			HashMap<String, Object> chromePref = new HashMap<>();
			chromePref.put("download.default_directory", System.getProperty("java.io.tmpdir"));
			options.setExperimentalOption("prefs", chromePref);
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--no-sandbox");
			options.addArguments("--incognito");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			
			options.addArguments("--enable-javascript");
			
			driver = new ChromeDriver(options);
		
		}

		/******** The driver selected is Internet Explorer ********/
		else if ("IE".equalsIgnoreCase(browser)) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

			// Settings to Accept the SSL Certificate in the Capability object
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(capabilities);

		} else if ("EDGE".equalsIgnoreCase(browser)) {
			WebDriverManager.chromedriver().setup();
			DesiredCapabilities capabilities = DesiredCapabilities.edge();
			driver = new EdgeDriver(capabilities);
		} 
		
		/******** The driver is not selected ********/
		else {
			return null;
		}

		return driver;
	}
}
