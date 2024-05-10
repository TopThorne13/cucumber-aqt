Feature: Login functionality

  Scenario: Check login is successful with valid credentials
    Given user is on the login page
    When User enters "<UserName>" as UserName and "<Password>" as Password
    And User clicked on Submit Button
    Then User is landed to the homepage
    
    Examples:
    |UserName|Password|
    |test1	 |test123 |
    |test2	 |test123 |
    |student |Password123|
    