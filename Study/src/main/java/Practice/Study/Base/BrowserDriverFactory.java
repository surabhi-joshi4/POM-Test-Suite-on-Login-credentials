package Practice.Study.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private String browser;
	
	public BrowserDriverFactory(String browser)
	{
		this.browser=browser.toLowerCase();
	}
	
	public WebDriver createDriver()
	{
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			System.setProperty("webdriver.edge.driver", "D:\\edgedriver_win64\\msedgedriver.exe");
			driver.set(new EdgeDriver());
			break;
		default:
			System.out.println("Don't know how to start " + browser + " starting chrome");
			driver.set(new ChromeDriver());
			break;
		}
		
		return driver.get();
	}
	}
