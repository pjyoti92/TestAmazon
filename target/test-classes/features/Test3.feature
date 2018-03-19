Feature: Validating Category Selection , Switching Back

  @Test3
  Scenario: Validate amazon
    Given Launch Amazon Application using Chrome broswer and https://www.amazon.in/ url
    When Click on SeeAllDealsLink link
    Then Validate deals displayed in new page
    Then Hover on Category link
    When Click on BabyLink link
    Then Hover on Category link
    When Click on BeautyLink link
    Then Took the snapshot
    Then Navigate back to Amazon Page
    Then Click on SignInLink link
    
