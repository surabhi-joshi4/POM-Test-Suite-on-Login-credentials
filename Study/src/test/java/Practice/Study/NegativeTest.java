package Practice.Study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTest {

	WebDriver driver;

	// setup browser
	@Parameters
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser) {
		// create driver
		System.out.println("create driver " + browser);

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.edge.driver", "D:\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Don't know how to start " + browser + " starting chrome");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
	}

	@Parameters({ "username", "password", "expectedmessage" })
	@Test
	public void negativeTest(String username, String password, String expectedmessage) {
		// open main page
		String url = "http://the-internet.herokuapp.com/";
		driver.get(url);
		System.out.println("Main page is open");

		// click on authentication link
		driver.findElement(By.linkText("Form Authentication")).click();

		// enter username and password
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		// click on login button
		driver.findElement(By.className("radius")).click();

		// verify expected message
		String actualerrormessage = driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(actualerrormessage.contains(expectedmessage),
				"actualSuccessMessage does not contain expectedSuccessMessage");
	}

	@AfterMethod
	public void tearDown() {
		// close driver
		driver.close();
	}

}
