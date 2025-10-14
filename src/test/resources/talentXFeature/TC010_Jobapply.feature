Feature: Job Apply
  Background:
    Given the TALENTx app is launched
    When enter the value "phoneNumber"
    When click Terms and Agreement
    Then click Send Code
    Then enter otp
    Then click verify


  Scenario:TC010_Job Apply
    Given The Profile page should display
    Then Click Job Tab
    Then Enter Job in Search "Job"
    And Click Job View Button
    Then Job Apply
    Then AppClose




