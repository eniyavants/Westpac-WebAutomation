package co.westpac.automation.stepdefinitions;

import java.io.IOException;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import co.westpac.automation.Pages.homePage;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import WebConnector.webConnector;
public class homePageSteps extends webConnector {
    private homePage homePage;
    private String scenDesc;

    public homePageSteps() {
        this.homePage = new homePage();
    }

    @Before
    public void before() {
        setUpDriver();
    }

    @After
    public void after(Scenario scenario) throws IOException {
        closeDriver(scenario);
    }

    @BeforeStep
    public void beforeStep() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Given("^The user navigate to homePage$")
    public void aUserNavigatesToHomePage() throws InvalidFormatException, IOException {
        this.homePage.goToHomePage();
    }

    @Then("^the user mouse over on KiwiSaver option and selects kiwiSaverCalculator$")
    public void clickKiwiSaverCalculator() throws Exception {
         this.homePage.clickKiwiSaverCalculator();
    }

}
