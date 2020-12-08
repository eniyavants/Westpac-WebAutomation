package co.westpac.automation.stepdefinitions;

import co.westpac.automation.Pages.kiwiSaverPage;
import WebConnector.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

public class kiwiSaverSteps extends webConnector {
    private kiwiSaverPage kiwiSaverPage = new kiwiSaverPage();
    private int offset;
    webConnector webConnector = new webConnector();

    @And("the user Clicks on the menu {string}")
    public void theUserClicksOnTheMenu(String Menu) throws Exception {
        PerformActionOnElement(kiwiSaverPage.Get_started, "Click", "");
    }

    @And("the user verifies all fields in the calculator have got the information icon")
    public void theUserVerifiesAllFieldsInTheCalculatorHaveGotTheInformationIcon() throws Exception {
        driver.switchTo().frame(0);
        PerformActionOnElement(kiwiSaverPage.CurrentAgeIcon, "Click", "");
        PerformActionOnElement(kiwiSaverPage.EmploymentStatusIcon, "Click", "");
        PerformActionOnElement(kiwiSaverPage.Vol_ContributionIcon, "Click", "");
        PerformActionOnElement(kiwiSaverPage.RiskProfileIcon, "Click", "");
        PerformActionOnElement(kiwiSaverPage.kiwiBalanceIcon, "Click", "");
        PerformActionOnElement(kiwiSaverPage.SavingsGoalRetIcon, "Click", "");
        FileUtil.CaptureScreenShot("IconsDisplayed", ".png");
    }

    @When("the user Clicks on the icon beside {string}")
    public void theUserClicksOnTheIconBeside(String arg0) throws Exception {
        FindAnElement(kiwiSaverPage.main).click();
        driver.switchTo().frame(0);
        FindAnElement(kiwiSaverPage.CurrentAgeIcon).click();
    }

    @Then("the {string} page is displayed")
    public void thePageIsDisplayed(String expectedTitle) {
        String Actualtitle = driver.getTitle();
        assertEquals(Actualtitle, expectedTitle);
    }

    @Then("the following message is displayed {string}")
    public void theFollowingMessageIsDisplayed(String ExpectedMessage) throws Exception {
        FileUtil.CaptureScreenShot("FieldValidation", ".png");
        String ActualMessage = FindAnElement(kiwiSaverPage.CurrentAgeMessage).getText();
        assertEquals(ActualMessage, ExpectedMessage);
    }

    @And("user enter the age {string}")
    public void userEnterTheAge(String Age) throws Exception {
        FindAnElement(kiwiSaverPage.main).click();
        driver.switchTo().frame(0);
        PerformActionOnElement(kiwiSaverPage.CurrentAgeTextField, "Type", Age);
    }

    @Then("user enter the salary {string}")
    public void user_enter_the_salary(String Salary) throws Exception {
        if (!Salary.isEmpty())
            PerformActionOnElement(kiwiSaverPage.SalaryField, "Type", Salary);
    }

    @Then("user selects KiwiSaver contribution {string}")
    public void user_selects_KiwiSaver_contribution(String percentage) throws Exception {
        this.kiwiSaverPage.selectContribution(percentage);
    }

    @Then("user sets the risk profile as {string}")
    public void user_sets_the_risk_profile(String RiskProfile) throws Exception {
        if (!RiskProfile.isEmpty())
            this.kiwiSaverPage.selectRiskProfile(RiskProfile);
    }

    @Then("Projected balance at retirement is calculated")
    public void projectedBalanceAtRetirementIsCalculated() throws Exception {
        FileUtil.CaptureScreenShot("RetirementCalculated", ".png");
        FindAnElement(kiwiSaverPage.KiwiSaverResult).isDisplayed();
    }

    @And("user selects the employment status {string}")
    public void userSelectsTheEmploymentStatus(String status) throws Exception {
        if (status.contains("Employed"))
            offset = 30;
        if (status.contains("Self-Employed"))
            offset = 60;
        if (status.contains("Not Employed"))
            offset = 90;
        SelectFromDropDown(kiwiSaverPage.EmploymentStatusField, offset);
    }

    @And("user selects Voluntary Contribution {string}")
    public void userSelectsVoluntaryContribution(String Contribution) throws Exception {
        if (!Contribution.isEmpty())
            PerformActionOnElement(kiwiSaverPage.Vol_Contribution, "Type", Contribution);
    }

    @And("user selects Voluntary Contribution frequency {string}")
    public void userSelectsVoluntaryContributionFrequency(String frequency) throws Exception {
        if (frequency.isEmpty())
            return;
        if (frequency.contains("Weekly"))
            offset = 40;
        if (frequency.contains("Fortnightly"))
            offset = 80;
        if (frequency.contains("Monthly"))
            offset = 120;
        if (frequency.contains("Annually"))
            offset = 150;
        SelectFromDropDown(kiwiSaverPage.Vol_frequency, offset);
    }

    @And("user selects current KiwiSaver Balance {string}")
    public void userSelectsCurrentKiwiSaverBalanceKiwiSaverBalance(String KiwiSaverBalance) throws Exception {
        if (!KiwiSaverBalance.isEmpty())
            PerformActionOnElement(kiwiSaverPage.KiwiSaverBalance, "Type", KiwiSaverBalance);
    }

    @And("user enter the value {string} as savings goal at retirement")
    public void userEnterTheValueAsSavingsGoalAtRetirement(String SavingGoal) throws Exception {
        PerformActionOnElement(kiwiSaverPage.SavingsGoal, "Type", SavingGoal);
    }

    @When("the user clicks {string}")
    public void theUserClicks(String message) throws Exception {
        PerformActionOnElement(kiwiSaverPage.Retirement_projections, "Click", "");
    }
}
