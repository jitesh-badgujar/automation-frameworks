package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionBot {
	private final WebDriver driver;
	private final long defaultWaitTimeForElements = 20;

	public ActionBot(WebDriver driver) {
		this.driver = driver;
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void submit(By locator) {
		driver.findElement(locator).submit();
	}

	/**
	 * Type something into an input field. WebDriver doesn't normally clear these
	 * before typing, so this method does that first. It also sends a return key to
	 * move the focus out of the element.
	 */
	public void type(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	protected void waitForElementToBePresent(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTimeForElements));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	protected boolean isElementDisplayed(By by) {
		return driver.findElement(by).isDisplayed();
	}
}