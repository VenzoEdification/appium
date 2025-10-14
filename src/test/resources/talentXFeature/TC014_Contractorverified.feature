Feature: Contractor Employer Verified
  Background:
    Given Talntx Application is launched
    Then Enter Mobile number "Mobile Number"
    When click Terms and Agreement
    Then click Send Code
    Then Enter otp
    Then Click verify


  Scenario: TC014_Contractor Verified
    Given Homepage should displayed
    Then Click Verified Menu
    Then CLick Available Tab
    Then CLick AvailableTalentName
    Then Validate talent Added
    Then CLick Profile Back Button
    Then Click Employed tab
    Then CLick TalentName
    Then Validate talent Added
    Then AppClose




