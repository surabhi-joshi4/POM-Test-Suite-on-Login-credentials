package Practice.Study;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Practice.Study.Base.TestUtilities;
import Practice.Study.Base.Pages.LoginPage;
import Practice.Study.Base.Pages.SecureAreaPage;
import Practice.Study.Base.Pages.WelcomePageObject;

public class NegativeTest extends TestUtilities {

	@Parameters({ "username", "password", "expectedmessage" })
	@Test
	public void negativeTest(String username, String password, String expectedmessage) {
		WelcomePageObject welcome = new WelcomePageObject(driver);
		LoginPage login = new LoginPage(driver);

		// open main page
		welcome.openPage();

		// click on from authentication link
		login = welcome.fromAuthenticationClick();

		// enter username and password
		SecureAreaPage securepage = login.negativeLogIn(username, "password");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// verify expected message
		Assert.assertTrue(login.getErrorrMsgText().contains(expectedmessage),
				"actualSuccessMessage does not contain expectedSuccessMessage");
	}
}
