package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.ByteArrayInputStream;

import io.qameta.allure.Allure;

public class Helper {

	public static void saveScreenshot(WebDriver driver, String name) throws IOException {
		File screenshotFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("screenshots/screenshot_" + name + ".png"));
	}

	public static void addScreenshotToAllureReport(WebDriver driver, String name) {
		byte[] screenshotFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment(name, new ByteArrayInputStream(screenshotFile));
	}

}
