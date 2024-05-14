package Practice.Study.Base.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject{

	private String pageUrl="https://the-internet.herokuapp.com/secure";
	private By logoutbutton = By.xpath("//a[@class='button secondary radius']");
	private By message = By.id("flash-messages");

	public SecureAreaPage(WebDriver driver)
	{
		super(driver);
	}
	public String getpageUrl()
	{
		return pageUrl;
	}
	public boolean islogoutbuttonVisible()
	{
		return driver.findElement(logoutbutton).isDisplayed();
	}
	public String getmessage()
	{
		
		return driver.findElement(message).getText();
	}
}
