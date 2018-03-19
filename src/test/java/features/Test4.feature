Feature: Validating SignIn

  @Test4
  Scenario: Validate amazon
    Given Launch Amazon Application using Chrome broswer and https://www.amazon.in/ url
    When Click on SeeAllDealsLink link
    Then Validate deals displayed in new page
    Then Hover on Category link
    When Click on BabyLink link
    Then Hover on Category link
    Then Wait for 2 seconds
    When Click on BeautyLink link
    Then Wait for 2 seconds
    Then Took the snapshot
    Then Navigate back to Amazon Page
    Then Click on SignInLink link
    Then Input vpjyoti92@gmail.com on UserId inputbox
    Then Click on ContinueButton link
    Then Input shakuntla@123 on Password inputbox
    Then Click on LoginButton link
    Then Validate the logged in user
    Then Closed the driver
