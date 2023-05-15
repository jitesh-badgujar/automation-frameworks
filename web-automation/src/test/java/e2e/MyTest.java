package e2e;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;

import data.User;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class MyTest extends BaseTest {
	@Test(description = "Test 1 Details")
	public void test1() {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.LoginAs(User.getStandardUser());
		assertTrue(homePage.isHomePageShown(), "Home Page not shown");
	}

	@Test(description = "Test 2 Details")
	public void test2() {
		LoginPage loginPage = new LoginPage();
		loginPage.LoginAs(User.getInvalidUser());
		assertEquals(loginPage.getErrorMessage(),
				"Epic sadface: Username and password do not match any user in this service");
	}
}
