package utils;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp(ITestContext context) {
		String browserName = context.getCurrentXmlTest().getParameter("browser");
		DriverManager.setDriver(browserName);
		driver = DriverManager.getDriver();
		driver.get(Constants.BASE_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.addScreenshotToAllureReport(DriverManager.getDriver(), result.getName());
		}
		DriverManager.getDriver().quit();
	}

}
