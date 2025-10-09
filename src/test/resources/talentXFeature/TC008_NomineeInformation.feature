Feature: Nominee Information

Scenario: TC008_Nominee Information
Given The Profile page should display
  Then Click Nominee Tab
  Then Click Nominee Name
  When Enter Nominee Name "Nominee Name"
  Then Click Nominee Aadhar Number
  When Enter Nominee Aadhar Number "Nominee Aadhar Number"
  Then Click Relationship
  Then Select Relationship
  Then Click DOB
  Then Click Address Line
  When Enter Address  "Address"
  Then Click City
  Then Click Search City
  When Enter the City  "city"
  Then Click Select City
  Then Click Pincode
  When Enter the Pincode "pincode"
  Then Click Update Button
