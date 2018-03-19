Feature: Validating today deal on home page

  @Test1
  Scenario: Validate amazon
    Given Launch Amazon Application using Chrome broswer and https://www.amazon.in/ url
    Then Validate Today Deal
    Then Click on SeeAllDealsLink link
    Then Closed the driver
