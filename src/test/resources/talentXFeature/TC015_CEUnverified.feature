Feature: Contractor Employer UnVerified
  Background:
    Given Talntx Application is launched
    Then Enter Mobile number "Mobile Number"
    When click Terms and Agreement
    Then click Send Code
    Then Enter otp
    Then Click verify


  Scenario: TC015_Contractor UnVerified
    Then Click UnVerified Menu
    Then CLick Incomplete Tab
    Then CLick IncompleteTalentName
    Then Validate talent Added
    Then CLick Profile Back Button
    Then Click Yet to be verified tab
    Then CLick Yet to Verified TalentName
    Then Validate talent Added
    Then AppClose
