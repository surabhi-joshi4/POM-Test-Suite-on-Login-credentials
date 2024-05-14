package Practice.Study;

import org.testng.Assert;
import org.testng.annotations.Test;

import Practice.Study.Base.TestUtilities;
import Practice.Study.Base.Pages.LoginPage;
import Practice.Study.Base.Pages.SecureAreaPage;
import Practice.Study.Base.Pages.WelcomePageObject;

public class PositiveTest extends TestUtilities {

	@Test
	public void loginTest() {
		WelcomePageObject welcome = new WelcomePageObject(driver);
		LoginPage login = new LoginPage(driver);
		SecureAreaPage securepage = new SecureAreaPage(driver);
		// open main page
		welcome.openPage();

		// click on from authentication link
		login = welcome.fromAuthenticationClick();

		// enter username and password
		securepage = login.logIn("tomsmith", "SuperSecretPassword!");

		// verification url
		Assert.assertEquals(driver.getCurrentUrl(), securepage.getpageUrl());

		// logout button is visible
		Assert.assertTrue(securepage.islogoutbuttonVisible(), "logout button is not visible");

		// successful login message
		String expectedSuccessMessage = "You logged into a secure area!";
		Assert.assertTrue(securepage.getmessage().contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage");

	}
}