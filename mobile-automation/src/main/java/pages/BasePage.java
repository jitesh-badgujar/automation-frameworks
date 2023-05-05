package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.PointerInput;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.util.Collections;

import com.appium.manager.AppiumDriverManager;
import io.appium.java_client.MobileDriver;

import utils.AppUtils;

public class BasePage {

	protected final boolean isAndroid = AppUtils.isAndroidDevice();

	protected final MobileDriver<?> driver;

	protected By screenElement;

	protected Dimension screenDimension;

	public BasePage() {
		super();
		this.driver = AppiumDriverManager.getDriver();
		this.screenDimension = driver.manage().window().getSize();
	}

	public void waitForIsShown() {
		AppUtils.waitForElementPresence(screenElement);
	}

	public void scrollDownTillElementAppears(By by) {
		int fromX = screenDimension.width / 2;
		int toX = fromX;
		int fromY = (int) (screenDimension.height * 0.9);
		int toY = (int) (screenDimension.height * 0.8);
		int retry = 0;
		boolean found = false;
		while (retry < 10) {
			try {
				if (driver.findElement(by).isDisplayed()) {
					found = true;
					break;
				}
			} catch (Exception e) {
				retry++;
			}
			swipe(fromX, fromY, toX, toY);
		}
		if (!found) {
			throw new RuntimeException("Element not found after scrolling");
		}
	}

	public void swipe(int fromX, int fromY, int toX, int toY) {
		PointerInput finger = new PointerInput(TOUCH, "finger");
		final Sequence swipe = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(ofMillis(0), viewport(), fromX, fromY))
				.addAction(finger.createPointerDown(LEFT.asArg()))
				.addAction(finger.createPointerMove(ofMillis(200), viewport(), toX, toY))
				.addAction(finger.createPointerUp(LEFT.asArg()));
		((RemoteWebDriver) driver).perform(Collections.singletonList(swipe));
	}
}
