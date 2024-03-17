Feature: Travel Insurance Plans

  Scenario: TravelInsurancePlans
    Given User is on the PolicyBazaar homepage
    When user need to fill all travel insurance details
    And user need to fill all car insurance details
    Then user need to fill all health insurance details
    And driver should close the browser
