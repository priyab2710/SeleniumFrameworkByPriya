Feature: Application login
Scenario: Verify login
Given Initialize the browser
And Navigate to "http://automationpractice.com/index.php" website
And click on login page link
When user enters correct "username@testing.com" and "Password"
And clicks on log in button
Then verify user is logged in successfully
