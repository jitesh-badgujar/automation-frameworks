package com.appium.tests.steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;

public class StepDefs extends BaseTest {

	@Given("I am on landing screen")
	public void i_am_on_landing_screen() {
		landingPage = new LandingPage();
		landingPage.waitForIsShown();
	}

	@Given("I select {string} as online shopping site")
	public void i_select_as_online_shopping_site(String site) {
		homePage = landingPage.selectSite(site);
		homePage.waitForIsShown();
	}

	@Given("I search for {string} product")
	public void i_search_for_product(String productName) {
		searchResultsPage = homePage.serach(productName);
		searchResultsPage.waitForIsShown();
	}

	@When("I select {string} product from the search results")
	public void i_select_product_from_the_search_results(String index) {
		productDetailsPage = searchResultsPage.selectResult(index);
		productDetailsPage.waitForIsShown();
	}

	@When("I provide below data as buying options")
	public void i_provide_below_data_as_buying_options(List<Map<String, String>> data) {
		productDetailsPage.selectBuyingOptions(data.get(0));
	}

	@When("I add product to the cart")
	public void i_add_product_to_the_cart() {
		productDetailsPage.addProductToCart();
	}

	@When("I go to the cart")
	public void i_go_to_the_cart() {
		cartPage = homePage.gotoCart();
		cartPage.waitForIsShown();
	}

	@Then("I should see {string} products in the cart")
	public void i_should_see_products_in_the_cart(String numberOfProducts) {
		Assert.assertEquals(cartPage.getCartItemsCount(), numberOfProducts);
	}

	@Then("I should see total updated correctly")
	public void i_should_see_total_updated_correctly() {
		/*
		 * Total value is dynamic hence just making sure that value is shown and
		 * contains currency. This Could be improved by making API call to get the
		 * correct price. Or If we are using static/known test data for Products then
		 * can be asserted accordingly.
		 */
		String total = cartPage.getTotalPrice();
		Assert.assertTrue(total.contains("$"), "Total is missing currency: " + total);

	}
}
