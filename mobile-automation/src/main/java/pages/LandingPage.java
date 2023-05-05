package pages;

import org.openqa.selenium.By;

import utils.AppUtils;

public class LandingPage extends BasePage {

	private By acceptPermissionButton = By.id("com.android.permissioncontroller:id/continue_button");

	public LandingPage() {
		super();
		driver.findElement(acceptPermissionButton).click();
		AppUtils.waitForAlertAndAccept();
		// Above is needed for latest Android versions
		this.screenElement = AppUtils.getByText("Best Online Shopping Store");
	}

	public HomePage selectSite(String site) {
		driver.findElement(AppUtils.getByText(site)).click();
		return new HomePage();
	}
}
