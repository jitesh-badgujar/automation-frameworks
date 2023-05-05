package pages;

import org.openqa.selenium.By;

import utils.AppUtils;

public class CartPage extends BasePage {

	private By totalPrice = By.xpath("//*[contains(@text,'Subtotal')]/following-sibling::android.widget.TextView");
	// No unique way inside native context, could be improved by switching to web

	private By cartCount = AppUtils.getByResourceId("nav-cart-count");

	public CartPage() {
		super();
		this.screenElement = AppUtils.getByResourceId("sc-active-cart");
	}

	public String getTotalPrice() {
		return driver.findElement(totalPrice).getText();
	}

	public String getCartItemsCount() {
		return driver.findElement(cartCount).getText();
	}

}
