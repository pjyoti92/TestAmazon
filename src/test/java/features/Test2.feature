Feature: Validating SeeAllDealsLink

  @Test2
  Scenario: Validate amazon
    Given Launch Amazon Application using Chrome broswer and https://www.amazon.in/ url
    When Click on SeeAllDealsLink link
    Then Validate deals displayed in new page
    Then Closed the driver
