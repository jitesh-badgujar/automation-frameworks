package pages;

import org.openqa.selenium.By;

import data.User;

public class LoginPage extends BasePage {

	private By userNameField = By.id("user-name");
	private By passowordField = By.id("password");
	private By submitButton = By.id("login-button");
	private By errorMessage = By.className("error-button");

	public HomePage LoginAs(User user) {
		doLogin(user);
		return new HomePage();
	}

	public LoginPage LoginWithError(User user) {
		doLogin(user);
		return this;
	}

	public void doLogin(User user) {
		type(userNameField, user.getUserName());
		type(passowordField, user.getPassword());
		click(submitButton);
	}

	public String getErrorMessage() {
		return getText(errorMessage);
	}

}
