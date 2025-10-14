Feature: Contractor Employer With Aadhar
  Background:

    Given Talntx Application is launched
    Then Enter Mobile number "Mobile Number"
    When click Terms and Agreement
    Then click Send Code
    Then Enter otp
    Then Click verify

  Scenario: TC0012_Contractor Employer With Aadhar
    Given Home Page is Visible
    Then Click Add Talent Icon
    And Enter MobileNumber "Mobile Number"
    And Enter AadharNumber "Aadhar Number"
    And Click Confirm Button
    Then Validate talent Added
    Then AppClose



