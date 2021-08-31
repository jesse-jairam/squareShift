## Setting up the properties files

The primary purpose of this refactor is to create a system where tests can be organized into any number of combinations to be run against any number of environments using any number of browsers.

### Using subsuites
For better organization, we are using the barely documented sub suite feature of TestNG. With this, we can organize tests into browser-specific groups and then reference tests by the browser in the top-level suite.
SubSuites inherit parameter settings from their parents, so `parameter` attributes can be added at whatever level in the suite hierarchy makes the most sense.

After assembling a configuration, add test classes to the file as specified in the [TestNG documentation](http://testng.org/doc/documentation-main.html#testng-xml).


## Writing tests
The design of individual tests was strongly influenced by the Page Object Model, which is a common design pattern used in browser automation testing.

The pattern requires three types of classes:

State classes, which expose an API to locate, manipulate, and retrieve the state of elements on the page.
Module Classes, which contain methods to avoid code redundancy, such methods are written by clubbing set of actions frequently performed in a series.
Test classes, which perform the UI manipulation to execute the tests and evaluate the results using the state classes. Because we are testing components instead of specific pages, our classes are page agnostic and component-specific. We could call them Component Object Model, but that ship has already sailed.

## Executing a test 
Once you've got a complete configuration file, select it as a command-line option to the mvn executable using the -D option.

mvn test -Dsurefire.suiteXmlFiles=src/test/resources/suites/mysuite.xml
