package com.appium.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = { "src/test/resources/features" }, plugin = {
		"com.cucumber.listener.CucumberScenarioReporterListener", "com.cucumber.listener.CucumberScenarioListener",
		"html:target/results.html", "message:target/results.ndjson" })

public class RunCukes extends AbstractTestNGCucumberTests {
	public RunCukes() {
		System.out.printf("ThreadID: %d: RunCucumberTest%n", Thread.currentThread().getId());
	}

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		System.out.printf("ThreadID: %d: in overridden scenarios%n", Thread.currentThread().getId());
		Object[][] scenarios = super.scenarios();
		System.out.println(scenarios);
		return scenarios;
	}
}