@regtest
Feature: Title of your feature
@login
 Scenario Outline: Guru99 login function
 Given user is on login 
 When user enter <username> and <password>
 Then user click on login button
 Then close all browsers

    Examples: 
      |username      | password          |
      |     "Rajesh" | "rajesh@123"   |
    #  |   "Jilan123" | "jilan@123"    |
     # |"mngr396089"  | "darEzUs"      |
