package pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import pages.components.SearchResultsPage;
import utils.AppUtils;

public class HomePage extends BasePage {

	private By searchField = AppUtils.getByResourceId("nav-search-keywords");
	private By searchIcon = AppUtils.getByText("Go");
	private By cartIcon = AppUtils.getByResourceId("nav-button-cart");

	public HomePage() {
		super();
		this.screenElement = MobileBy.AccessibilityId("Amazon");
	}

	public SearchResultsPage serach(String productName) {
		AppUtils.waitForElementPresence(searchField);
		driver.findElement(searchField).sendKeys(productName);
		driver.findElement(searchIcon).click();
		return new SearchResultsPage();
	}

	public CartPage gotoCart() {
		AppUtils.waitForElementPresence(cartIcon);
		driver.findElement(cartIcon).click();
		return new CartPage();
	}

}
