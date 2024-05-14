package Practice.Study.Base.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject {
	
	WebDriver driver;
	private String url="http://the-internet.herokuapp.com/";
	private By fromAuthenticationtext = By.linkText("Form Authentication");
	public WelcomePageObject(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void openPage()
	{
		driver.get(url);
		System.out.println("Main page is open");
	}
	
	public LoginPage fromAuthenticationClick()
	{
		driver.findElement(fromAuthenticationtext).click();
		return new LoginPage(driver);
	}
}
