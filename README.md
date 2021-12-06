# selenium Framework with JAVA + BDD(Cucumber)+maven+log4j2

Behavioural driven development automation framework using selenium, cucumber-java, testng, maven, phantomjs


## Tools and technologies used:

1. Language: Java 8
2. Testing framework: Testng
3. BDD framework: Cucumber jvm
4. Automation tool: Selenium webdriver
5. Build tool: maven
6. Logging: log4j2
7. Reporting:cucumber reports 


## Features of the framework
1. BDD framework using Cucumber-jvm. Feature files can be written easily using Given,When, Then etc.
2. Browser(chrome/firefox) can be configured at run time  from command line (or Continuous integration tool, if configured).
3.Html report will be  generated after each test run and can be found /target/cucumber-report/cucumber-html-report/feature-overview.html


**package: src/tes/resources/features** : It contains all different features (tests) files and the feature related test data file.
**package: src/tes/java/utils/drivers** : It contains two class to download,setup webdriver(Chrome driver and firefox driver).

**package: src/test/java/utils/helpers** : It includes the common classes (and methods) which are required by each test to perform actions. Below are classes in this package:

1.JSONHelper.java** : It contains assertion methods like verifyEquals,screenshot etc. These can be used in any of the helper files to verify the actual result with expected result.

2.WebDriverHelper.java** : It is a common repository for all the webdriver methods which are used in every class present under logic package to perform actions like click, findElement etc. Every new method which is being used in logic classes should be added in this class as well. It is to reduce the duplicate code. Each page class extends this class.

3.WebElementsHelper.java** :  It is a common repository for all the weblements methods which are used in every class present under logic package to perform actions like click, check element is visiable or clickable etc

4.TestRunner.java** : Features/tests to be executed are defined in this class. Other test configurations are also defined here.

**package: hooks :** contains all the hooks  where actions should be executed before the feature and scenarios happens,ie start webdriver and quit webdriver after test finishs..

**package: selenium :** contains all selenium related files,inlcuding
1.Driver.java** : It is an exposed  class to be used by pages..

2.DriverController.java** : It is a class to switch webdirver based on browser type..

3.Settings.java** :  It is a common settings file for selenium execution. ie. waitime for selenium to static wait before timeout, baseurl for the testing url.

**package:scr/test/java/pages :** It has web elements corresponding to the specific page which is used by corresponding step classes.


## Test report ##

Once test execution is completed, go to target/cucumber-reports/cucumber-html-reports folder and open feature-overview.html file

You can see the test results at different level


# Setting up the project

Install the maven and clone the build then:

**$ cd SeleniumFramework**

**$ mvn clean install**


## Execution of tests
There are 1 feature and 2 scenarios .

To run both scenarios (@scenario1 and @scenario2) (by default browser would be chrome):

**$ mvn test**

To run test with configurable browser (for firefox, use -Dbrowser=firefox)

**$ mvn test -Dbrowser=chrome**


To run specific scenario:

**$ mvn test -Dcucumber.options="--tags @scenario2"**

To run multiple mentioned scenarios:

**$ mvn test -Dcucumber.options="--tags @scenario1,@scenario2"**

To run differnt user input:
1. modify the \SeleniumFramework\src\test\resources\features\test_data\customerInfo.json ,setting all the input value,eg. the income,living expenses,  and the expected loan ammount.
2. execute **$ mvn test -Dcucumber.options="--tags @scenario1"**

