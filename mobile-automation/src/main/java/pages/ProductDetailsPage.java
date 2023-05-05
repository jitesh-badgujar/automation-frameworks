package pages;

import java.util.Map;

import org.openqa.selenium.By;

import utils.AppUtils;

public class ProductDetailsPage extends BasePage {

	private By addToCartButton = AppUtils.getByResourceId("add-to-cart-button");
	private By buyBoxView = AppUtils.getByResourceId("buybox");

	public ProductDetailsPage() {
		super();
		this.screenElement = AppUtils.getByResourceId("productTitleGroupAnchor");
	}

	public void addProductToCart() {
		scrollDownTillElementAppears(buyBoxView);
		scrollDownTillElementAppears(addToCartButton);
		driver.findElement(addToCartButton).click();
	}

	public void selectBuyingOptions(Map<String, String> map) {
		for (String key : map.keySet()) {
			String value = map.get(key);
			switch (key) {
			case "format":
				scrollDownTillElementAppears(AppUtils.getByText(value));
				driver.findElement(AppUtils.getByText(value)).click();
				break;
			case "quantity":
				if (value != "1") {
					// default is 1, no need to select
					// TODO update qty
				}
				break;
			default:
				throw new RuntimeException("Unsupported buying option, Supported values: {format, quantity}");
			}
			// TODO Support location, new/used etc
			this.waitForIsShown();
		}
	}

}
