#Author: Eni Selvi
Feature: Cauculate KiwiSaver Retirement

  Scenario: kiwiSaver Retirement Calculator has icons and icon description for all fields.

    Given The user navigate to homePage
    When the user mouse over on KiwiSaver option and selects kiwiSaverCalculator
    And the user Clicks on the menu "Click here to get started"
    Then the "KiwiSaver Retirement Calculator - Westpac NZ" page is displayed
    When the user Clicks on the icon beside "Current age"
    Then the following message is displayed "This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver."

  Scenario: KiwiSaver Retirement Calculator contains icons for all fields in the calculator page

    Given The user navigate to homePage
    When the user mouse over on KiwiSaver option and selects kiwiSaverCalculator
    When the user Clicks on the menu "Click here to get started"
    And the "KiwiSaver Retirement Calculator - Westpac NZ" page is displayed
    And the user verifies all fields in the calculator have got the information icon

  Scenario Outline: KiwiSaver Retirement Calculate calculates projected balance during retirement age

    Given The user navigate to homePage
    When the user mouse over on KiwiSaver option and selects kiwiSaverCalculator
    And the user Clicks on the menu "Click here to get started"
    Then the "KiwiSaver Retirement Calculator - Westpac NZ" page is displayed
    And user enter the age "<Age>"
    And user selects the employment status "<EmploymentStatus>"
    And user enter the salary "<Salary>"
    And user selects KiwiSaver contribution "<KiwiSaverContribution>"
    And user selects current KiwiSaver Balance "<KiwiSaverBalance>"
    And user selects Voluntary Contribution "<VoluntaryContribution>"
    And user selects Voluntary Contribution frequency "<VoluntaryConFrequency>"
    And user sets the risk profile as "<RiskProfile>"
    And user enter the value "<SavingsGoal>" as savings goal at retirement
    When the user clicks "View your KiwiSaver retirement projections"
    Then Projected balance at retirement is calculated

    Examples:
      | Age | EmploymentStatus | Salary | KiwiSaverContribution | KiwiSaverBalance | VoluntaryContribution | VoluntaryConFrequency | RiskProfile  | SavingsGoal |
      | 30  | Employed         | 82000  | 4                     |                  |                       |                       | Defensive    |             |
      | 45  | Self-Employed    |        |                       | 100000           | 90                    | Fortnightly           | Conservative | 290000      |
      | 55  | Not Employed     |        |                       | 140000           | 10                    | Annually              | Balanced     | 200000      |
