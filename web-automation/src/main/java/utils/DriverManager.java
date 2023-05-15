package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			DriverManager.driver.set(new ChromeDriver(options));
			break;
		default:
			throw new RuntimeException("Browser name not supported, Supported browsers: chrome");
		}
	}
}
