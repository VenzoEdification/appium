Feature: Contractor Employer Without Aadhar
  Background:

    Given Talntx Application is launched
    Then Enter Mobile number "Mobile Number"
    When click Terms and Agreement
    Then click Send Code
    Then Enter otp
    Then Click verify

  Scenario: TC0013_Contractor Employer Without Aadhar
    Given HomePage is Visible
    Then Click Add Talent Icon
    And Enter mobileNumber
    And Enter aadharNumber
    Then Enter TalentName "Name"
    Then Enter DateofBirth "DOB"
    Then Click Confirm Button
    Then Validate talent Added
    Then AppClose




