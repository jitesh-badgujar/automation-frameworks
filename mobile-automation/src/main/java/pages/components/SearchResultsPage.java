package pages.components;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import pages.BasePage;
import pages.ProductDetailsPage;
import utils.AppUtils;

public class SearchResultsPage extends BasePage {

	private By productResults = MobileBy.AccessibilityId("product-detail");

	public SearchResultsPage() {
		super();
		this.screenElement = AppUtils.getByText("Results");
	}

	public ProductDetailsPage selectResult(String name) {
		/*
		 * currently selecting first product, can be enhanced later to select given data
		 */
		driver.findElement(productResults).click();
		return new ProductDetailsPage();
	}
}
