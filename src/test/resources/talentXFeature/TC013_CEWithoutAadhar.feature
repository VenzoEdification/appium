Feature: Contractor Employer Without Aadhar

  Scenario: TC0013_Contractor Employer Without Aadhar
    Given HomePage is Visible
    Then Click Add Talent Icon
    And Enter mobileNumber
    And Enter aadharNumber
    Then Click Without AadharNumber
    Then Enter TalentName "Name"
    Then Enter DateofBirth "DOB"
    Then Select Gender
    Then Click Confirm Button


  Scenario: TC002_Personal Details
    Given The Profile Details is visible

    Then Click Personal Tab
    Then Click Nationality
    Then Click Indian
    Then Click Blood Group
    Then Click Blood Group Type
    Then Click FatherName
    When Enter FatherName "FatherName"
    Then Click Date of Birth
    Then Click Email
    When Enter Email
    Then Click Address Line
    When Enter Address Line "AddressLine"
    Then Click City
    Then Click Search City
    When Enter the City name "city"
    Then Click Select City
    Then Click Pincode
    When Enter the PinCode "pincode"
    Then Click Upload Image
    Then Click Camera
    Then Click Camera Button
    Then Click Ok Button
    Then Click Crop Button
    Then Click Update Button
    Then The Profile page should display
