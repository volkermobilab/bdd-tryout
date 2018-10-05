# Behaviour Driven Design - Experiment

This project is a first experiment using [Cucumber](https://cucumber.io/) to try out some behaviour driven design and 
doing test driven development for a simple REST API implemented using Spring Boot.

Most of all, you can just run `mvn clean install` and see a (hopefully) successful test being run. 

Most interesting are probably the feature files in [src/test/resources](/src/test/resources) and the step definition in [StepDefinitions.java](/src/test/java/com/mobilabsolutions/bdd/bddtryout/StepDefinitions.java). 
The REST API is a simple CRUD API used to create user accounts and doesn't do anything special.
