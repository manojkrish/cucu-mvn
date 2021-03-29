Feature: AdminProject
    To help the login and logout functions are working as expected.
    
  Scenario: Verify Successful Login
    Given Open Browser
    Then enter the url as "https://admin20m.active.ai/"
    When workspaces login page is displayed
    Then username field is visible
    And password field is visible
    Then enter the username as "morfeus@active.ai" and password as "m0rFeu5"
    And click on the login button
    And observe login success message is displayed
    And click on the logout button
    And close Browser