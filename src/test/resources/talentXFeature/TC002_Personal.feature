Feature: Personal Details

  Scenario: Personal Details
    Given The Profile Details is visible
    Then Click Personal Tab
    Then Click Nationality
    Then Click Indian
    Then Click Blood Group
    When Enter Blood Group "BloodGroup"
    Then Click FatherName
    When Enter FatherName "FatherName"
    Then Click Email
    When Enter Email
    Then Click Address Line
    When Enter Address Line "AddressLine"
    Then Click City
    When Enter the City name "City"
    Then Click Pincode
    When Enter the PinCode "Pincode"
    Then Click Upload Image
    When Upload the Profile image "ProfileImage"
    Then Click Update Button
    Then The Profile page should display
