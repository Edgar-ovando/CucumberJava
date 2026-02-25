Feature:  Login

  @sanity
  Scenario: Successful login with Valid Credentials
    Given User launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "nopCommerce demo store. Login"
    And close browser

  @regression
  Scenario Outline: Login Data Driven
    Given User launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enter Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "nopCommerce demo store. Login"
    And close browser

    Examples:
    |email| |password|
    |admin@yourstore.com||admin|
    |admin1@yourstore.com||admin123|
