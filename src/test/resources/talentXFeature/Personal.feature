Feature: Personal Details


  Scenario Outline: Personal Details
    Given The Personal page is visible
    Then Click Nationality
    Then CLick Indian
    Then Click Blood Group
    When Enter Blood Group "<Bloodgroup>"
    Then Click FatherName
    When Enter FatherName "<Father Name>"
    Then CLick Email
    When Enter Email
    Then Click Address Line
    When Enter Address Line "<Address Line>"
    Then Click City
    When Enter the City name "<City>"
    Then Click Pincode
    When Enter the PinCode "<Pincode>"
    Then Click Upload Image
    When Upload the Profile image "<Profile Image>"
    Then Click Update Button
    Then The Profile page should display



    Examples:
      | Bloodgroup | | Father Name | | Address Line | | City | | Pincode | | Profile Image |
      | Bloodgroup | | Fathername | | Address | | City | | Pincode | | Image |