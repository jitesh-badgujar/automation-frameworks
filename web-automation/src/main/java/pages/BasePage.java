package pages;

import utils.DriverManager;

public class BasePage extends ActionBot {

	public BasePage() {
		super(DriverManager.getDriver());
	}

}
