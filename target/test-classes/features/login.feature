Feature: feature is to check the functionality of Demo Web Shop
Scenario: validate the login functionality with Invalid credentials
Given Open Browser
Then user enters into "<url>" Demo Web Shop
And user should enter "<email>" in email text box
And user should enter "<password>" in password text box
Then user should clicks on login button
Then An error message is generated
And close the browser

Examples:
|url                              |email                  |password|
|https://demowebshop.tricentis.com/|keerthi123486@gmail.com|Keerthi@128|
