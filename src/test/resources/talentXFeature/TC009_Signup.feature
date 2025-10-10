Feature: Signup

  Scenario: TC009_Signup
    Given The Talntx Application is launched
    Then Click Signupbutton
    Then Click Name
    When Enter Name "Name"
    Then Enter Date of Birth "DOB"
    Then Select Gender
    Then Enter Mobile Number "Mobile Number"
    Then Click Terms and Agreement
    Then CLick Send Code