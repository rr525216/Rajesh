Feature: google Search feature
@smoke
Scenario: google search scenario

Given user should be on google
When user enters text to search 
And click on google saerch button
Then multi[le results on that topic should be displayed
@smoke
Scenario: google Image search scenario

Given user should be on google
When user click on images link
And user enter text to saerch image and submit
Then title should change according top search text

