package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.manager.AppiumDriverManager;

import io.appium.java_client.MobileBy;

public class AppUtils {

	public static boolean isAndroidDevice() {
		return System.getenv("Platform") != null && System.getenv("Platform").toLowerCase() == "android";
	}

	public static By getByResourceId(String resourceId) {
		return MobileBy.AndroidUIAutomator(String.format("new UiSelector().resourceId(\"%s\")", resourceId));
	}

	public static By getByText(String text) {
		return MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", text));
	}

	public static void waitForElementPresence(By by) {
		WebDriverWait wait = new WebDriverWait(AppiumDriverManager.getDriver(), 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void waitForAlertAndAccept() {
		WebDriverWait wait = new WebDriverWait(AppiumDriverManager.getDriver(), 10);
		wait.until(ExpectedConditions.alertIsPresent());
		AppiumDriverManager.getDriver().switchTo().alert().accept();
	}

}
