Feature: feature is to check the functionality of Demo Web Shop
@login
Scenario Outline: validate the login functionality with Invalid credentials
Then user enters into "<url>" Demo Web Shop
And user should enter "<email>" in email text box
And user should enter "<password>" in password text box
Then user should clicks on login button
Then An error message is generated


Examples:
|url                              |email                  |password|
|https://demowebshop.tricentis.com/|keerthi123486@gmail.com|Keerthi@128|
