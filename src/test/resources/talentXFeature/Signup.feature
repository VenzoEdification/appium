Feature: Signup

  Scenario: SIGNUP
    Given The Talntx Application is launched
    Then Click Signupbutton
    Then Click Name
    When Enter Name "Name"
    Then Enter Date of Birth "DOB"
    Then Select Gender
    Then Enter Mobile Number "Mobile Number"
    Then click Terms and Agreement
    Then CLick Send Code