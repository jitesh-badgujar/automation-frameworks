package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverManager;

public class BasePage {

	protected final WebDriver driver = DriverManager.getDriver();

	private final long defaultWaitTimeForElements = 20;

	protected void waitForElementToBePresent(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTimeForElements));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	protected boolean isElementDisplayed(By by) {
		return driver.findElement(by).isDisplayed();
	}
}
