
Feature: To check the functionality of removing Product From Cart

  @remove
  Scenario Outline: To remove product from cart
    Given user enters into "<url>" the url Demo Web Shop
    And user should enter "<email>" and "<password>" in email and password textbox and login
    Then user should jewelry to cart
    Then user should update cart product
    And user should remove the product
 
 Examples:
|url                              |email              |password      |
|https://demowebshop.tricentis.com/|keeru123@gmail.com|7VMNJ4EWA#svY9|
    


