package e2e;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import data.UserFactory;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class MyTest extends BaseTest {
	@Test(description = "Verify user can login with valid credentials")
	public void validLoginTest() {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.LoginAs(UserFactory.getStandardUser());
		assertTrue(homePage.isHomePageShown(), "Home Page not shown");
	}

	@Test(description = "Verify user can not login with invalid credentials")
	public void inValidLoginTest() {
		LoginPage loginPage = new LoginPage();
		loginPage.LoginAs(UserFactory.getInvalidUser());
		assertEquals(loginPage.getErrorMessage(),
				"Epic sadface: Username and password do not match any user in this service");
	}
}
