Feature: Login with valid credentials 

Scenario: successful login with valid credentials 
	Given the user navigates to login page
	When user enters username as "student" and password as "Password123"
	And user clicks on the submit button
	Then the user should be redirected to MyAccount page