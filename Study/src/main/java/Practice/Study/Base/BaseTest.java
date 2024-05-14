package Practice.Study.Base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest 
{
	protected WebDriver driver;
	protected Logger log;

	// setup browser
	@Parameters
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser , ITestContext cntxt) {
		String logname=cntxt.getCurrentXmlTest().getName();
		log= org.apache.logging.log4j.LogManager.getLogger(logname);
	BrowserDriverFactory factory =new BrowserDriverFactory(browser);
	driver = factory.createDriver();
	
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// close driver
		driver.close();
	}

}
