Feature: Google Login Form Access

  Scenario: User can access the Google login form
    Given the user is on the Orange HRM Login page
    When the user input "Username" and "Password"
    Then the user click Login button
    And redirect to Dashboard page