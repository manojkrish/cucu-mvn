Feature: AdminProject
    To help the login and logout functions are working as expected.
    
  Scenario: Verify Successful Login
    Given Open Browser
    Then enter the url as "https://workspaces.active.ai/"
    When workspaces login page is displayed
    Then username field is visible
    And password field is visible
    Then enter the username as "automationtester7@gmail.com" and password as "Tester@123$"
    And click on the login button
    And observe login success message is displayed
    And click on the logout button
    And close Browser

  Scenario: Verify failed Login attempt with Invalid Credentials
    Given Open Browser
    Then enter the url as "https://workspaces.active.ai/"
    When workspaces login page is displayed
    Then username field is visible
    And password field is visible
    Then enter the username as "automationtesters7@gmail.com" and password as "m0rFeu5s"
    And click on the login button
    And observe invalid credentials login message is displayed
    And close Browser

  Scenario: Verify failed Login attempt with Empty Password
    Given Open Browser
    Then enter the url as "https://workspaces.active.ai/"
    When workspaces login page is displayed
    Then username field is visible
    And password field is visible
    Then enter the username as "automationtester7@gmail.com" and password as ""
    And click on the login button
    Then observe empty field validation appears in the password field
    And close Browser

  Scenario: Verify failed Login attempt with Empty User Name
    Given Open Browser
    Then enter the url as "https://workspaces.active.ai/"
    When workspaces login page is displayed
    Then username field is visible
    And password field is visible
    Then enter the username as "" and password as "Tester@123$"
    And click on the login button
    Then observe empty field validation appears in the username field
    And close Browser

  Scenario: Verify failed Login attempt with Empty Username & Empty password
    Given Open Browser
    Then enter the url as "https://workspaces.active.ai/"
    When workspaces login page is displayed
    Then username field is visible
    And password field is visible
    Then enter the username as "" and password as ""
    And click on the login button
    Then observe empty field validation appears in the username and password field
    And close Browser
