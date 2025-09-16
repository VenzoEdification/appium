Feature: Login Mobile App

  Scenario Outline: Verify the app opens correctly
    Given the TALENTx app is launched
    Then click allow button
    When enter the value "<phoneNumber>"
    When click Terms and Agreement
    Then click Send Code
   Then enter otp
    Then click verify


    Examples:
      | phoneNumber |
      | phoneNumber |

