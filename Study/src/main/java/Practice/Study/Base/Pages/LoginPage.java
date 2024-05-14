package Practice.Study.Base.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{
	public By usernameLoc= By.id("username");
	public By passwordLoc= By.id("password");
	public By loginButton =By.className("radius");
	private By errorMessageLocator = By.id("flash");

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public SecureAreaPage logIn(String username,String password)
	{
		System.out.println("Executing LogIn with username " + username + " and password " + password +"]");
		type(username, usernameLoc);
		type(password, passwordLoc);
		find(loginButton).click();
		return new SecureAreaPage(driver);
	}
	public SecureAreaPage negativeLogIn(String username, String password) {
		System.out.println("Executing LogIn with username " + username + " and password " + password +"]");
		type(username, usernameLoc);
		type(password, passwordLoc);
		find(loginButton).click();
		return new SecureAreaPage(driver);
	}
	public String getErrorrMsgText()
	{
		return find(errorMessageLocator).getText();
	}

}
