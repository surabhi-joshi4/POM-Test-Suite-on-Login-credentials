package Practice.Study.Base.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageObject {
	 WebDriver driver;

	public BasePageObject(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//open url
	protected void openUrl(String url)
	{
		driver.get(url);
	}
	
	//find element using locator
	protected WebElement find(By locator)
	{
		return driver.findElement(locator);
	}
	
	
	protected void click(By locator)
	{
		find(locator).click();
	}
	protected void type(String text,By locator)
	{
		find(locator).sendKeys(text);
	}
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();	
	}
}