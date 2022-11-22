Feature: login feature
@smoke
Scenario: Login function
Given user is on Signin  page
Then user enters "rajesh123@gmail.com" and "rajesh@123"
And user click on singnin button