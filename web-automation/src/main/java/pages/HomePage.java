package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

	private By cartIcon = By.className("shopping_cart_link");

	public boolean isHomePageShown() {
		waitForElementToBePresent(cartIcon);
		return isElementDisplayed(cartIcon);
	}

}
