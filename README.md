# ITBootcamp_Final_Selenium_Project

This is the final project for the IT Bootcamp, focusing on software application testing with Selenium and TestNG libraries.

## Technologies Used
- ***Java***
- ***Maven***
- ***Selenium***
- ***TestNG***
- ***Git***

## Project Description
The project involves automated functional testing of a web application, [My awesome App](https://vue-demo.daniel-avellaneda.com), using Selenium and TestNG libraries. The tests are organized and implemented using the Page Object Model (POM) for structured organization.

## Tasks Completed
1. Automated functional testing of the web application
2. Implementation of Page Object Model (POM) for structured organization of automated tests
3. Utilization of Selenium library for web-page interaction
4. Test implementation for:
    - *Login*
    - *Registration*
    - *Administering location*
    - *Language modulation*

## Test Scenarios
The project consists of 28 tests arranged into 6 test scenarios:

- [x] **Login tests**: Verifying user login functionality
- [x] **Signup tests**: Verifying user signup functionality
- [x] **Admin Cities tests**: Testing functionalities for creating, editing and deleting cities
- [x] **Auth Routes tests**: Testing route protection for unauthenticated users
- [x] **Locale tests**: Testing page content in different languages
- [x] **Profile tests**: Testing profile page form and its functionalities

All test cases for this project can be found [here](TEST_CASES.md)

## Running the Tests
Tests are being organized and implemented using testng.xml and run with the following command line:
**mvn clean test -Dsurefire.suiteXmlFiles=testng.xml**