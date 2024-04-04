package Practice.Study;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PositiveTest 
{
	
	@Test
	public void loginTest()
	{
		//create driver
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//open main page
		String url ="http://the-internet.herokuapp.com/";
		driver.get(url);
		System.out.println("Main page is open");
		
        //click on from authentication link
		driver.findElement(By.linkText("Form Authentication")).click();
		
		//enter username and password
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		//push login button
		WebElement loginbutton = driver.findElement(By.className("radius"));
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
		
		//verification url
		String expectedUrl= "https://the-internet.herokuapp.com/secure";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		
		//logout button is visible
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed(),"logOutButton is not visible.");
		
		//successful login message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage");

		
		//close browser
		driver.close();
}
}