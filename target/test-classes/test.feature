Feature: Google search

 
  Scenario Outline: Login Scenario - TC1
  
    Given As a user i see a Login Page
    And I enter <Username> and <Password>
    When I click on Signin button
    Then i see the Inbox page
    
    Examples:
    	| Username | Password |
    	| adhitya.s@gmail.com | abc |