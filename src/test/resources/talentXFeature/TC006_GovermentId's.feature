Feature: Government ID's

  Scenario: TC006_Government ID's
    Given The Profile Details is visible
    Then Click Government ID's
    Then Click Aadhar Number
    When Enter Aadhar Number "Aadhar Number"
    Then Click Verify
    Then Click PAN Number
    When Enter PAN Number "PAN Number"
    Then Click Verify
    Then Click Upload Aadhar
    Then Click Camera
    Then Click Camera Button
     Then click Ok button
    Then Click Upload Pan
    Then Click Camera
    Then Click Camera Button
    Then Click Ok Button
    Then Click Update Button
    Then The Profile page should display

