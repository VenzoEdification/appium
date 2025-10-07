Feature: Government ID's

  Scenario: TC006_Government ID's
    Given The Profile Details is visible
    Then Click Government ID's
    When Enter and Verify Aadhar Number "Aadhar Number"
    When Enter and Verify PAN Number "PAN Number"
    Then Upload Aadhar
    Then Upload Pan
    Then Click Update Button
    Then The Profile page should display

