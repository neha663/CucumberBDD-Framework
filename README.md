# CucumberBDD-Framework
## Overview ##
Performs user acceptance testing using selenium with cucumber BDD framework.

## Setup/Configuration process:
Installed Java8 version and installed maven in windows and setup the environment variables path.(jrehome, jdkhome and mvn home).
Maven version 3.8.1
Configure cucumber libraries from mvnrepository to pom.xml
Configure selenium libraries from mvnrepository to pom.xml
Configure webdrivermanager libraries from mvnrepository to pom.xml
Install cucumber plugins from eclipse marketplace.
After adding all the dependencies Do maven clean and build the maven project.

## How to Run test scenarios?
Provide the tagname of the scenarios in RunCucumberTest.java (example: @verifyFourModuleMenuOptions to run only one scenario in feature file)
Provide the tagname of the scenarios in RunCucumberTest.java (example: @Regression1 to run all scenarios in feature file)
Right click on RunCucumberTest.java
Select RunAs
Click on Junit Test
Your script should start running

### Note: 
If we want to skip tests provide the scenario tagname as "~@tagname" in RunCucumberTest.java file

## Framework File details:
Create SDET_TechnicalTest.feature file in src/test/resources/features folder
Add scenarios and provide the tagnames.
Create step definition file for generic scenarios like clickstep, verifysteps, fillsteps, commonsteps.
Create Hooks.java to execute the before step execution process.
Create RunCucumberTest.java file to execute the test scenarios with tagname.

## ObjectRepo:
Capture objects in OR.json file in key and value pair.
We can provide xpath, cssselector, linktext, partiallinktext, id, name
readOR.java file will handle above locators provided in json file

## runConfig.Properties
Provide the browser type like chrome
Provide the OS type
Provide the Environment type like qa
Feature file path
Report generation path
Need pass Screenshot false/true

## ReportManager.java
Generate the html report, it will be saved in the fold location provided in runConfig.Properties

## WebDriverFactory.java
Launch the different browsers based on the browser type provided in runConfig.Properties

## CreateDriver.java
Driver instance is created and delete all cookies after launching the browser.
