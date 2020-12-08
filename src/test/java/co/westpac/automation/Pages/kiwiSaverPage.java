package co.westpac.automation.Pages;

import WebConnector.webConnector;

public class kiwiSaverPage extends webConnector {
    webConnector wc = new webConnector();
    public String Get_started = "xpath, //*[@id=\'content-ps\']/div[2]/div/section/p[4]/a";
    public String CurrentAgeIcon = "xpath, //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/button";
    public String CurrentAgeMessage = "xpath, //*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div/p";
    public String CurrentAgeTextField = "xpath, //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div[1]/div/div/input";
    public String EmploymentStatusField = "xpath,  //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div[1]/div";
    public String SalaryField = "xpath,  //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input";
    public String KiwiSaverBalance = "xpath, //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input";
    public String ContributionPercentage3 = "xpath, //*[@id=\"radio-option-04C\"]";
    public String ContributionPercentage4 = "ID, radio-option-04F";
    public String RiskProfile_Defensive_Radio = "ID, radio-option-013";
    public String RiskProfile_Conservative_Radio = "ID, radio-option-016";
    public String RiskProfile_Balanced_Radio = "ID, radio-option-019";
    public String main = "ID, main";
    public String Retirement_projections = "xpath, /html/body/div[1]/div/div/div[1]/div/div[2]/button/span[2]";
    public String Retirement_projections1 = "xpath, /html/body/div[1]/div/div/div[1]/div/div[2]/button";
    public String Vol_Contribution = "xpath, //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]/div/input";
    public String Vol_frequency = "xpath, //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div";
    public String SavingsGoal = "xpath, /html/body/div[1]/div/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input";
    public String KiwiSaverResult = "xpath, /html/body/div[1]/div/div/div[1]/div/div[3]/div/div[1]/div[1]/div[1]/span[2]";
    public String EmploymentStatusIcon = "xpath, //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/button";
    public String kiwiBalanceIcon = "xpath, //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[2]/div/div/div/button";
    public String Vol_ContributionIcon = "xpath, //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[2]/div/div/div/button";
    public String RiskProfileIcon = "xpath, //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[5]/div/div/div/div[2]/div[2]/div/div/div/button";
    public String SavingsGoalRetIcon = "xpath, //*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[2]/div/div/div/button";

    public void clickOnMenu(String Menu) throws Exception {
        if (Menu.contains("Click here to get started"))
            wc.PerformActionOnElement(Get_started, "Click", "");
        if (Menu.contains("view your kiwisaver retirement projections")) {
            wc.PerformActionOnElement(Retirement_projections, "Click", "");
        }
    }

    public void selectContribution(String contribution) throws Exception {
        if (contribution.isEmpty())
            return;
        if (contribution.contentEquals("3"))
            wc.PerformActionOnElement(ContributionPercentage3, "Click", "");
        if (contribution.contentEquals("4"))
            wc.PerformActionOnElement(ContributionPercentage4, "Click", "");
    }

    public void selectRiskProfile(String RiskProfile) throws Exception {
        if (RiskProfile.contains("Defensive"))
            wc.PerformActionOnElement(RiskProfile_Defensive_Radio, "Click", "");
        if (RiskProfile.contains("Conservative"))
            wc.PerformActionOnElement(RiskProfile_Conservative_Radio, "Click", "");
        if (RiskProfile.contains("Balanced"))
            wc.PerformActionOnElement(RiskProfile_Balanced_Radio, "Click", "");
    }
}
